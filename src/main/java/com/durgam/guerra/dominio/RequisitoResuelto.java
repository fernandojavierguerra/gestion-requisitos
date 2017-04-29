package com.durgam.guerra.dominio;

import javax.persistence.Entity;


@Entity
public class RequisitoResuelto extends EstadoRequisito {
	static final String descripcion="Resuelto";
	@Override
	public void resolver() {
		// TODO Auto-generated method stub
		
	}
	public RequisitoResuelto() {
		super(1,descripcion);
		// TODO Auto-generated constructor stub
	}
	@Override
	public void siguiente() {
		// TODO Auto-generated method stub
		//Posibles: Reabierto, Cerrado
	}

}