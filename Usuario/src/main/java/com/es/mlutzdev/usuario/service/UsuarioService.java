package com.es.mlutzdev.usuario.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.client.RestTemplate;

import com.es.mlutzdev.usuario.entidades.Usuario;
import com.es.mlutzdev.usuario.exceptions.ResourceNotFoundException;
import com.es.mlutzdev.usuario.feignClient.InvitadoFeignClient;
import com.es.mlutzdev.usuario.feignClient.ProductoFeignClient;
import com.es.mlutzdev.usuario.modelos.Invitado;
import com.es.mlutzdev.usuario.modelos.Producto;
import com.es.mlutzdev.usuario.repository.I_UsuarioRepository;

@Service
public class UsuarioService implements I_UsuarioService {
	
	@Autowired
	private RestTemplate restTemplate;
	
	@Autowired
	private InvitadoFeignClient invitadoFeignClient;
	
	@Autowired
	private ProductoFeignClient productoFeignCLient;
	
	@Autowired
	private I_UsuarioRepository usuarioRepository;
	
	@Override
	public List<Usuario> getAll(){
		return (List<Usuario>) usuarioRepository.findAll();
	}
	@Transactional(readOnly = true)
	@Override
	public Usuario findById(Long id) {
		return usuarioRepository.findById(id).orElse(null);
	}
	@Transactional
	@Override
	public Usuario Save(Usuario usuario) {
		
		Optional<Usuario> usuarioGuardado = usuarioRepository.findByEmail(usuario.getEmail());
		if(usuarioGuardado.isPresent()) {
			throw new ResourceNotFoundException("El usuario con el email" + usuario.getEmail()+ "Ya existe");
		}else {
			return usuarioRepository.save(usuario);
		}
	}
	@Transactional(readOnly = true)
	@SuppressWarnings("unchecked")
	@Override
	public List<Invitado> getAllInvitado(Long usuarioId){
		List<Invitado> invitados = restTemplate.getForObject("http://invitado-microservicio/invitado/usuario/" + usuarioId, List.class) ;
		return invitados;
	}
	
	@Transactional(readOnly = true)
	@SuppressWarnings("unchecked")
	@Override
	public List<Producto> getAllProducto(Long usuarioId){
		List<Producto> producto = restTemplate.getForObject("http://productos-microservicio/producto/usuario/" + usuarioId, List.class) ;
		
		return producto;
	}
	
	
	@Override
	public Invitado saveInvitado(Long usuarioId, Invitado invitado) {
		invitado.setUsuarioId(usuarioId);
		Invitado nuevoInvitado = invitadoFeignClient.save(invitado);
		return nuevoInvitado;
	}

	
	@Override
	public List<Invitado> getInvitado(Long usuarioId) {
		List<Invitado> invitados = invitadoFeignClient.getInvitado(usuarioId);
		return invitados;
	}

	@Override
	public Producto saveProducto(Long usuarioId, Producto producto) {
	
		producto.setUsuarioId(usuarioId);
		
		Producto nuevoProducto = productoFeignCLient.save(producto);
		
		return nuevoProducto;
	}

	@Override
	public List<Producto> getProducto(Long usuarioId) {
		List<Producto> productos = productoFeignCLient.getProductos(usuarioId);
		return productos;
	}

	@Override
	public Map<String, Object> getUserAndProductoAndInvitado(Long usuarioId) {
		Map <String, Object> resultado = new HashMap<>();
		
		Usuario usuario = usuarioRepository.findById(usuarioId).orElse(null);
		
		if(usuario==null) {
			resultado.put("Mensaje", "El usuario no existe");
			return resultado;
		}
		resultado.put("Usuario", usuario);
		
		List<Producto> productos = productoFeignCLient.getProductos(usuarioId);
		 
		if(productos.isEmpty()) {
			resultado.put("Produtos", "No se encontraron productos con el id especificado");
		}else {
			resultado.put("Produtos", productos);
		}
		
		List<Invitado> invitados = invitadoFeignClient.getInvitado(usuarioId);
		 
		if(invitados.isEmpty()) {
			resultado.put("Invitados", "No se encontraron invitados con el id especificado");
		}else {
			resultado.put("Invitados", invitados);
		}	
		
		return resultado;
	}
	
	
	
	
}
