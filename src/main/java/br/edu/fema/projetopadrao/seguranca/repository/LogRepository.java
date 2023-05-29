package br.edu.fema.projetopadrao.seguranca.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.edu.fema.projetopadrao.seguranca.modelos.Log;

public interface LogRepository extends JpaRepository<Log, Long>{

}
