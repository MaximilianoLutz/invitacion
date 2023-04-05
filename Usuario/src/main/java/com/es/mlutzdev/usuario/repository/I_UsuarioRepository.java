package com.es.mlutzdev.usuario.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.es.mlutzdev.usuario.entidades.Usuario;

public interface I_UsuarioRepository extends JpaRepository<Usuario, Long>{

}
