package com.es.mlutzdev.productos.service;

import java.util.List;

import com.es.mlutzdev.productos.entidades.Producto;

public interface I_ProductoService {

	List<Producto> getAll();

	List<Producto> getAllByUsuario(Long usuarioId);

	Producto findById(Long Id);

	Producto Save(Producto producto);

}