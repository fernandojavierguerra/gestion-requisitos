package com.durgam.guerra.dominio;

import java.util.ArrayList;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;
import javax.persistence.PrimaryKeyJoinColumn;


@Entity
@PrimaryKeyJoinColumn(name="id")
public class RequisitoCompuesto extends Requisito {
	
	//@OneToMany(mappedBy="compuesto",cascade=(CascadeType.ALL))
	@OneToMany(cascade=CascadeType.ALL, fetch=FetchType.EAGER)
	private List<Requisito> requisitos;
	

	@Override
	public String getNombre() {
		//recorrer lista de requisitos, retornando el nombre de cada uno
	
		String nombre="";
		for (int i = 0; i < this.getListrequisito().size(); i++){
				nombre= nombre + this.getListrequisito().get(i).getNombre();
		
		}
		return nombre;
		
	}

	@Override
	public void agregar(Requisito requisito) {
		// TODO Auto-generated method stub
		 requisitos.add(requisito);
	}

	@Override
	public void eliminar(Requisito requisito) {
		// TODO Auto-generated method stub
		requisitos.remove(requisito);
		
	}

	public List<Requisito> getListrequisito() {
		return requisitos;
	}

	public void setListrequisito(ArrayList<Requisito> listrequisito) {
		this.requisitos = listrequisito;
	}

	public RequisitoCompuesto(long id, String nombre, String necesidad, String prioridad, String riesgo,
			Proyecto proyecto) {
		super(id,nombre, necesidad, prioridad, riesgo, proyecto);
	requisitos=new ArrayList<Requisito>();
	}
	public RequisitoCompuesto() {
		super();
		requisitos=new ArrayList<Requisito>();
	}

	@Override
	Boolean compuesto() {
		// TODO Auto-generated method stub
		return Boolean.TRUE;
	}
		
}
