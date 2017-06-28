package com.durgam.guerra.dominio;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.Entity;

@Entity
public class RequisitoCerrado extends EstadoRequisito {
	static final String descripcion = "Cerrado";
	private static RequisitoCerrado estado;

	public RequisitoCerrado() {
		super((long) 2, descripcion);
	}

	public static RequisitoCerrado getEstado() {
		if (estado == null) {
			estado = new RequisitoCerrado();
		}
		return estado;
	}

	@Override
	public List<EstadoRequisito> siguiente() {
		// Posibles: ninguno :)
		List<EstadoRequisito> lista = new ArrayList<EstadoRequisito>();
		RequisitoResuelto resuelto = new RequisitoResuelto();
		RequisitoCerrado cerrado = new RequisitoCerrado();
		lista.add(resuelto);
		lista.add(cerrado);
		return lista;

	}
}
