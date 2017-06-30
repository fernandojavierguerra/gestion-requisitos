package com.durgam.guerra.dominio;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.Entity;

@Entity
public class RequisitoEnProgreso extends EstadoRequisito {
	static final String descripcion="EnProgreso";
	private static RequisitoEnProgreso estado;
	
	public RequisitoEnProgreso() {
		super((long) 4,descripcion);
		
	}
	

	
	public static RequisitoEnProgreso getEstado() {
		if (estado == null) {
			estado = new RequisitoEnProgreso();
		}
		return estado;
	}
	
	@Override
	public List<EstadoRequisito> siguiente() {
		//Posibles: Resuelto, Cerrado, abierto, reabierto
		List<EstadoRequisito> lista=new ArrayList<EstadoRequisito>();
		RequisitoResuelto resuelto= new RequisitoResuelto();
		RequisitoCerrado cerrado = new RequisitoCerrado();
		RequisitoAbierto abierto = new RequisitoAbierto();
		RequisitoReabierto reabierto = new RequisitoReabierto();
		lista.add(resuelto);
		lista.add(cerrado);
		lista.add(abierto);
		lista.add(reabierto);
		return lista;
	}
}
