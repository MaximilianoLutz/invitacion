package com.es.mlutzdev.usuario.feignClient;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import com.es.mlutzdev.usuario.modelos.Invitado;

@FeignClient(name = "invitado-service", url = "http://localhost:8002")
@RequestMapping("/invitado")
public interface InvitadoFeignClient {
	
	@PostMapping()
	public Invitado save(@RequestBody Invitado invitado);
	
	
	@GetMapping("/usuario/{usuarioId}")
	public List<Invitado> getInvitado(@PathVariable Long usuarioId);

}
