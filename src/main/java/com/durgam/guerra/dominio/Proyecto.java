package com.durgam.guerra.dominio;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Version;
@Entity
public class Proyecto {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long id;
	private String nombreProyecto;
	private String descripcionProyecto;
	
	@Version
	private Long version;
	
	@ManyToOne(fetch = FetchType.EAGER)
	private GestionRequisito aplicacion;
	
//	@OneToMany(cascade=CascadeType.ALL, fetch=FetchType.EAGER)
//	private List<Requisito> requisitos= new ArrayList<Requisito>();
		
	
	public Proyecto() {
		
	}
	
	public Proyecto(String nombreProyecto, String descripcionProyecto) {
		this.nombreProyecto = nombreProyecto;
		this.descripcionProyecto = descripcionProyecto;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNombreProyecto() {
		return nombreProyecto;
	}

	public void setNombreProyecto(String nombreProyecto) {
		this.nombreProyecto = nombreProyecto;
	}

	public String getDescripcionProyecto() {
		return descripcionProyecto;
	}

	public void setDescripcionProyecto(String descripcionProyecto) {
		this.descripcionProyecto = descripcionProyecto;
	}
	
	public GestionRequisito getAplicacion() {
		return aplicacion;
	}

	public void setAplicacion(GestionRequisito aplicacion) {
		this.aplicacion = aplicacion;
	}

	@Override
	public String toString() {
		return "Proyecto [id=" + id + ", nombreProyecto=" + nombreProyecto + ", descripcionProyecto="
				+ descripcionProyecto + ", version=" + version + ", aplicacion=" + aplicacion + "]";
	}

	public void actualizarProyecto(String nombreProyecto, String descripcionProyecto) {
		this.setNombreProyecto(nombreProyecto);
		this.setDescripcionProyecto(descripcionProyecto);
		
	}

	

	public void setVersion(Long version) {
		this.version = version;
	}

	public Long getVersion() {
		// TODO Auto-generated method stub
		return null;
	}


	
	

//	public List<Requisito> getRequisitos() {
//		return requisitos;
//	}
//
//	public void setRequisitos(List<Requisito> requisitos) {
//		this.requisitos = requisitos;
//	}	
//	public String mostrarRequisitos(){
//		String nombre="";
//		for (int i = 0; i < this.getRequisitos().size(); i++){
//				nombre= nombre + this.getRequisitos().get(i).getNombre();
//		}
//		return nombre;
//	}


//	public void agregarRequisito(Requisito requisito) {
//		this.requisitos.add(requisito);
//	}
	
}

