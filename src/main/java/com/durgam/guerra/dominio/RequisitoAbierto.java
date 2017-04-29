package com.durgam.guerra.dominio;

import javax.persistence.Entity;
import javax.persistence.PrimaryKeyJoinColumn;

@Entity
@PrimaryKeyJoinColumn(name="estadoRequisito")
public class RequisitoAbierto extends EstadoRequisito{
	static final String descripcion="Abierto";
	public RequisitoAbierto() {
		super(1,descripcion);
		// TODO Auto-generated constructor stub
	}

	
	@Override
	public void resolver() {
		// TODO Auto-generated method stub
		
	}


	@Override
	public void siguiente() {
		// TODO Auto-generated method stub
		//posibles: Resuelto, Cerrado, enProgreso
		
	}
}
