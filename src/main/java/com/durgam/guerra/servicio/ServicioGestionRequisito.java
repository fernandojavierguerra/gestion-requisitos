package com.durgam.guerra.servicio;

import java.util.List;
import javax.annotation.PostConstruct;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import com.durgam.guerra.dominio.GestionRequisito;
import com.durgam.guerra.repositorio.RepositorioGestionRequisito;

@Service
@Repository
public class ServicioGestionRequisito {
	@Autowired
	private RepositorioGestionRequisito repositorioGestReq;
	@PostConstruct // La anotación PostConstruct se utiliza en un método que debe ejecutarse tras una inyección de dependencia para efectuar cualquier inicialización
	@Transactional
	public void populate(){
		System.out.println("Creando Objeto Aplicación en la Base de Datos");
		GestionRequisito app= GestionRequisito.getSistema();
		repositorioGestReq.saveAndFlush(app);
	}
	@Transactional
	public List<GestionRequisito> obtenerTodosLosGestionRequisito(){
		return repositorioGestReq.findAll();
		
	}
	@Transactional
	public void NuevoGestionRequisito(GestionRequisito app){
		repositorioGestReq.saveAndFlush(app);	
	}
}

