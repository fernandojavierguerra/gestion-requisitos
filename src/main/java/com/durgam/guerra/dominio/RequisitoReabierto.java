package com.durgam.guerra.dominio;

import javax.persistence.Entity;

@Entity
public class RequisitoReabierto extends EstadoRequisito {
	static final String descripcion="Reabierto";
	@Override
	public void resolver() {
		// TODO Auto-generated method stub
		
	}
	public RequisitoReabierto() {
		super(1,descripcion);
		// TODO Auto-generated constructor stub
	}
	@Override
	public void siguiente() {
		// TODO Auto-generated method stub
		// Posibles: Resuelto, enProgreso, Cerrado
	}
}
