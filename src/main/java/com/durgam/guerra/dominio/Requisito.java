package com.durgam.guerra.dominio;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Version;

@Entity
@Inheritance(strategy = InheritanceType.JOINED)
public abstract class Requisito {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	private String nombre;
	private String necesidad;
	private String prioridad;
	private String riesgo;

	@ManyToOne(fetch = FetchType.EAGER)
	private Proyecto proyecto;
	
	@Version
	private Long version;
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

	public Boolean compuesto() {
		return null;
	}

	public Long getVersion() {
		return version;
	}

	public void setVersion(Long version) {
		this.version = version;
	}

	public EstadoRequisito getEstado() {
		return estado;
	}

	public void setEstado(EstadoRequisito estado) {
		this.estado = estado;
	}

}
