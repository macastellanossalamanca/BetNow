package edu.escuelaing.BetNow.Modelo;

import java.io.Serializable;
import java.util.UUID;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

@Document("Evento")
public class Evento implements Serializable {

	private static final long serialVersionUID = 1L;
	@Id
	private String id;
	@Field(name = "equipoA")
	private String equipoA;
	@Field(name = "equipoB")
	private String equipoB;
	@Field(name = "cuotaA")
	private Double cuotaA;
	@Field(name = "cuotaB")
	private Double cuotaB;
	@Field(name = "ganador")
	private String ganador;

	public Evento(String equipoA, String equipoB, Double cuotaA, Double cuotaB, String ganador) {

		this.id = UUID.randomUUID().toString();
		this.equipoA = equipoA;
		this.equipoB = equipoB;
		this.cuotaA = cuotaA;
		this.cuotaB = cuotaB;
		this.ganador = ganador;
	}

	public String getGanador() {
		return ganador;
	}

	public void setGanador(String ganador) {
		this.ganador = ganador;
	}

	public String getEquipoA() {
		return equipoA;
	}

	public void setEquipoA(String equipoA) {
		this.equipoA = equipoA;
	}

	public String getEquipoB() {
		return equipoB;
	}

	public void setEquipoB(String equipoB) {
		this.equipoB = equipoB;
	}

	public Double getCuotaA() {
		return cuotaA;
	}

	public void setCuotaA(Double cuotaA) {
		this.cuotaA = cuotaA;
	}

	public Double getCuotaB() {
		return cuotaB;
	}

	public void setCuotaB(Double cuotaB) {
		this.cuotaB = cuotaB;
	}

	public String getId() {
		return id;
	}

}
