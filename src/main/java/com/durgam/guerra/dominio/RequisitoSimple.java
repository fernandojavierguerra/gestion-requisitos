package com.durgam.guerra.dominio;

import javax.persistence.Entity;
import javax.persistence.PrimaryKeyJoinColumn;


@Entity
@PrimaryKeyJoinColumn(name="id")
public class RequisitoSimple extends Requisito {

	

	public RequisitoSimple() {
		super();
		// TODO Auto-generated constructor stub
	}

	public RequisitoSimple(long id, String nombre, String necesidad, String prioridad, String riesgo,
			Proyecto proyecto) {
		super(id,nombre, necesidad, prioridad, riesgo, proyecto);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void agregar(Requisito requisito) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void eliminar(Requisito requisito) {
		// TODO Auto-generated method stub
		
	}

	@Override
	Boolean compuesto() {
		// TODO Auto-generated method stub
		return Boolean.FALSE;
	}

}
