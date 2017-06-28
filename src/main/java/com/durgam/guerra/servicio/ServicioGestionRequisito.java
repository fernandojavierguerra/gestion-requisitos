package com.durgam.guerra.servicio;

import java.util.List;
import javax.annotation.PostConstruct;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.interceptor.TransactionAspectSupport;

import com.durgam.guerra.dominio.GestionRequisito;
import com.durgam.guerra.dominio.Proyecto;
import com.durgam.guerra.repositorio.RepositorioGestionRequisito;

@Service
@Repository
public class ServicioGestionRequisito {
	@Autowired
	private RepositorioGestionRequisito repositorioGestReq;

	@Transactional
	public List<GestionRequisito> obtenerTodosLosGestionRequisito() {
		return repositorioGestReq.findAll();

	}

	@Transactional
	public void NuevoGestionRequisito(GestionRequisito app) {
		repositorioGestReq.saveAndFlush(app);
	}

	@Transactional
	public void GrabarGestionRequisito(GestionRequisito app) {
		try {
			repositorioGestReq.saveAndFlush(app);
		} catch (Exception ex) {
			
			TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
			System.out.println("Rollback");		
		}

	}

	@Transactional
	public GestionRequisito buscarGestionRequisitoPorId(Long id) {

		return repositorioGestReq.findOne(id);
	}
	@Transactional
	public GestionRequisito removerProyecto(GestionRequisito gestion, Proyecto proyecto) {
		gestion.getProyectos().remove(proyecto);
		proyecto.setAplicacion(null);
		return gestion;
	}
	@Transactional
	public GestionRequisito agregarProyecto(GestionRequisito gestion, Proyecto proyecto) {
		gestion.getProyectos().add(proyecto);
		proyecto.setAplicacion(gestion);
		return gestion;
	}
}
