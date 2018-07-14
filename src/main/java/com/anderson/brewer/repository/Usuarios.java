package com.anderson.brewer.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.anderson.brewer.model.Usuario;

public interface Usuarios extends JpaRepository<Usuario, Long> {
	
	public Optional<Usuario> findByEmail(String email);

}




