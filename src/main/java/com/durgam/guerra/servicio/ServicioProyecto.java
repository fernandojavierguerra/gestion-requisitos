package com.durgam.guerra.servicio;

import java.util.List;
import javax.annotation.PostConstruct;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import com.durgam.guerra.dominio.GestionRequisito;
import com.durgam.guerra.dominio.Proyecto;
//import com.durgam.guerra.dominio.RequisitoCompuesto;
//import com.durgam.guerra.dominio.RequisitoSimple;
import com.durgam.guerra.repositorio.RepositorioProyecto;

@Service
@Repository
public class ServicioProyecto {
//	@PersistenceContext	(name = "persistencia")
//	private EntityManager entityManager;
	
	@Autowired
	private RepositorioProyecto repositorioProyecto;
	@PostConstruct // La anotación PostConstruct se utiliza en un método que debe ejecutarse tras una inyección de dependencia para efectuar cualquier inicialización
	@Transactional
	public void populate(){
//		GestionRequisito app= GestionRequisito.getSistema();
//		System.out.println("Creando Proyectos en la Base de Datos");
//		Proyecto proyecto1 = new Proyecto ("Proyecto 1", "Cambio de version de BBDD");
//		Proyecto proyecto2 = new Proyecto ("Proyecto 2", "Proyecto Semaforos");
//		Proyecto proyecto3 = new Proyecto ("Proyecto 3", "Sistema Contable");
//		proyecto1.agregarRequisito(new RequisitoSimple(0, "Req1Proy1","Tensión Arterial","Media","Deshidratación", null));
//		proyecto1.agregarRequisito(new RequisitoSimple(0, "Req2Proy1","Cierre Automatico de Puertas","Alta","Suministro Electrico Interrumpido", null));
//		proyecto2.agregarRequisito(new RequisitoSimple(0, "Req1Proy2","Despachar Cajero Automatico","Media","Seguridad de Cierre", null));
//		proyecto2.agregarRequisito(new RequisitoSimple(0, "Req2Proy2","Desemcriptar Llave Bancaria","Alta","Sobrecarga Algoritmica", null));
//		proyecto3.agregarRequisito(new RequisitoSimple(0, "Req1Proy3","Mayor Productividad","Alta","Costo de Oportunidad", null));
//		proyecto3.agregarRequisito(new RequisitoSimple(0, "Req2Proy3","Menor tiempo de Respuesta","Media","Latencia ente request", null));
//		app.agregarProyecto(proyecto1);
//		app.agregarProyecto(proyecto2);
//		app.agregarProyecto(proyecto3);
//		RequisitoSimple req1 = new RequisitoSimple(0, "Req1","Mantener Cartera Clientes","Alta","Costo de Oportunidad", null);
//		RequisitoSimple req2 = new RequisitoSimple(0, "Req2","Minimizar tiempo de respusta de atencion","Media","Fidelidad del Cliente", null);
//		RequisitoSimple req3 = new RequisitoSimple(0, "Req3","Movimientos de Expedientes","Baja","Costos de Papeleo", null);
//		RequisitoSimple req4 = new RequisitoSimple(0, "Req4","Provision de Medicamentos","Alta","Alta disponibilidad de entrega", null);
//		Proyecto proyecto4 = new Proyecto ("Proyecto 4", "Cambio de version de BBDD");
//		proyecto4.agregarRequisito(req1);
//		proyecto4.agregarRequisito(req2);
//		proyecto4.agregarRequisito(req3);
//		proyecto4.agregarRequisito(req4);
//		proyecto4.agregarRequisito(new RequisitoSimple(0, "Req1Proy1","Tensión Arterial","Media","Deshidratación", null));
//		proyecto4.agregarRequisito(new RequisitoSimple(0, "Req2Proy1","Cierre Automatico de Puertas","Alta","Suministro Electrico Interrumpido", null));
//		RequisitoSimple reqComp1= new RequisitoSimple(0, "ReqSimple1Compu1","Reducir Tiempo de Entrega","Alta","Nueva Tecnologia", null);
//		RequisitoSimple reqComp2= new RequisitoSimple(0, "ReqSimple2Compu1","Reubicacion de Personal","Media","Profesionales Capacitados", null);
//		RequisitoSimple reqComp3= new RequisitoSimple(0, "ReqSimple3Compu1","Mayor Cartera de Clientes","Alta","Inversores de Corto plazo", null);
//		RequisitoCompuesto compuesto1= new RequisitoCompuesto(0, "ComReq1","Reducir tiempo de Desarrollo","Muy Alta","Comunicación Insuficiente",null);
//		compuesto1.agregar(reqComp1);
//		compuesto1.agregar(reqComp2);
//		compuesto1.agregar(reqComp3);
//		proyecto4.agregarRequisito(compuesto1);
//		app.agregarProyecto(proyecto4);
		}
	
	@Transactional
	public List<Proyecto> obtenerTodosLosProyectos() {
		return repositorioProyecto.findAll();
	}
	
	
	@Transactional
	public void borrarProyecto(Proyecto proyecto){
		repositorioProyecto.delete(proyecto.getId());
	}
	
	@Transactional
	public void borrarProyectoId(Long id){
		repositorioProyecto.delete(id);
	}
	
	@Transactional
	public void NuevoProyecto(Proyecto proyecto){
		repositorioProyecto.save(proyecto);
	}
	
	@Transactional
	public Proyecto NuevoProyecto(){
			return new Proyecto();
	}
	
	@Transactional
	public Proyecto buscarProyectoPorId(Long id){
			return repositorioProyecto.findOne(id);
	}
}

