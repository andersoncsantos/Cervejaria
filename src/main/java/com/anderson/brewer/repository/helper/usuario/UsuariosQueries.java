package com.anderson.brewer.repository.helper.usuario;

import java.util.Optional;

import com.anderson.brewer.model.Usuario;

public interface UsuariosQueries {

	public Optional<Usuario> porEmailEAtivo(String email);
}






