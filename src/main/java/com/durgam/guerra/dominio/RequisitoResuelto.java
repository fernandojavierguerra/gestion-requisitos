package com.durgam.guerra.dominio;

import java.util.ArrayList;
import java.util.List;

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
	public List<EstadoRequisito> siguiente() {
		// TODO Auto-generated method stub
		////Posibles: Reabierto, Cerrado
		List<EstadoRequisito> lista=new ArrayList<EstadoRequisito>();
		RequisitoReabierto reabierto= new RequisitoReabierto();
		RequisitoCerrado cerrado = new RequisitoCerrado();
		lista.add(reabierto);
		lista.add(cerrado);
		return lista;
	}
	

}