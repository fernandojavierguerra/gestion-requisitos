package com.durgam.guerra.dominio;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;

@Entity
public class RequisitoReabierto extends EstadoRequisito {
	static final String descripcion = "Reabierto";
	private static RequisitoReabierto estado;

	public RequisitoReabierto() {
		super((long) 3, descripcion);
		
	}

	public static RequisitoReabierto getEstado() {
		if (estado == null) {
			estado = new RequisitoReabierto();
		}
		return estado;
	}

	@Override
	public List<EstadoRequisito> siguiente() {

		// Posibles: Resuelto, enProgreso, Cerrado
		List<EstadoRequisito> lista = new ArrayList<EstadoRequisito>();
		RequisitoResuelto resuelto = new RequisitoResuelto();
		RequisitoEnProgreso enProgreso = new RequisitoEnProgreso();
		RequisitoCerrado cerrado = new RequisitoCerrado();
		lista.add(resuelto);
		lista.add(enProgreso);
		lista.add(cerrado);
		return lista;
	}

}
