package com.durgam.guerra.dominio;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;

@Entity
public class Stakeholder {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long id;
	private String nombre;
	private String apellido;
	private String rol;
	private String dni;
	
	@ManyToMany(cascade = CascadeType.ALL, mappedBy="stakeholder")
	//@JoinTable(name = "requisito_stakeholder")
	private List<Requisito> requisitos;
	
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
	public Stakeholder(Long id, String dni, String nombre, String apellido, String rol) {
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
	
	public void agregarRequisito(Requisito requisito){
		this.requisitos.add(requisito);
	}
	@Override
	public String toString() {
		return "Stakeholder [id=" + id + ", nombre=" + nombre + ", apellido=" + apellido + ", rol=" + rol + ", dni="
				+ dni + "]";
	}	
}
