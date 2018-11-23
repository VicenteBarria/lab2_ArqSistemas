package com.gomitas.Gomitas;

import lombok.Data;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Data
@Entity
public class Gomitas {
	
	private @Id @GeneratedValue Long id;
	private String nombre;
	private String marca;
	private int precio;
	
	public Gomitas(String nombre, String marca, int precio) {
		this.nombre = nombre;
		this.marca = marca;
		this.precio = precio;
	}
	
	public Long getId() {
		return this.id;
	}
	
	public void setId(Long id) {
		this.id = id;
	}
	
	public String getNombre() {
		return this.nombre;
	}
	
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
	public String getMarca() {
		return this.marca;
	}
	
	public void setMarca(String marca) {
		this.marca = marca;
	}
	
	public int getPrecio() {
		return this.precio;
	}
	
	public void setPrecio(int precio) {
		this.precio = precio;
	}
}
