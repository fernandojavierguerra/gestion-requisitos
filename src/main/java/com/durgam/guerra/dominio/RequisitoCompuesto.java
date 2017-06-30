package com.durgam.guerra.dominio;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;
import javax.persistence.PrimaryKeyJoinColumn;

@Entity
@PrimaryKeyJoinColumn(name = "id")
public class RequisitoCompuesto extends Requisito {
	
	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	private List<Requisito> requisitos;

//	@Override
//	public String getNombre() {
	public String getTodosLosNombres() {
		// recorrer lista de requisitos, retornando el nombre de cada uno
		String nombre = "";
		for (int i = 0; i < this.getListrequisito().size(); i++) {
			nombre = nombre + this.getListrequisito().get(i).getNombre();
		}
		return nombre;
	}
	
	@Override
	public void setProyecto(Proyecto proyecto) {
		for (int i = 0; i < this.getListrequisito().size(); i++) {
			this.getListrequisito().get(i).setProyecto(proyecto);
		}
		
		//this.proyecto = proyecto;
		super.setProyecto(proyecto);
	}
	
	public void agregar(Requisito requisito) {
		requisitos.add(requisito);
	}

	public List<Requisito> getListrequisito() {
		return requisitos;
	}

	public void setListrequisito(ArrayList<Requisito> listrequisito) {
		this.requisitos = listrequisito;
	}

	public RequisitoCompuesto(long id, String nombre, String necesidad, String prioridad, String riesgo,
			Proyecto proyecto) {
		super(id, nombre, necesidad, prioridad, riesgo, proyecto);
		requisitos = new ArrayList<Requisito>();
	}

	public RequisitoCompuesto() {
		super();
		requisitos = new ArrayList<Requisito>();
	}

	public Boolean compuesto() {
				return Boolean.TRUE;
	}

	public List<Requisito> getRequisitos() {
		return requisitos;
	}

	public void setRequisitos(List<Requisito> requisitos) {
		this.requisitos = requisitos;
	}
	
}
