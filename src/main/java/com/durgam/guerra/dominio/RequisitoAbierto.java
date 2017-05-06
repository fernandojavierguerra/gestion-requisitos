package com.durgam.guerra.dominio;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.PrimaryKeyJoinColumn;

@Entity
@PrimaryKeyJoinColumn(name="estadoRequisito")
public class RequisitoAbierto extends EstadoRequisito{
	static final String descripcion="Abierto";
	
	public RequisitoAbierto() {
		super((long) 1,descripcion);
	this.siguiente();
		// TODO Auto-generated constructor stub
	}

	
	@Override
	public void resolver() {
		// TODO Auto-generated method stub
		
	}





	@Override
	public List<EstadoRequisito> siguiente() {
		List<EstadoRequisito> lista=new ArrayList<EstadoRequisito>();
		RequisitoResuelto resuelto= new RequisitoResuelto();
		RequisitoCerrado cerrado = new RequisitoCerrado();
		lista.add(resuelto);
		lista.add(cerrado);
		
		return lista;
		
		// TODO Auto-generated method stub
		//posibles: Resuelto, Cerrado, enProgreso
		// TODO Auto-generated method stub
		
	}


	
}
