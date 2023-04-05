package com.es.mlutzdev.productos.entidades;



import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Producto {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY )
	private Long id;
	private String servicios;
	private boolean externos;
	private String menu;
	private Long usuarioId;
	
	public Producto() {
	
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getServicios() {
		return servicios;
	}

	public void setServicios(String servicios) {
		this.servicios = servicios;
	}

	public boolean isExternos() {
		return externos;
	}

	public void setExternos(boolean externos) {
		this.externos = externos;
	}

	public String getMenu() {
		return menu;
	}

	public void setMenu(String menu) {
		this.menu = menu;
	}

	public Long getUsuarioId() {
		return usuarioId;
	}

	public void setUsuarioId(Long usuarioId) {
		this.usuarioId = usuarioId;
	}

	@Override
	public String toString() {
		return "Producto [id=" + id + ", servicios=" + servicios + ", externos=" + externos + ", menu=" + menu
				+ ", usuarioId=" + usuarioId + "]";
	}
	
	
	
	

}
