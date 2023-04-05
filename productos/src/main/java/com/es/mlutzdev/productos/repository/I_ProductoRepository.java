package com.es.mlutzdev.productos.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.es.mlutzdev.productos.entidades.Producto;

public interface I_ProductoRepository extends JpaRepository<Producto, Long> {
	
	List<Producto> findByUsuarioId(Long idUsuario);

}
