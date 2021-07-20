package edu.escuelaing.BetNow.Modelo;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.UUID;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;


@Document("Usuario")
public class Usuario implements Serializable {


	private static final long serialVersionUID = 1L;
	@Field(name="nombre")
	private String nombre;
	@Id
	private String id;
	@Field(name="correo")
	@Indexed(unique = true)
	private String correo;
	@Field(name="credito")
	private Double credito;



	public Usuario(String nombre,  String correo) {
		this.nombre = nombre;
		this.id = UUID.randomUUID().toString();
		this.correo = correo;
		this.credito = (double) 50000;
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

	public Double getCredito() {
		return credito;
	}

	public void setCredito(Double credito) {
		this.credito = credito;
	}

	public String getCorreo() {
		return this.correo;
	}

	public void setCorreo(String correo) {
		this.correo = correo;
	}

}
