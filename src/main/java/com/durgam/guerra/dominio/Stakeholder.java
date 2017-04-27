package com.durgam.guerra.dominio;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;


@Entity
public class Stakeholder {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private long id;
	private String nombre;
	private String apellido;
	private String rol;
	private String dni;
	
	
	@ManyToMany(cascade = CascadeType.ALL)
	private List<Requisito> requisitos;
	
	
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getApellido() {
		return apellido;
	}
	public void setApellido(String apellido) {
		this.apellido = apellido;
	}
	public String getRol() {
		return rol;
	}
	public void setRol(String rol) {
		this.rol = rol;
	}
	public Stakeholder(long id, String dni, String nombre, String apellido, String rol) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.apellido = apellido;
		this.rol = rol;
		this.dni=dni;
this.requisitos=new ArrayList<Requisito>();
	}
	public Stakeholder() {
		super();
		// TODO Auto-generated constructor stub
	}
	public List<Requisito> getRequisitos() {
		return requisitos;
	}
	public void setRequisitos(List<Requisito> requisitos) {
		this.requisitos = requisitos;
	}
	
public String getDni() {
		return dni;
	}
	public void setDni(String dni) {
		this.dni = dni;
	}
public void agragarRequisito(Requisito requisito){
	this.requisitos.add(requisito);
}
	
}
