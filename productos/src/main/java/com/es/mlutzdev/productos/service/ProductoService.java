package com.es.mlutzdev.productos.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.es.mlutzdev.productos.entidades.Producto;
import com.es.mlutzdev.productos.repository.I_ProductoRepository;



@Service
public class ProductoService implements I_ProductoService {
	
	@Autowired
	private I_ProductoRepository productoRepository;
	
	
	@Override
	public List<Producto> getAll(){
		return productoRepository.findAll();
	}
	
	@Override
	public List<Producto> getAllByUsuario(Long usuarioId) {
		
		return productoRepository.findByUsuarioId(usuarioId);
	}
	
	@Override
	public Producto findById(Long Id) {
		return productoRepository.findById(Id).orElse(null);
	}
	
	@Override
	public Producto Save(Producto producto) {
		return productoRepository.save(producto);
	}


}
