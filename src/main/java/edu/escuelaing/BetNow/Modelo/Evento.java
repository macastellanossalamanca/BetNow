package edu.escuelaing.BetNow.Modelo;

import java.io.Serializable;


public class Evento implements Serializable{
	
	private String equipoA;
	private String equipoB;
	private Double cuotaA;
	private String cuotaB;
	private String ganador;
	
	
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
	public String getCuotaB() {
		return cuotaB;
	}
	public void setCuotaB(String cuotaB) {
		this.cuotaB = cuotaB;
	}
	
}
