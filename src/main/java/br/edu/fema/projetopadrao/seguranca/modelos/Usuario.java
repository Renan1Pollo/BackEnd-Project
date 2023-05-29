package br.edu.fema.projetopadrao.seguranca.modelos;

import java.util.Collection;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import javax.validation.constraints.Size;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

@Entity
@Table(name = "adm_usuario", schema = "admin")
public class Usuario implements UserDetails{

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_usuario")
	private Long id;

	@Size(max = 50)
	private String nome;
	
	@Size(max = 1)
	private String bloqueado;

	@Size(max = 70)
	private String email;

	@Size(max = 100)
	private String imagem;

	@Column(name = "nhase")
	@Size(max = 300)
	private String senha;
	
	@Size(max = 50)
	@Column(name = "ultimo_acesso")
	private String ultimoAcesso;

	@Size(max = 20)
	private String login;

	@Size(max = 200)
	private String token;
	
	@Size(max = 1)
	private String dashboard;

	@Column(name="access_token_atual")
	private String accessTokenAtual;
	
	@Column(name="access_token_hash")
	private String accessTokenHash;
	
	@ManyToMany()
	@JoinTable(name = "adm_usuario_permissao", joinColumns = @JoinColumn(name = "id_usuario"), inverseJoinColumns = @JoinColumn(name = "id_permissao"))
	private List<Permissao> permissoes;


	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		return null;
	}

	@Override
	public String getPassword() {
		return this.senha;
	}

	@Override
	public String getUsername() {
		return this.login;
	}

	@Override
	public boolean isAccountNonExpired() {
		return true;
	}

	@Override
	public boolean isAccountNonLocked() {
		return true;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		return true;
	}

	@Override
	public boolean isEnabled() {
		return true;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	
	public String getBloqueado() {
		return bloqueado;
	}

	public void setBloqueado(String bloqueado) {
		this.bloqueado = bloqueado;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
	
	public String getImagem() {
		return imagem;
	}

	public void setImagem(String imagem) {
		this.imagem = imagem;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}
	
	public String getUltimoAcesso() {
		return ultimoAcesso;
	}

	public void setUltimoAcesso(String ultimoAcesso) {
		this.ultimoAcesso = ultimoAcesso;
	}

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getToken() {
		return token;
	}

	public void setToken(String token) {
		this.token = token;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
	public void setDashboard(String dashboard) {
		this.dashboard = dashboard;
	}

	public List<Permissao> getPermissoes() {
		return permissoes;
	}

	public void setPermissoes(List<Permissao> permissoes) {
		this.permissoes = permissoes;
	}

	public String getAccessTokenAtual() {
		return accessTokenAtual;
	}

	public void setAccessTokenAtual(String accessTokenAtual) {
		this.accessTokenAtual = accessTokenAtual;
	}

	public String getAccessTokenHash() {
		return accessTokenHash;
	}

	public void setAccessTokenHash(String ccessTokenHash) {
		this.accessTokenHash = ccessTokenHash;
	}
	
}