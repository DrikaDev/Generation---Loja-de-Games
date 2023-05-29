package com.gamesgutiguti.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.gamesgutiguti.model.Usuario;

public interface UsuarioRepository extends JpaRepository<Usuario, Long>{
	
	//método de busca específica para Spring Security:
	public Optional<Usuario> findByUsuario(String usuario);
}
