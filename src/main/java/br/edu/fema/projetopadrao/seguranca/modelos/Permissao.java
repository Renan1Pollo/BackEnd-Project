package br.edu.fema.projetopadrao.seguranca.modelos;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "adm_permissao", schema = "admin")
public class Permissao {

	@Id
	@Column(name = "id_permissao")
	private Long id;

	@Column(name = "permissao_regra")
	private String descricaoPermissao;
	
	@JsonIgnore
	@ManyToMany(mappedBy = "permissoes", fetch = FetchType.LAZY)
	private List<Usuario> usuarios;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getDescricaoPermissao() {
		return descricaoPermissao;
	}

	public void setDescricaoPermissao(String descricaoPermissao) {
		this.descricaoPermissao = descricaoPermissao;
	}

	public List<Usuario> getUsuarios() {
		return usuarios;
	}

	public void setUsuarios(List<Usuario> usuarios) {
		this.usuarios = usuarios;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Permissao other = (Permissao) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
}
