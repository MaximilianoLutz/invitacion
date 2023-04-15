package com.es.mlutzdev.usuario;

import static org.junit.Assert.assertEquals;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;

import com.es.mlutzdev.usuario.controller.UsuarioController;
import com.es.mlutzdev.usuario.entidades.Usuario;

public class TestUserController {
	
	@Autowired
	private UsuarioController usuarioController;
	
	@Test
	public void getUsuario() {
		ResponseEntity<Usuario> usuario =  usuarioController.obtenerUsuario(1L);
		Usuario u = usuario.getBody();
		
		assertEquals(new Usuario(), u);
	}
}
