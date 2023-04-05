package com.es.mlutzdev.invitado.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.es.mlutzdev.invitado.entidades.Invitado;
import com.es.mlutzdev.invitado.repository.I_InvitadoRepository;


@Service
public class InvitadoService implements I_InvitadoService {
	
	@Autowired
	private I_InvitadoRepository invitadoRepository;
	
	@Override
	public List<Invitado> getAll(){
		return invitadoRepository.findAll();
	}
	
	@Override
	public List<Invitado> getAllByUsuario(Long usuarioId) {
		
		return invitadoRepository.findByUsuarioId(usuarioId);
	}
	
	@Override
	public Invitado findById(Long Id) {
		return invitadoRepository.findById(Id).orElse(null);
	}
	
	@Override
	public Invitado Save(Invitado invitado) {
		return invitadoRepository.save(invitado);
	}

}
