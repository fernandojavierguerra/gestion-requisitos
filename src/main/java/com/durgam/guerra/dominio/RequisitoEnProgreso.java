package com.durgam.guerra.dominio;

import javax.persistence.Entity;

@Entity
public class RequisitoEnProgreso extends EstadoRequisito {
	static final String descripcion="En Progreso";
	@Override
	public void resolver() {
		// TODO Auto-generated method stub
		
	}
	public RequisitoEnProgreso() {
		super(1,descripcion);
		// TODO Auto-generated constructor stub
	}
}
