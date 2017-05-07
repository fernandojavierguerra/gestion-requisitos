package com.durgam.guerra.dominio;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.PrimaryKeyJoinColumn;

@Entity
@PrimaryKeyJoinColumn(name = "estadoRequisito")
public class RequisitoAbierto extends EstadoRequisito {
	static final String descripcion = "Abierto";
	private static RequisitoAbierto estado;

	public RequisitoAbierto() {
		super((long) 1, descripcion);
		//this.siguiente();
		// TODO Auto-generated constructor stub
	}

	@Override
	public void resolver() {
		// TODO Auto-generated method stub

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
		RequisitoAbierto cerrado = new RequisitoAbierto();
		lista.add(resuelto);
		lista.add(cerrado);

		return lista;

		// TODO Auto-generated method stub
		// posibles: Resuelto, Cerrado, enProgreso
		// TODO Auto-generated method stub

	}

}
