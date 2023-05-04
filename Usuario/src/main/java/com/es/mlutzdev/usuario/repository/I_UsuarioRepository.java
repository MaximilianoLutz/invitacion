package com.es.mlutzdev.usuario.repository;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

import com.es.mlutzdev.usuario.entidades.Usuario;

public interface I_UsuarioRepository extends CrudRepository<Usuario, Long>{
	
	Optional<Usuario>  findByEmail(String email);

}
