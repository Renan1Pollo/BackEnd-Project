package br.edu.fema.projetopadrao.seguranca.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import br.edu.fema.projetopadrao.seguranca.repository.AplicacaoRepository;
import br.edu.fema.projetopadrao.seguranca.repository.LogRepository;
import br.edu.fema.projetopadrao.seguranca.repository.LoginRepository;
import br.edu.fema.projetopadrao.seguranca.service.TokenFilter;
import br.edu.fema.projetopadrao.seguranca.service.TokenService;

@EnableWebSecurity
@Configuration
public class Configuracoes extends WebSecurityConfigurerAdapter {

	@Autowired
	private TokenService tokenService;

	@Autowired
	private LoginRepository usuarioRepository;
	
	@Autowired
	private LogRepository logRepository;
	
	@Autowired
	private AplicacaoRepository aplicacaoRepository;
	
	@Value("${token.rule.acesso}")
	private String ruleParaAcessarAplicacao;
	
	@Value("${aplicacao.id}")
	private String idAplicacao;

	@Override
	@Bean
	protected AuthenticationManager authenticationManager() throws Exception {
		return super.authenticationManager();
	}

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.authorizeRequests().anyRequest().authenticated().and().csrf().disable().sessionManagement()
				.sessionCreationPolicy(SessionCreationPolicy.STATELESS).and()
				.addFilterBefore(new TokenFilter(this.tokenService, this.usuarioRepository, this.logRepository, this.aplicacaoRepository, this.idAplicacao, this.ruleParaAcessarAplicacao),
						UsernamePasswordAuthenticationFilter.class);
	}

}