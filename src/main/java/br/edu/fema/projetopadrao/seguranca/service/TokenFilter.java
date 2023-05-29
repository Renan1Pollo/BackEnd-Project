package br.edu.fema.projetopadrao.seguranca.service;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.time.LocalDateTime;
import java.util.Optional;
import java.util.stream.Collectors;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.filter.OncePerRequestFilter;
import org.springframework.web.util.ContentCachingRequestWrapper;

import br.edu.fema.projetopadrao.seguranca.config.InputStreamReadRepeatableRequestWrapper;
import br.edu.fema.projetopadrao.seguranca.dto.RequisicaoInvalidaDTO;
import br.edu.fema.projetopadrao.seguranca.modelos.Aplicacao;
import br.edu.fema.projetopadrao.seguranca.modelos.CepeinToken;
import br.edu.fema.projetopadrao.seguranca.modelos.Log;
import br.edu.fema.projetopadrao.seguranca.modelos.Usuario;
import br.edu.fema.projetopadrao.seguranca.repository.AplicacaoRepository;
import br.edu.fema.projetopadrao.seguranca.repository.LogRepository;
import br.edu.fema.projetopadrao.seguranca.repository.LoginRepository;



/**
 * 
 * Classe responsável por implementar a segurança da aplicação.
 * 
 * NÃO ALTERAR, A MENOS QUE SEJA AUTORIZADO A FAZER ISSO!
 * NÃO ALTERAR, A MENOS QUE SEJA AUTORIZADO A FAZER ISSO!
 * NÃO ALTERAR, A MENOS QUE SEJA AUTORIZADO A FAZER ISSO!
 * 
 * @author Luis Franco
 *
 */
public class TokenFilter extends OncePerRequestFilter {

	private TokenService tokenService;
	private LoginRepository usuarioRepository;
	private LogRepository logRepository;
	private AplicacaoRepository aplicacaoRepository;

	private String ruleParaAcessarAplicacao;
	private String idAplicacao;

	public TokenFilter(TokenService tokenService, LoginRepository usuarioRepository, LogRepository logRepository, AplicacaoRepository aplicacaoRepository,String idAplicacao, String ruleNecessaria) {
		this.tokenService = tokenService;
		this.usuarioRepository = usuarioRepository;
		this.logRepository = logRepository;
		this.aplicacaoRepository = aplicacaoRepository;

		this.ruleParaAcessarAplicacao = ruleNecessaria;
		this.idAplicacao = idAplicacao;
	}

	@Override
	protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
			throws ServletException, IOException {

		Boolean precisaValidarAplicacao = !this.idAplicacao.equals("N");
		Boolean aplicacaoPossuiRegraSegurancaParaAcessar = !this.ruleParaAcessarAplicacao.equals("N");
		Boolean podeFazerRequisicao = true;
		
		InputStreamReadRepeatableRequestWrapper wrapper = new InputStreamReadRepeatableRequestWrapper(request);
		
		String token = "";
		CepeinToken cepeinToken = null;
		
		try {

			token = this.recuperarToken(wrapper);
			cepeinToken = new CepeinToken(wrapper);

			
			podeFazerRequisicao = this.tokenService.isTokenValido(token);
			
			if (aplicacaoPossuiRegraSegurancaParaAcessar && podeFazerRequisicao) {
				podeFazerRequisicao = cepeinToken.temPermissao(this.ruleParaAcessarAplicacao);
			}
			
			/*
			if (precisaValidarAplicacao && podeFazerRequisicao) {
				podeFazerRequisicao = this.isAplicacaoDisponivel();
			}
			
			
			if (podeFazerRequisicao) {
				podeFazerRequisicao = this.isUsuarioValido(token, request);
			}
			*/

		} catch (Exception e) {
			podeFazerRequisicao = false;
			response = this.defineRespostaComoNaoAutorizada(response, "Não autorizado!");
		}

		if (podeFazerRequisicao) {
			try {
				this.autenticarUsuario(token);
				filterChain.doFilter(wrapper, response);
			} finally {
				Log log = this.geraLog(wrapper, cepeinToken.getId());
				this.logRepository.save(log);
			}

;
		} else {
			response = this.defineRespostaComoNaoAutorizada(response, "Não autorizado!");
		}
	}

	private Log geraLog(HttpServletRequest requestOriginal, Long idUsuario) throws IOException {
		ContentCachingRequestWrapper request = new ContentCachingRequestWrapper(requestOriginal);
		Log log = new Log();
		log.setMetodo(request.getMethod());

		String url = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
				+ request.getRequestURI();

		if (request.getQueryString() != null) {
			url += "?" + request.getQueryString();
		}

		log.setUrl(url);
		log.setUsuario(this.usuarioRepository.findById(idUsuario).get());
		log.setDataHora(LocalDateTime.now());

		StringBuilder mensagemLog = new StringBuilder();

		mensagemLog.append("IP: " + request.getRemoteAddr());
		mensagemLog.append(" ;@@@; ");
		mensagemLog.append("User-Agent: " + request.getHeader("user-agent"));
		mensagemLog.append(" ;@@@; ");

		if ("POST".equalsIgnoreCase(request.getMethod()) || "PUT".equalsIgnoreCase(request.getMethod())) {
			String requestBody = request.getReader().lines().collect(Collectors.joining(System.lineSeparator()));
			mensagemLog.append("Request-Body: " + requestBody);
		} else {
			mensagemLog.append("Request-Body: Não Possui.");
		}

		log.setLog(mensagemLog.toString());
		return log;
	}

	private boolean isUsuarioValido(String token, HttpServletRequest request) throws UnsupportedEncodingException {
		String tokenHash = this.tokenService.geraAccessTokenHash(request, token);
		Optional<Usuario> usuarioOptional = this.usuarioRepository.findByAccessTokenHashAndAccessTokenAtual(tokenHash,
				token);

		if (!usuarioOptional.isPresent()) {
			return false;
		}

		return usuarioOptional.get().getBloqueado().equals("N");
	}

	private void autenticarUsuario(String token) {
		Long idUsuario = this.tokenService.getIdUsuario(token);
		Optional<Usuario> usuario = this.usuarioRepository.findById(idUsuario);
		UsernamePasswordAuthenticationToken authentication = new UsernamePasswordAuthenticationToken(usuario.get(),
				null, usuario.get().getAuthorities());
		SecurityContextHolder.getContext().setAuthentication(authentication);
	}

	private String recuperarToken(HttpServletRequest request) {
		String token = request.getHeader("Authorization");
		if (token == null || token.isEmpty() || !token.startsWith("Bearer "))
			return null;

		return token.substring(7, token.length());
	}

	private HttpServletResponse defineRespostaComoNaoAutorizada(HttpServletResponse response, String mensagem)
			throws IOException {
		response.setContentType("application/json");
		response.setCharacterEncoding("UTF-8");
		response.setStatus(403);
		response.getWriter().write(new RequisicaoInvalidaDTO(mensagem).toString());
		return response;
	}

	private boolean isAplicacaoDisponivel() {

		Optional<Aplicacao> aplicacaoOptional = this.aplicacaoRepository.findById(Long.parseLong(this.idAplicacao));
		if (aplicacaoOptional.isPresent()) {
			return aplicacaoOptional.get().getVisivel().equals("S");
		}

		return false;
	}

}

