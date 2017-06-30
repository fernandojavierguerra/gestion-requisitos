package com.durgam.guerra.dominio;

import java.util.ArrayList;
import java.util.List;
import javax.persistence.Entity;

@Entity
public class RequisitoCerrado extends EstadoRequisito {
	static final String descripcion = "Cerrado";
	private static RequisitoCerrado estado;

	public RequisitoCerrado() {
		super((long) 1, descripcion);
	}

	public static RequisitoCerrado getEstado() {
		if (estado == null) {
			estado = new RequisitoCerrado();
		}
		return estado;
	}

	@Override
	public List<EstadoRequisito> siguiente() {
		List<EstadoRequisito> lista = new ArrayList<EstadoRequisito>();
		RequisitoReabierto reabierto = new RequisitoReabierto();
		lista.add(reabierto);
		return lista;

	}
}
