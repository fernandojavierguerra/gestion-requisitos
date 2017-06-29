package com.durgam.guerra.servicio;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import com.durgam.guerra.dominio.EstadoRequisito;
import com.durgam.guerra.dominio.GestionRequisito;
import com.durgam.guerra.dominio.Proyecto;
import com.durgam.guerra.dominio.Requisito;
import com.durgam.guerra.dominio.RequisitoAbierto;
import com.durgam.guerra.dominio.RequisitoCompuesto;
import com.durgam.guerra.dominio.RequisitoSimple;
import com.durgam.guerra.dominio.Stakeholder;
import com.durgam.guerra.repositorio.RepositorioProyecto;
import com.durgam.guerra.repositorio.RepositorioStakeholder;

@Service
@Repository
public class ServicioStakeholder {
	@Autowired
	private RepositorioStakeholder repositorioStakeholder;
	@Autowired
	private ServicioGestionRequisito servicioGestionRequisito;
	@Autowired
	private ServicioProyecto servicioProyecto;
	@Autowired
	private ServicioRequisito servicioRequisito;


	@PostConstruct // La anotación PostConstruct se utiliza en un método que debe ejecutarse tras una inyección de dependencia para efectuar cualquier inicialización
	@Transactional
	public void populate(){
	System.out.println("Creando Stakeholders en la Base de Datos");
		Stakeholder analistaJunior= new Stakeholder((long) 0, "23456789","Martin","Progarmador1", "ProgramadorJunior");
		Stakeholder analistaSenior= new Stakeholder((long) 0, "23456789","Luis","AnalistaSeñior1", "Analista Principarl");
		RequisitoSimple requisito1= new RequisitoSimple(0, "Compra Materiales","Contruccion de Obrador","Alta","Clima Frio",null);
		RequisitoSimple requisito2= new RequisitoSimple(0, "Migración Linux","Reducción de costos Licencia","Media","Multas",null);
		RequisitoSimple requisito3= new RequisitoSimple(0, "Armado de Estantes","Exponer","Baja","Ninguno",null);
		RequisitoCompuesto requisitoComp1= new RequisitoCompuesto(0, "Fase de Desarrooo","Contrata","Baja","Ninguno",null);
		RequisitoSimple requisitoSimpleCompuesto1= new RequisitoSimple(0, "FirmaContrato","Pagos","Baja","Ninguno",null);
		analistaJunior.agregarRequisito(requisito1);
		analistaJunior.agregarRequisito(requisito2);
		analistaSenior.agregarRequisito(requisito3);
		//repositorioStakeholder.saveAndFlush(analistaJunior);
		//repositorioStakeholder.saveAndFlush(analistaSenior);
		EstadoRequisito estado=RequisitoAbierto.getEstado();
		RequisitoSimple requisito4=new RequisitoSimple(0, "Alquiler","Vehiculos","Baja","Ninguna",null);
		
		requisito4.setEstado(estado);
		requisito3.setEstado(estado);
		requisito2.setEstado(estado);
		requisito1.setEstado(estado);
		requisitoComp1.setEstado(estado);
		
		 
		Proyecto proyecto= new Proyecto("Proyecto Alfa", "Alfa Proyect");
		
		GestionRequisito gestion = (servicioGestionRequisito.buscarGestionRequisitoPorId((long) 1));
		
		//gestion.getProyectos().get(0).getRequisitos().add(requisito4);
		
		servicioProyecto.agregarRequisito(gestion.getProyectos().get(0), requisito4); 
		servicioProyecto.agregarRequisito(gestion.getProyectos().get(0), requisito3); 
		servicioProyecto.agregarRequisito(gestion.getProyectos().get(1), requisito2); 
		servicioProyecto.agregarRequisito(gestion.getProyectos().get(2), requisito1); 
		servicioProyecto.agregarRequisito(gestion.getProyectos().get(2), requisitoComp1); 
		servicioGestionRequisito.agregarProyecto(gestion, proyecto);
		servicioRequisito.agregarRequisitoSimpleaCompuesto(requisitoSimpleCompuesto1, requisitoComp1);
		servicioGestionRequisito.GrabarGestionRequisito(gestion);
		
	}
	@Transactional
	public List<Stakeholder> obtenerTodosLosStakeholder() {
		return repositorioStakeholder.findAll();
	}
	@Transactional
	public void borrarStakeholder(Stakeholder stakeholder){
		repositorioStakeholder.delete(stakeholder.getId());
	}
	@Transactional
	public void borrarStakeholderId(Long id){
		repositorioStakeholder.delete(id);
	}
	
	
	@Transactional
	public Stakeholder NuevoStakeholder(){
		return new Stakeholder();
	}
	
	@Transactional
	public void NuevoStakeholder(Stakeholder stakeholder){
		repositorioStakeholder.save(stakeholder);
	}
	@Transactional
	public void ActualizarStakeholder(Stakeholder stakeholder){
		repositorioStakeholder.saveAndFlush(stakeholder);
	}
	@Transactional
	public Stakeholder buscarStakeholderPorId(Long id){
		return repositorioStakeholder.findOne(id);
	}
}

