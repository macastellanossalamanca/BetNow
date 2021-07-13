package edu.escuelaing.BetNow.Modelo;

import java.io.Serializable;
import java.util.ArrayList;


public class Usuario implements Serializable {

	private String nombre;
	private String id;
	private String correo;
	private String psw;
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

	public ArrayList<Apuesta> getApuestas() {
		return this.apuestas;
	}

	public void setApuestas(ArrayList<Apuesta> apuestas) {
		this.apuestas = apuestas;
	}

	public String getCorreo() {
		return this.correo;
	}

	public void setCorreo(String correo) {
		this.correo = correo;
	}

	public String getPsw() {
		return this.psw;
	}

	public void setPsw(String psw) {
		this.psw = psw;
	}

}
