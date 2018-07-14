package com.anderson.brewer.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.anderson.brewer.model.Cidade;
import com.anderson.brewer.repository.Cidades;
import com.anderson.brewer.service.exception.NomeCidadeJaCadastradaException;

@Service
public class CadastroCidadeService {
	
	@Autowired
	private Cidades cidades;
	
	@Transactional
	public void salvar(Cidade cidade){
		
		Optional<Cidade> cidadeExistente = cidades.findByNomeAndEstado(cidade.getNome(), cidade.getEstado());
		
		if(cidadeExistente.isPresent()){
			throw new NomeCidadeJaCadastradaException("Nome da cidade já cadastrado");
		}
		
		cidades.save(cidade);
	}
	
}
