package com.durgam.guerra.servicio;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import com.durgam.guerra.dominio.EstadoRequisito;
import com.durgam.guerra.dominio.Requisito;
import com.durgam.guerra.dominio.RequisitoResuelto;
import com.durgam.guerra.dominio.RequisitoSimple;
import com.durgam.guerra.repositorio.RepositorioRequisito;
@Service
@Repository
public class ServicioRequisito {
	@Autowired
	private RepositorioRequisito repositorioRequisito ;
	@PostConstruct // La anotación PostConstruct se utiliza en un método que debe ejecutarse tras una inyección de dependencia para efectuar cualquier inicialización
	@Transactional
	public void populate(){
	//Sin cargar requisito podria migrar de requisito simople
	}
	@Transactional
    public void borrarRequisitoPorId(Long id) {

		repositorioRequisito.delete(id);
	}
	@Transactional
    public void borrarRequisito(RequisitoSimple requisito) {

		repositorioRequisito.delete(requisito.getId());
	}
	@Transactional
	public List<Requisito> obtenerTodosLosRequisitos(){
		return repositorioRequisito.findAll();
	}
	@Transactional
	public void NuevoRequisito(RequisitoSimple requisito){
		repositorioRequisito.save(requisito);
	}
	@Transactional
	public void ActualizarRequisito(RequisitoSimple requisito){
		repositorioRequisito.saveAndFlush(requisito);
	}	
	@Transactional
	public Requisito buscarRequisitoPorId(Long id){
			return repositorioRequisito.findOne(id);
	}
	@Transactional
	public Requisito cambiarEstado(Long id, EstadoRequisito estado) {
		Requisito requisito = repositorioRequisito.findOne(id);
		
		requisito.setEstadoRequisito(estado);
		return requisito;
		
		// TODO Auto-generated method stub
		
	}
}
