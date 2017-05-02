package com.durgam.guerra.dominio;

import java.util.ArrayList;
import java.util.List;

public class RequisitoCerrado extends EstadoRequisito {
	static final String descripcion="Cerrado";
	private static RequisitoCerrado estado;

	public RequisitoCerrado() {
		super(1,descripcion);
		
		// TODO Auto-generated constructor stub
	}

	@Override
	public void resolver() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<EstadoRequisito> siguiente() {
		//Posibles: ninguno :)
		List<EstadoRequisito> lista=new ArrayList<EstadoRequisito>();
		RequisitoResuelto resuelto= new RequisitoResuelto();
		RequisitoCerrado cerrado = new RequisitoCerrado();
		lista.add(resuelto);
		lista.add(cerrado);
		
		return lista;
	
	}
	public static RequisitoCerrado getEstado() {
		 
		 if (estado==null) {
		  estado=new RequisitoCerrado();
		 }
		 return estado;
		 }



}
