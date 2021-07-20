package edu.escuelaing.BetNow.Modelo;

import java.io.Serializable;
import java.util.UUID;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;


@Document("Apuesta")
public class Apuesta implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Id
	private String id;
	@Field(name="usuario")
	private Usuario usuario;
	@Field(name="equipo")
	private String equipo;
	@Field(name="monto")
	private double monto;
	@Field(name="cuota")
	private double cuota;
	@Field(name="evento")
	private Evento evento;
	
	
	public Apuesta(String equipo, double monto, double cuota, Evento evento) {
		this.id = UUID.randomUUID().toString();
		this.equipo = equipo;
		this.monto = monto;
		this.cuota = cuota;
		this.evento = evento;
	}
	public Evento getEvento() {
		return evento;
	}
	public void setEvento(Evento evento) {
		this.evento = evento;
	}
	public String getEquipo() {
		return equipo;
	}
	public void setEquipo(String equipo) {
		this.equipo = equipo;
	}
	public double getMonto() {
		return monto;
	}
	public void setMonto(double monto) {
		this.monto = monto;
	}
	public double getCuota() {
		return cuota;
	}
	public void setCuota(double cuota) {
		this.cuota = cuota;
	}
	public String getId() {
		return id;
	}
}
