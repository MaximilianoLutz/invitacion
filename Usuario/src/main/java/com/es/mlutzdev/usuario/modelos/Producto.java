package com.es.mlutzdev.usuario.modelos;


public class Producto {
	
	private String servicios;
	private boolean externos;
	private String menu;
	private Long usuarioId;
	
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
	
	
	
	

}
