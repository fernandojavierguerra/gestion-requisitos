package com.durgam.guerra.dominio;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;

import javax.persistence.OneToOne;

@Entity
@Inheritance(strategy = InheritanceType.JOINED)
abstract public class Requisito {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	private String nombre;
	private String necesidad;
	private String prioridad;
	private String riesgo;

	// @ManyToOne(cascade=(CascadeType.MERGE))
	// private RequisitoCompuesto compuesto;
	// @ManyToOne(cascade=(CascadeType.ALL))
	// private Proyecto proyecto;
	@OneToOne(cascade = (CascadeType.ALL))
	private EstadoRequisito estado;

	public Requisito() {
	}

	public Requisito(Long id, String nombre, String necesidad, String prioridad, String riesgo, Proyecto proyecto) {
		super();
		this.nombre = nombre;
		this.necesidad = necesidad;
		this.prioridad = prioridad;
		this.riesgo = riesgo;
		// this.id=id;

		this.estado = RequisitoAbierto.getEstado();
		//this.estado = new RequisitoAbierto();
		// this.estadoRequisito=new requisitoAbierto();
		// aqui no deberia hacer proyecto_agregar_requisito(this)
	}

	public EstadoRequisito getEstadoRequisito() {
		return this.estado;
	}

	public void setEstadoRequisito(EstadoRequisito estado) {
		this.estado = estado;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getNecesidad() {
		return necesidad;
	}

	public void setNecesidad(String necesidad) {
		this.necesidad = necesidad;
	}

	public String getPrioridad() {
		return prioridad;
	}

	public void setPrioridad(String prioridad) {
		this.prioridad = prioridad;
	}

	public String getRiesgo() {
		return riesgo;
	}

	public void setRiesgo(String riesgo) {
		this.riesgo = riesgo;
	}

	abstract public void agregar(Requisito requisito);

	abstract public void eliminar(Requisito requisito);

	abstract Boolean compuesto();

}
