package edu.escuelaing.BetNow.Modelo;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.UUID;

import javax.persistence.Id;


public class Usuario implements Serializable {


	private static final long serialVersionUID = 1L;

	private String nombre;
	
	@Id
	private String id;
	private String correo;
	private String psw;
	private Double credito;
	private ArrayList<Apuesta> apuestas;

	public Usuario() {
		apuestas = new ArrayList<Apuesta>();
	}

	public Usuario(String nombre,  String correo) {
		this.nombre = nombre;
		this.id = UUID.randomUUID().toString();;
		this.correo = correo;
		this.psw = "psw";
		this.credito = (double) 50000;
		this.apuestas = new ArrayList<Apuesta>();
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
