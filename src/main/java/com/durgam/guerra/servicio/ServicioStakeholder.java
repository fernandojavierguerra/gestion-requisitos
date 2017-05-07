package com.durgam.guerra.servicio;


import java.util.List;

import javax.annotation.PostConstruct;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import com.durgam.guerra.dominio.RequisitoSimple;
import com.durgam.guerra.dominio.Stakeholder;
import com.durgam.guerra.repositorio.RepositorioStakeholder;


@Service
@Repository
public class ServicioStakeholder {
	@Autowired
	private RepositorioStakeholder repositorioStakeholder;

//	@PostConstruct // La anotación PostConstruct se utiliza en un método que debe ejecutarse tras una inyección de dependencia para efectuar cualquier inicialización
//	@Transactional
//	public void populate(){
//		System.out.println("Creando Stakeholders en la Base de Datos");
//		Stakeholder analistaJunior= new Stakeholder((long) 0, "23456789","Martin","Progarmador1", "ProgramadorJunior");
//		Stakeholder analistaSenior= new Stakeholder((long) 0, "23456789","Luis","AnalistaSeñior1", "Analista Principarl");
//		RequisitoSimple requisito1= new RequisitoSimple(0, "nombre","necesidad","prioridad","riesgo",null);
//		RequisitoSimple requisito2= new RequisitoSimple(0, "nombre","necesidad","prioridad","riesgo",null);
//		RequisitoSimple requisito3= new RequisitoSimple(0, "nombre","necesidad","prioridad","riesgo",null);
//		analistaJunior.agragarRequisito(requisito1);
//		analistaJunior.agragarRequisito(requisito2);
//		analistaSenior.agragarRequisito(requisito3);
//		repositorioStakeholder.saveAndFlush(analistaJunior);
//		repositorioStakeholder.saveAndFlush(analistaSenior);
//		
//	}
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

