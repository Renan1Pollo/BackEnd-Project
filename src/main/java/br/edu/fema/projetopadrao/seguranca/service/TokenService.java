package br.edu.fema.projetopadrao.seguranca.service;

import java.io.UnsupportedEncodingException;
import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Base64;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;

@Service
public class TokenService {

	@Value("${token.senha}")
	private String senhaApi;

	public boolean isTokenValido(String token) {
		try {
			Jwts.parser().setSigningKey(Base64.getEncoder().encodeToString(this.senhaApi.getBytes()))
			.parseClaimsJws(token);
			return true;
		}catch(Exception e) {
			System.out.println(e.getLocalizedMessage());
			return false;
		}

	}

	public Long getIdUsuario(String token) {
		Claims body = Jwts.parser().setSigningKey(Base64.getEncoder().encodeToString(this.senhaApi.getBytes())).parseClaimsJws(token).getBody();
		return Long.parseLong(body.getSubject());
	}
	
	public String geraAccessTokenHash(HttpServletRequest request, String token) throws UnsupportedEncodingException {
		MessageDigest sha;		
		try {
			sha = MessageDigest.getInstance("SHA-512");
			sha.reset();
			String ip = request.getRemoteAddr();
			String userAgent = request.getHeader("user-agent");
			
			try {
				String concatenacao = ip + userAgent + token;
				sha.update(concatenacao.getBytes("utf8"));
				return String.format("%0128x", new BigInteger(1, sha.digest()));
			}catch(Exception e) {
				String concatenacao = ip + token;
				sha.update(concatenacao.getBytes("utf8"));
				return String.format("%0128x", new BigInteger(1, sha.digest()));
			}
			
		} catch (NoSuchAlgorithmException e1) {
			return null;
		}
		
	}
	
	
}