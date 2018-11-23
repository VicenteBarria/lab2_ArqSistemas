package com.gomitas.Gomitas;

public class GomitasNotFoundException extends RuntimeException {

	public GomitasNotFoundException(Long id) {
		super("No se pudo encontrar la gomita " + id);
	}
}
