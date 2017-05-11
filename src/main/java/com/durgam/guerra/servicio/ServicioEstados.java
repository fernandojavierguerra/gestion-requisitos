package com.durgam.guerra.servicio;
import javax.annotation.PostConstruct;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import com.durgam.guerra.dominio.EstadoRequisito;
import com.durgam.guerra.dominio.RequisitoAbierto;
import com.durgam.guerra.dominio.RequisitoCerrado;
import com.durgam.guerra.dominio.RequisitoEnProgreso;
import com.durgam.guerra.dominio.RequisitoReabierto;
import com.durgam.guerra.dominio.RequisitoResuelto;
import com.durgam.guerra.repositorio.RepositorioEstado;
@Service
@Repository
public class ServicioEstados {

	@Autowired
	private RepositorioEstado estados;
	
	@PostConstruct // La anotación PostConstruct se utiliza en un método que debe ejecutarse tras una inyección de dependencia para efectuar cualquier inicialización
	@Transactional
	public void populate(){
		//estados.save(new RequisitoAbierto());
		estados.save(new RequisitoCerrado());
		estados.save(new RequisitoResuelto());
		estados.save(new RequisitoReabierto());
		estados.save(new RequisitoEnProgreso());
	}
	
	@Transactional
	public EstadoRequisito abierto(){
		return estados.findOne(RequisitoAbierto.getEstado().getId());
	}

	@Transactional
	public EstadoRequisito cerrado(){
		return estados.findOne(RequisitoCerrado.getEstado().getId());
	}
	@Transactional
	public EstadoRequisito Reabierto(){
		return estados.findOne(RequisitoReabierto.getEstado().getId());
	}
	
	@Transactional
	public EstadoRequisito Resuelto(){
		return estados.findOne(RequisitoResuelto.getEstado().getId());
	}
}
