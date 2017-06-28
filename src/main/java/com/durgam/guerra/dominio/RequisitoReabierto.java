package com.durgam.guerra.dominio;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;

@Entity
public class RequisitoReabierto extends EstadoRequisito {
	static final String descripcion="Reabierto";
	private static RequisitoReabierto estado;
	

	public RequisitoReabierto() {
		super((long) 4,descripcion);
		// TODO Auto-generated constructor stub
	}
	
	@Override
	public List<EstadoRequisito> siguiente() {
		// TODO Auto-generated method stub
		// Posibles: Resuelto, enProgreso, Cerrad0
		List<EstadoRequisito> lista=new ArrayList<EstadoRequisito>();
		RequisitoResuelto resuelto= new RequisitoResuelto();
		RequisitoEnProgreso enProgreso = new RequisitoEnProgreso();
		RequisitoCerrado cerrado = new RequisitoCerrado();
		lista.add(resuelto);
		lista.add(enProgreso);
		lista.add(cerrado);
		return lista;
	}
	
	public static RequisitoReabierto getEstado() {
		if (estado == null) {
			estado = new RequisitoReabierto();
		}
		return estado;
	}

}
