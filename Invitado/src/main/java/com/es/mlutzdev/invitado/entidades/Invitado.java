package com.es.mlutzdev.invitado.entidades;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Invitado {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String nombre;
	private String apellido;
	private String vinculo;
	@Column(nullable = false, unique = true)
	private String email;
	private Long usuarioId;
	
	
	public Invitado() {
	}
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
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

	@Override
	public String toString() {
		return "Invitado [id=" + id + ", nombre=" + nombre + ", apellido=" + apellido + ", vinculo=" + vinculo
				+ ", email=" + email + ", UsuarioId=" + usuarioId + "]";
	}

	
	
	

}
