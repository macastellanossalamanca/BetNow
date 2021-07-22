package edu.escuelaing.BetNow.Modelo;

import java.io.Serializable;
import java.util.UUID;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;


@Document("Apuesta")
public class Apuesta implements Serializable{

	private static final long serialVersionUID = 1L;
	
	@Id
	private String id;
	@Field(name="usuarioId")
	private String usuarioId;
	@Field(name="equipo")
	private String equipo;
	@Field(name="monto")
	private double monto;
	@Field(name="cuota")
	private double cuota;
	@Field(name="evento")
	private String evento;
	@Field(name="estado")
	private String estado;
	
	public Apuesta() {
		
	}
	@Override
	public String toString() {
		return "Apuesta [id=" + id + ", usuarioId=" + usuarioId + ", equipo=" + equipo + ", monto=" + monto + ", cuota="
				+ cuota + ", evento=" + evento + ", estado=" + estado + "]";
	}
	public Apuesta(String equipo, double monto, double cuota, String evento, String estado) {
		
		this.id = UUID.randomUUID().toString();
		this.equipo = equipo;
		this.monto = monto;
		this.cuota = cuota;
		this.evento = evento;
		this.estado = estado;
	}
	public String getEvento() {
		return evento;
	}
	public void setEvento(String evento) {
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
	public String getEstado() {
		return estado;
	}
	public void setEstado(String estado) {
		this.estado = estado;
	}
	public String getUsuarioId() {
		return usuarioId;
	}
	public void setUsuarioId(String usuarioId) {
		this.usuarioId = usuarioId;
	}
}

