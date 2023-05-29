package br.edu.fema.projetopadrao.seguranca.modelos;

import java.util.Arrays;
import java.util.Base64;
import java.util.Base64.Decoder;
import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang3.StringUtils;

import com.fasterxml.jackson.databind.ObjectMapper;

import lombok.Getter;

/**
 * 
 * @author Luis Henrique Buzzo Franco
 * 
 *         Classe que representa o Access Token do usuário decodificado no
 *         formato padrão do CEPEIN
 */
@Getter
public class CepeinToken {
	
	private List<String> permissoes;
	private String email;
	private Long id;
	private String matricula;
	private String nome;

	/**
	 * O construtor da classe é responsável por efetuar a decodificação do token,
	 * que está presente no header Authorization da request. Esse header sempre está
	 * presente, pois o Sprint Security ja valida isso automaticamente, recusando a
	 * requisição caso esse header não esteja na request.
	 * 
	 * @param request
	 */
	@SuppressWarnings("unchecked")
	public CepeinToken(HttpServletRequest request) {
		try {
			String token = request.getHeader("Authorization");
			token = token.split(" ")[1];

			Decoder decoder = Base64.getUrlDecoder();
			String[] parts = token.split("\\.");

			String payloadJson = new String(decoder.decode(parts[1]));

			HashMap<String, Object> payload = new ObjectMapper().readValue(payloadJson, HashMap.class);

			this.permissoes = (List<String>) payload.get("permissoes");
			this.matricula = (String) payload.get("matricula");
			this.id = Long.parseLong((String) payload.get("sub"));
			this.email = (String) payload.get("email");
			this.nome = formatarNomeUsuario(payload);

		} catch (Exception e) {
			
		}
	}

	public boolean temPermissao(String permissao) {
		return this.permissoes.contains(permissao);
	}
	
	
	private String formatarNomeUsuario(HashMap<String, Object> payload) {
		String[] nomeSeparadoPorEspaco = ((String) payload.get("nome")).toLowerCase().split(" ");
		
		return Arrays.stream(nomeSeparadoPorEspaco)
			.map(StringUtils::capitalize)
			.collect(Collectors.joining(" "));
	}
}