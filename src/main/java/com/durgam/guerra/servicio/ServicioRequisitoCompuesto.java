package com.durgam.guerra.servicio;

import javax.annotation.PostConstruct;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import com.durgam.guerra.dominio.RequisitoCompuesto;
import com.durgam.guerra.dominio.RequisitoSimple;
import com.durgam.guerra.repositorio.RepositorioRequisito;


@Service
@Repository
public class ServicioRequisitoCompuesto {
	@Autowired
	private RepositorioRequisito repositorioReqCompuesto;
	@PostConstruct // La anotación PostConstruct se utiliza en un método que debe ejecutarse tras una inyección de dependencia para efectuar cualquier inicialización
	@Transactional
	public void populate(){
		System.out.println("Creando Requisitos Compuestos en la Base de Datos");
		RequisitoSimple req1= new RequisitoSimple(0, "ReqSimple1Compu1","Reducir Tiempo de Entrega","Alta","Nueva Tecnologia", null);
		RequisitoSimple req2= new RequisitoSimple(0, "ReqSimple2Compu1","Reubicacion de Personal","Media","Profesionales Capacitados", null);
		RequisitoSimple req3= new RequisitoSimple(0, "ReqSimple3Compu1","Mayor Cartera de Clientes","Alta","Inversores de Corto plazo", null);
		RequisitoCompuesto compuesto1= new RequisitoCompuesto(0, "ComReq1","Reducir tiempo de Desarrollo","Muy Alta","Comunicación Insuficiente",null);
		compuesto1.agregar(req1);
		compuesto1.agregar(req2);
		compuesto1.agregar(req3);
		System.out.println(compuesto1.getNombre());
		repositorioReqCompuesto.saveAndFlush(compuesto1);
	}
}
