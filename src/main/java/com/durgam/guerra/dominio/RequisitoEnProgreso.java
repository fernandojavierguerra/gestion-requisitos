package com.durgam.guerra.dominio;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.Entity;

@Entity
public class RequisitoEnProgreso extends EstadoRequisito {
	static final String descripcion="EnProgreso";
	private static RequisitoEnProgreso estado;
	
	public RequisitoEnProgreso() {
		super((long) 5,descripcion);
		// TODO Auto-generated constructor stub
	}
	
	@Override
	public List<EstadoRequisito> siguiente() {
		//Posibles: Resuelto, Cerrado
		List<EstadoRequisito> lista=new ArrayList<EstadoRequisito>();
		RequisitoResuelto resuelto= new RequisitoResuelto();
		RequisitoCerrado cerrado = new RequisitoCerrado();
		lista.add(resuelto);
		lista.add(cerrado);
		return lista;
	}
	
	public static RequisitoEnProgreso getEstado() {
		if (estado == null) {
			estado = new RequisitoEnProgreso();
		}
		return estado;
	}
}
