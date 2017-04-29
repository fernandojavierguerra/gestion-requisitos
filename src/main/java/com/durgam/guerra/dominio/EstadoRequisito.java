package com.durgam.guerra.dominio;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;

@Entity
@Inheritance(strategy=InheritanceType.JOINED)
abstract public class EstadoRequisito {
	public EstadoRequisito() {
		super();
		// TODO Auto-generated constructor stub
	}

	public EstadoRequisito(long id, String descripcionEstado) {
		super();
		this.id = id;
		this.descripcionEstado = descripcionEstado;
	}

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)	
	private long id;
	private String descripcionEstado;
	

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}
	

	public String getDescripcionEstado() {
		return descripcionEstado;
	}

	public void setDescripcionEstado(String descripcionEstado) {
		this.descripcionEstado = descripcionEstado;
	}
	
	abstract public void siguiente();
	
	abstract public void resolver();

	//abstract public void cerrar();
	
	//abstract public void iniciarProgreso();
	
	//abstract public void detenerProgreso();
	
	//abstract public void reabrir();
	
	}

