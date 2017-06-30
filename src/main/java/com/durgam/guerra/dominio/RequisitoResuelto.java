package com.durgam.guerra.dominio;

import java.util.ArrayList;
import java.util.List;
import javax.persistence.Entity;

@Entity
public class RequisitoResuelto extends EstadoRequisito {
	static final String descripcion = "Resuelto";
	private static RequisitoResuelto estado;

	public RequisitoResuelto() {
		super((long) 2, descripcion);
	}

	public static RequisitoResuelto getEstado() {
		if (estado == null) {
			estado = new RequisitoResuelto();
		}
		return estado;
	}

	@Override
	public List<EstadoRequisito> siguiente() {
		//// Posibles: Reabierto, Cerrado
		List<EstadoRequisito> lista = new ArrayList<EstadoRequisito>();
		RequisitoReabierto reabierto = new RequisitoReabierto();
		RequisitoCerrado cerrado = new RequisitoCerrado();
		lista.add(reabierto);
		lista.add(cerrado);
		return lista;
	}
}