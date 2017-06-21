package com.durgam.guerra.dominio;

import java.util.ArrayList;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class GestionRequisito {
	private static GestionRequisito miapp;
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	private String nombre;
	static final String sistema_nombre = "Sistema Gestion de Requisitos 2017";

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER, mappedBy = "aplicacion")
	private List<Proyecto> proyectos;

	// //Por Singleton: El constructor es privado, no permite que se genere un
	// constructor por defecto.
	// private GestionRequisito() {
	// this.setNombre(sistema_nombre);
	// this.proyectos=new ArrayList<Proyecto>();
	// }
	//
	// public static GestionRequisito getSistema() {
	// if (miapp==null) {
	// miapp=new GestionRequisito();
	// }
	// return miapp;
	// }

	private GestionRequisito() {

	}

	public void agregarProyecto(Proyecto proyecto) {
		this.proyectos.add(proyecto);
	}

	public List<Proyecto> getDocumentos() {
		return proyectos;
	}

	public void setDocumentos(List<Proyecto> proyectos) {
		this.proyectos = proyectos;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
}
