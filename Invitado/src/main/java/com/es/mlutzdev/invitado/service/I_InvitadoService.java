package com.es.mlutzdev.invitado.service;

import java.util.List;

import com.es.mlutzdev.invitado.entidades.Invitado;

public interface I_InvitadoService {

	List<Invitado> getAll();
	
	List<Invitado> getAllByUsuario(Long usuarioId);

	Invitado findById(Long Id);

	Invitado Save(Invitado invitado);
	
	

}