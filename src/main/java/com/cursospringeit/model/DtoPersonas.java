package com.cursospringeit.model;

import java.util.List;

public class DtoPersonas {
	
	private int numfilas;
	
	private boolean success;
	
	private List<Persona> data;

	
	public DtoPersonas() {
		super();
	}

	public DtoPersonas(int numfilas, boolean success, List<Persona> data) {
		super();
		this.numfilas = numfilas;
		this.success = success;
		this.data = data;
	}

	public int getNumfilas() {
		return numfilas;
	}

	public void setNumfilas(int numfilas) {
		this.numfilas = numfilas;
	}

	public boolean isSuccess() {
		return success;
	}

	public void setSuccess(boolean success) {
		this.success = success;
	}

	public List<Persona> getData() {
		return data;
	}

	public void setData(List<Persona> data) {
		this.data = data;
	}
	
	
	
}
