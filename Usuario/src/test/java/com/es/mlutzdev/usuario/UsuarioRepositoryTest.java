package com.es.mlutzdev.usuario;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;

import org.junit.Test;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.es.mlutzdev.usuario.entidades.Usuario;
import com.es.mlutzdev.usuario.repository.I_UsuarioRepository;

@SpringBootTest
public class UsuarioRepositoryTest {
	
	@Autowired
	private I_UsuarioRepository usuarioRepository;
	
	private Usuario usuario;
	
	@BeforeEach
	void setUp() {
		usuario = Usuario.builder()
				.nombre("José")
				.email("jose" + (Math.random() * 100)+"@gmail.com")
				.build();		
	}
	

	@Test
	public void GuardarUsuarioTest() {
		//Tdd pruebas unitaria funcionalidades
		//--------------------------------------//
		//BDD como debe comportarse el código:
		
		//given= dada una condicion previa o configuracion
		Usuario usuario1 = Usuario.builder()
				.nombre("Pepe")
				.email("lutzPepe@gmail.com")
				.build();
		
		//when: Accion o comportamiento que vamos a probar
		Usuario usuarioGuardado = usuarioRepository.save(usuario1);
		
		//then: verificar la salida
		assertThat(usuarioGuardado).isNotNull();
		assertThat(usuarioGuardado.getId()).isGreaterThan(0);
			
	}
	
	@DisplayName("Test para listar usuarios")
	@Test
	public void ListarUsuariosTest() {
		
		//Given
		Usuario usuario2 = Usuario.builder()
				.nombre("Maxi")
				.email("lutzmaximiliano@gmail.com")
				.build();
		usuarioRepository.save(usuario2);

		usuarioRepository.save(usuario);

		
		//When
		List<Usuario> usuarios = usuarioRepository.findAll();
		
		//Then
		
		assertThat(usuarios).isNotNull();
		assertThat(usuarios.size()).isEqualTo(3);
	}

	@Test
	public void actualizarUsuario() {
		
		Usuario user = Usuario.builder()
				.nombre("Chano")
				.email("doredan")
				.build();
		//Given
		Usuario us = usuarioRepository.save(user);
		
		//When
		
		Usuario usuarioDB = usuarioRepository.getById(us.getId());
		System.out.println(usuarioDB);
		
		usuarioDB.setEmail("actual@test.com");
		usuarioDB.setNombre("novaresio");
		
		Usuario usuarioActualizado = usuarioRepository.saveAndFlush(usuarioDB);
		
		//Then
		assertThat(usuarioActualizado.getEmail()).isEqualTo("actual@test.com");
		assertThat(usuarioActualizado.getNombre()).isEqualTo("novaresio");
	}
	
	@DisplayName("Test para obtener usuario por id")
	@Test
	public void ObtenerUsuarioPorId() {
		//Given
		usuarioRepository.save(usuario);
		
		//When
		System.out.println(usuario);
		Usuario usuarioDB = usuarioRepository.getById(usuario.getId());
		
		//Then
		
		assertThat(usuarioDB).isNotNull();
	}
}
