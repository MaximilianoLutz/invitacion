package com.es.mlutzdev.usuario.service;

import java.util.List;
import java.util.Map;

import com.es.mlutzdev.usuario.entidades.Usuario;
import com.es.mlutzdev.usuario.modelos.Invitado;
import com.es.mlutzdev.usuario.modelos.Producto;


public interface I_UsuarioService {

	List<Usuario> getAll();

	Usuario findById(Long id);

	Usuario Save(Usuario usuario);

	List<Invitado> getAllInvitado(Long usuarioId);

	List<Producto> getAllProducto(Long usuarioId);
	
	Invitado saveInvitado(Long usuarioId, Invitado invitado);
	
	List<Invitado> getInvitado(Long usuarioId);
	
	Producto saveProducto(Long usuarioId, Producto producto);
	
	List<Producto> getProducto(Long usuarioId);
	
	Map<String, Object> getUserAndProductoAndInvitado(Long usuarioId);	

}