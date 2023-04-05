package com.es.mlutzdev.usuario.modelos;


public class Invitado {
	
	private String nombre;
	private String apellido;
	private String vinculo;
	private String email;
	private Long usuarioId;                                                                                               
	
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getApellido() {
		return apellido;
	}
	public void setApellido(String apellido) {
		this.apellido = apellido;
	}
	public String getVinculo() {
		return vinculo;
	}
	public void setVinculo(String vinculo) {
		this.vinculo = vinculo;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public Long getUsuarioId() {
		return usuarioId;
	}
	public void setUsuarioId(Long usuarioId) {
		this.usuarioId = usuarioId;
	}
	
	
	
	

}
