package com.es.mlutzdev.productos.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.es.mlutzdev.productos.entidades.Producto;
import com.es.mlutzdev.productos.service.I_ProductoService;

@RestController
@RequestMapping("/producto")
public class ProductoController {
	
	@Autowired
	private I_ProductoService productoService;
	
	@GetMapping
	public ResponseEntity<List<Producto>> listarProductos(){
		List<Producto> productos = productoService.getAll();
		
		if (productos.isEmpty()) {
			return ResponseEntity.noContent().build();
		}
		
		return ResponseEntity.ok(productos);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Producto> obtenerProducto(@PathVariable Long id){
		Producto producto = productoService.findById(id);
		if(producto == null) {
			return ResponseEntity.notFound().build();
		}
		return ResponseEntity.ok(producto);
	}
	
	@PostMapping()
	public ResponseEntity<Producto> guardarProducto(@RequestBody Producto producto ){
	
		Producto nuevoProducto = productoService.Save(producto);
		return ResponseEntity.ok(nuevoProducto);
	}

	@GetMapping("/usuario/{usuarioId}")
	public ResponseEntity<List<Producto>> obtenerProductosByUsuario(@PathVariable Long usuarioId){
		List<Producto> productos = productoService.getAllByUsuario(usuarioId);
		if(productos.isEmpty()) {
			return ResponseEntity.noContent().build();
		}
		return ResponseEntity.ok(productos);
	}
	

}
