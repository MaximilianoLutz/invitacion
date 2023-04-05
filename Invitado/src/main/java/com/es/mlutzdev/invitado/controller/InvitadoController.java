package com.es.mlutzdev.invitado.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.es.mlutzdev.invitado.entidades.Invitado;
import com.es.mlutzdev.invitado.service.I_InvitadoService;


@RestController
@RequestMapping("/invitado")
public class InvitadoController {
	
	@Autowired
	private I_InvitadoService invitadoService;
	
	@GetMapping
	public ResponseEntity< List<Invitado>> listarInvitados(){
		List<Invitado> invitados = invitadoService.getAll();
		
		if (invitados.isEmpty()) {
			return ResponseEntity.noContent().build();
		}
		
		return ResponseEntity.ok(invitados);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Invitado> obtenerInvitado(@PathVariable Long id){
		Invitado invitado = invitadoService.findById(id);
		if(invitado == null) {
			return ResponseEntity.notFound().build();
		}
		return ResponseEntity.ok(invitado);
	}
	
	@PostMapping
	public ResponseEntity<Invitado> guardarInvitado(@RequestBody Invitado invitado ){
		System.out.print(invitado);
	
		Invitado nuevoInvitado = invitadoService.Save(invitado);
		
		return ResponseEntity.ok(nuevoInvitado);
	}

	@GetMapping("/usuario/{usuarioId}")
	public ResponseEntity<List<Invitado>> obtenerInvitadosByUsuario(@PathVariable Long usuarioId){
		List<Invitado> invitados = invitadoService.getAllByUsuario(usuarioId);
		if(invitados.isEmpty()) {
			return ResponseEntity.noContent().build();
		}
		return ResponseEntity.ok(invitados);
	}
	
	
}
