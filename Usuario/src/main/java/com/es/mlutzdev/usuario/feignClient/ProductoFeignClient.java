package com.es.mlutzdev.usuario.feignClient;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import com.es.mlutzdev.usuario.modelos.Producto;

@FeignClient(name = "productos-microservicio")
@RequestMapping("/producto")
public interface ProductoFeignClient {

	@PostMapping()
	public Producto save(@RequestBody Producto producto);
	
	@GetMapping("/usuario/{usuarioId}")
	public List<Producto> getProductos(@PathVariable Long usuarioId);
	
}
