package com.durgam.guerra.dominio;

import java.util.ArrayList;
import java.util.List;
import javax.persistence.Entity;

@Entity
public class RequisitoAbierto extends EstadoRequisito {
	static final String descripcion = "Abierto";
	private static RequisitoAbierto estado;

	public RequisitoAbierto() {
		super((long) 5, descripcion);
	}

	public static RequisitoAbierto getEstado() {
		if (estado == null) {
			estado = new RequisitoAbierto();
		}
		return estado;
	}

	@Override
	public List<EstadoRequisito> siguiente() {
		List<EstadoRequisito> lista = new ArrayList<EstadoRequisito>();
		RequisitoResuelto resuelto = new RequisitoResuelto();
		RequisitoCerrado cerrado = new RequisitoCerrado();
		RequisitoEnProgreso enProgreso = new RequisitoEnProgreso();
		lista.add(resuelto);
		lista.add(cerrado);
		lista.add(enProgreso);
		return lista;
	}

}
