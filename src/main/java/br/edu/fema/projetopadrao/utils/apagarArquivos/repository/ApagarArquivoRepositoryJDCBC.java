package br.edu.fema.projetopadrao.utils.apagarArquivos.repository;

import javax.annotation.PostConstruct;
import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class ApagarArquivoRepositoryJDCBC {
	private JdbcTemplate jdbcTemplate;
	
	@Autowired
	private DataSource dataSource;

	@PostConstruct
	private void postConstruct() {
		this.jdbcTemplate = new JdbcTemplate(this.dataSource);
	}

	public void excluirLogicamenteArquivo(String nome, String uuidArquivo) {
		String sql = "UPDATE upload." + nome + " SET apagar = 'S' WHERE uuid = ?";
		jdbcTemplate.update(sql, uuidArquivo);
	}
}
