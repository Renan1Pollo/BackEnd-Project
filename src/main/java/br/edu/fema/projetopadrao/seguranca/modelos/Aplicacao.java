package br.edu.fema.projetopadrao.seguranca.modelos;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "adm_aplicacao", schema="admin")
public class Aplicacao {

	@Id
	@Column(name = "id_aplicacao")
	private Long id;
	
	private String visivel;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getVisivel() {
		return visivel;
	}

	public void setVisivel(String visivel) {
		this.visivel = visivel;
	}
	
	
	
}

