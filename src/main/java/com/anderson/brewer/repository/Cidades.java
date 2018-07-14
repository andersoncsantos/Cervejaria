package com.anderson.brewer.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.anderson.brewer.model.Cidade;
import com.anderson.brewer.model.Estado;
import com.anderson.brewer.repository.helper.cidade.CidadesQueries;


public interface Cidades extends JpaRepository<Cidade, Long>, CidadesQueries {
	
	public List<Cidade> findByEstadoCodigo(Long codigoEstado);
	
	public Optional<Cidade> findByNomeAndEstado(String nome, Estado estado);

}




