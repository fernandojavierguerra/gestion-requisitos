package com.durgam.guerra.dominio;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;

@Entity
@Inheritance(strategy = InheritanceType.JOINED)
abstract public class EstadoRequisito {

	public EstadoRequisito() {
		super();
	}

	public EstadoRequisito(Long id, String descripcionEstado) {
		super();
		this.id = id;
		this.descripcionEstado = descripcionEstado;
	}

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	private String descripcionEstado;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getDescripcionEstado() {
		return descripcionEstado;
	}

	public void setDescripcionEstado(String descripcionEstado) {
		this.descripcionEstado = descripcionEstado;
	}

	abstract public List<EstadoRequisito> siguiente();
}
