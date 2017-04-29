package com.durgam.guerra.dominio;

public class RequisitoCerrado extends EstadoRequisito {
	static final String descripcion="cerrado";

	public RequisitoCerrado() {
		super(1,descripcion);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void resolver() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void siguiente() {
		// TODO Auto-generated method stub
		//Posibles: ninguno :)
	}


}
