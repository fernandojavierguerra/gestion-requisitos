package com.durgam.guerra.servicio;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import com.durgam.guerra.dominio.Requisito;
import com.durgam.guerra.dominio.RequisitoSimple;
import com.durgam.guerra.repositorio.RepositorioRequisito;

@Service
@Repository
public class ServicioRequisitoSimple {
	@Autowired
	private RepositorioRequisito repositorioReqSimple ;
//	@PostConstruct // La anotación PostConstruct se utiliza en un método que debe ejecutarse tras una inyección de dependencia para efectuar cualquier inicialización
//	@Transactional
//	public void populate(){
//		System.out.println("Creando Requisitos Simples en la Base de Datos");
//		RequisitoSimple req1 = new RequisitoSimple(0, "Req1","Mantener Cartera Clientes","Alta","Costo de Oportunidad", null);
//		RequisitoSimple req2 = new RequisitoSimple(0, "Req2","Minimizar tiempo de respusta de atencion","Media","Fidelidad del Cliente", null);
//		RequisitoSimple req3 = new RequisitoSimple(0, "Req3","Movimientos de Expedientes","Baja","Costos de Papeleo", null);
//		RequisitoSimple req4 = new RequisitoSimple(0, "Req4","Provision de Medicamentos","Alta","Alta disponibilidad de entrega", null);
//	repositorioReqSimple.saveAndFlush(req1);
//	repositorioReqSimple.saveAndFlush(req2);
//	repositorioReqSimple.saveAndFlush(req3);
//	repositorioReqSimple.saveAndFlush(req4);
//	
//	
//	}
	@Transactional
    public void borrarRequisitoSimplePorId(Long id) {

		repositorioReqSimple.delete(id);
	}
	@Transactional
    public void borrarRequisitoSimple(RequisitoSimple requisito) {

		repositorioReqSimple.delete(requisito.getId());
	}
	@Transactional
	public List<Requisito> obtenerTodosLosRequisitosSimples(){
		return repositorioReqSimple.findAll();
	}
	@Transactional
	public void NuevoRequisitoSimple(RequisitoSimple requisito){
		repositorioReqSimple.save(requisito);
	}
	@Transactional
	public void ActualizarRequisitoSimple(RequisitoSimple requisito){
		repositorioReqSimple.saveAndFlush(requisito);
	}	
	@Transactional
	public Requisito buscarRequisitoSimplePorId(Long id){
			return repositorioReqSimple.findOne(id);
	}
}

