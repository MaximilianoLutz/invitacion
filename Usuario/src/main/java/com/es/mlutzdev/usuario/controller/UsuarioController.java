package com.es.mlutzdev.usuario.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.es.mlutzdev.usuario.entidades.Usuario;
import com.es.mlutzdev.usuario.modelos.Invitado;
import com.es.mlutzdev.usuario.modelos.Producto;
import com.es.mlutzdev.usuario.service.I_UsuarioService;

import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;

@RestController
@RequestMapping("/usuario")
public class UsuarioController {
	
	
	@Autowired
	private I_UsuarioService usuarioService;
	
	
	@GetMapping
	public ResponseEntity<List<Usuario>> listarUsuarios(){
		List<Usuario>usuarios = usuarioService.getAll();
		
		if (usuarios.isEmpty()) {
			return ResponseEntity.noContent().build();
		}
		
		return ResponseEntity.ok(usuarios);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Usuario> obtenerUsuario(@PathVariable Long id){
		Usuario usuario = usuarioService.findById(id);
		if(usuario == null) {
			return ResponseEntity.notFound().build();
		}
		return ResponseEntity.ok(usuario);
	}
	
	@PostMapping
	public ResponseEntity<Usuario> guardarUsuario(@RequestBody Usuario usuario ){
		System.out.print(usuario);
	
		Usuario nuevoUsuario = usuarioService.Save(usuario);
		return ResponseEntity.ok(nuevoUsuario);
	}
	
	@CircuitBreaker(name= "invitadoCB", fallbackMethod = "fallBackGetInvitado")
	@GetMapping("/invitados/{usuarioId}")
	public ResponseEntity< List<Invitado>> getInvitados(@PathVariable Long usuarioId){
		
		Usuario usuario = usuarioService.findById(usuarioId);
		
		if (usuario == null) {
			return ResponseEntity.notFound().build();
		}
		
		List<Invitado> invitados = usuarioService.getAllInvitado(usuarioId);
		
		return ResponseEntity.ok(invitados);
	}
	@CircuitBreaker(name= "productoCB", fallbackMethod = "fallBackGetProducto")
	@GetMapping("/productos/{usuarioId}")
	public ResponseEntity< List<Producto>> getProductos(@PathVariable Long usuarioId){
		
		Usuario usuario = usuarioService.findById(usuarioId);
		
		if (usuario == null) {
			return ResponseEntity.notFound().build();
		}
		
		List<Producto> productos = usuarioService.getAllProducto(usuarioId);
		
		return ResponseEntity.ok(productos);
	}
	
	@CircuitBreaker(name= "invitadoCB", fallbackMethod = "fallBackSaveInvitado")
	@PostMapping("/invitado/{usuarioId}")
	public ResponseEntity<Invitado> saveInvitado(@PathVariable Long usuarioId, @RequestBody Invitado invitado) {
		
		invitado.setUsuarioId(usuarioId);
		
		Invitado invitadoNuevo = usuarioService.saveInvitado(usuarioId, invitado);
		
		return ResponseEntity.ok(invitadoNuevo);
	}
	
	@CircuitBreaker(name= "productoCB", fallbackMethod = "fallBackSaveProducto")
	@PostMapping("/producto/{usuarioId}")
	public ResponseEntity<Producto> saveProducto(@PathVariable Long usuarioId, @RequestBody Producto producto) {
		
		producto.setUsuarioId(usuarioId);
		
		Producto productoNuevo = usuarioService.saveProducto(usuarioId, producto);
		
		return ResponseEntity.ok(productoNuevo);
	}
	
	@CircuitBreaker(name= "todosCB", fallbackMethod = "fallBackGetUserAndProductoAndInvitado")
	@GetMapping("/todos/{usuarioId}")
	public ResponseEntity<Map<String, Object>> obtenerTodos(@PathVariable Long usuarioId){
		
		Map<String, Object> resultado =  usuarioService.getUserAndProductoAndInvitado(usuarioId);
		
		return ResponseEntity.ok(resultado);
	}
	
	//CircuitBreaker
	private ResponseEntity<List<Invitado>> fallBackGetInvitado(@PathVariable("usuarioId") Long id, RuntimeException exception){
		return new ResponseEntity("El usuario" + id + "no tiene invitados disponibles", HttpStatus.OK);
	}
	
	private ResponseEntity<List<Producto>> fallBackGetProducto(@PathVariable("usuarioId") Long id, RuntimeException exception){
		return new ResponseEntity("El usuario" + id + "no tiene productos disponibles", HttpStatus.OK);
	}
	private ResponseEntity<Invitado> fallBackSaveInvitado(@PathVariable("usuarioId") Long id, @RequestBody Invitado invitado ,RuntimeException exception){
		return new ResponseEntity("El usuario" + id + "no pudo guardar invitados", HttpStatus.OK);
	}
	private ResponseEntity<Producto> fallBackSaveProducto(@PathVariable("usuarioId") Long id, @RequestBody Producto producto, RuntimeException exception){
		return new ResponseEntity("El usuario" + id + "no pudo guardar productos", HttpStatus.OK);
	}
	private ResponseEntity<Map<String, Object>> fallBackGetUserAndProductoAndInvitado(@PathVariable("usuarioId") Long id, RuntimeException exception){
		return new ResponseEntity("El usuario" + id + "no se encuentra disponible actualmente", HttpStatus.OK);
	}
	
}
