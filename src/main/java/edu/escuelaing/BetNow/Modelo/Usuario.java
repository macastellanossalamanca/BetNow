package edu.escuelaing.BetNow.Modelo;

import java.io.Serializable;
import java.util.ArrayList;

public class Usuario implements Serializable{
	
	private String nombre;
	private String id;
	private Double credito;
	private ArrayList<Apuesta> apuestas;
	
	public Usuario() {
		apuestas = new ArrayList<Apuesta>();
	}
	
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public Double getCredito() {
		return credito;
	}
	
	public void setCredito(Double credito) {
		this.credito = credito;
	}
}
