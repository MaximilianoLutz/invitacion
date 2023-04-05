package com.es.mlutzdev.invitado.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.es.mlutzdev.invitado.entidades.Invitado;

public interface I_InvitadoRepository extends JpaRepository<Invitado, Long> {

	List<Invitado> findByUsuarioId(Long idUsuario);
}
