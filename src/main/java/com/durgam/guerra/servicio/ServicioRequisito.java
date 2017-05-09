package com.durgam.guerra.servicio;

import java.util.ArrayList;
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
import com.durgam.guerra.dominio.RequisitoResuelto;
import com.durgam.guerra.dominio.RequisitoSimple;
import com.durgam.guerra.repositorio.RepositorioEstado;
import com.durgam.guerra.repositorio.RepositorioRequisito;
import com.durgam.guerra.repositorio.RepositorioRequisitoCompuesto;
import com.durgam.guerra.repositorio.RepositorioRequisitoSimple;
@Service
@Repository
public class ServicioRequisito {
	@Autowired
	private RepositorioRequisito repositorioRequisito ;
	@Autowired
	private RepositorioEstado repositorioEstado;
	@Autowired
	private RepositorioRequisitoCompuesto repositorioCompuesto;
	@Autowired
	private RepositorioRequisitoSimple repositorioSimple;
	@PostConstruct // La anotación PostConstruct se utiliza en un método que debe ejecutarse tras una inyección de dependencia para efectuar cualquier inicialización
	@Transactional
	public void populate(){
	//Sin cargar requisito podria migrar de requisito simople
GestionRequisito app= GestionRequisito.getSistema();
		
		Proyecto proyecto4 = new Proyecto ("Proyecto 4", "Cambio de version de BBDD");
		Proyecto proyecto2 = new Proyecto ("Proyecto 2", "Proyecto Semaforos");
		Proyecto proyecto3 = new Proyecto ("Proyecto 3", "Sistema Contable");
		proyecto4.agregarRequisito(new RequisitoSimple(0, "Req1Proy1","Tensión Arterial","Media","Deshidratación", null));
		proyecto4.agregarRequisito(new RequisitoSimple(0, "Req2Proy1","Cierre Automatico de Puertas","Alta","Suministro Electrico Interrumpido", null));
		proyecto2.agregarRequisito(new RequisitoSimple(0, "Req1Proy2","Despachar Cajero Automatico","Media","Seguridad de Cierre", null));
		proyecto2.agregarRequisito(new RequisitoSimple(0, "Req2Proy2","Desemcriptar Llave Bancaria","Alta","Sobrecarga Algoritmica", null));
		proyecto3.agregarRequisito(new RequisitoSimple(0, "Req1Proy3","Mayor Productividad","Alta","Costo de Oportunidad", null));
		proyecto3.agregarRequisito(new RequisitoSimple(0, "Req2Proy3","Menor tiempo de Respuesta","Media","Latencia ente request", null));
		app.agregarProyecto(proyecto4);
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
		EstadoRequisito estado =repositorioEstado.findOne(RequisitoAbierto.getEstado().getId());
		requisito.setEstadoRequisito(estado);
		repositorioRequisito.save(requisito);
	}
	@Transactional
	public void ActualizarRequisito(RequisitoSimple requisito){
		repositorioRequisito.saveAndFlush(requisito);
	}	
	
	@Transactional
	public RequisitoCompuesto buscarRequisitoCompuestoPorId(Long id){
		return repositorioCompuesto.findOne(id);
	}
	
	@Transactional
	public RequisitoSimple buscarRequisitoSimplePorId(Long id){
		return repositorioSimple.findOne(id);
	}
	
	@Transactional
	public Requisito buscarRequisitoPorId(Long id){
		Requisito requisito =repositorioRequisito.findOne(id);
		if(repositorioSimple.exists(requisito.getId())){
		return repositorioSimple.findOne(id);
		}else {
			return repositorioCompuesto.findOne(id);
			
		}
		
		
		
	}
	@Transactional
	public Requisito cambiarEstado(Long id, EstadoRequisito estado){
		Requisito requisito= this.buscarRequisitoPorId(id);
	requisito.setEstadoRequisito(estado);
		return requisito;
	}
	
	
	@Transactional
	public List<Requisito> buscarComposicionPorId(Long id) {
		List<Requisito> lista = new ArrayList<Requisito>();
		if (repositorioCompuesto.exists(id)){
			lista= repositorioCompuesto.findOne(id).getListrequisito();
		}else
		{
		lista=null;	
		}
		
		return lista;
		// TODO Auto-generated method stub
		
	}
}
