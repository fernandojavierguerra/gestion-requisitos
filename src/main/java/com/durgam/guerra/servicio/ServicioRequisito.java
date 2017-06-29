package com.durgam.guerra.servicio;
import java.util.ArrayList;
import java.util.List;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import com.durgam.guerra.dominio.EstadoRequisito;
import com.durgam.guerra.dominio.GestionRequisito;
import com.durgam.guerra.dominio.Proyecto;
import com.durgam.guerra.dominio.Requisito;
import com.durgam.guerra.dominio.RequisitoCerrado;
import com.durgam.guerra.dominio.RequisitoCompuesto;
import com.durgam.guerra.dominio.RequisitoEnProgreso;
import com.durgam.guerra.dominio.RequisitoReabierto;
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
	private ServicioEstados estados;
	@Autowired
	private ServicioProyecto servicioProyecto;
	@Autowired
	private RepositorioRequisitoCompuesto repositorioCompuesto;
	@Autowired
	private RepositorioRequisitoSimple repositorioSimple;
	
	@Transactional
    public void borrarRequisitoPorId(Long id) {
		Requisito requisito =repositorioRequisito.findOne(id);
		requisito.setEstadoRequisito(null);
		repositorioRequisito.delete(requisito.getId());		
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
	public void NuevoRequisito(Requisito requisito){
		EstadoRequisito estado =estados.abierto();
		requisito.setEstadoRequisito(estado);
		repositorioRequisito.save(requisito);
	}
	
	//@Transactional
	//public void ActualizarRequisito(Requisito requisito){
	//	repositorioRequisito.saveAndFlush(requisito);
	//}	
	
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
	public Requisito NuevoRequisitoSimple(){
		//aqui
		return new RequisitoSimple();
	}
	
	@Transactional
	public Requisito NuevoRequisitoCompuesto(){
		return new RequisitoCompuesto();
	}
	
	@Transactional
	public Requisito cambiarEstado(Long id, EstadoRequisito estado){
		Requisito requisito= this.buscarRequisitoPorId(id);
	requisito.setEstadoRequisito(estado);
		return requisito;
	}
	
	@Transactional
	public void grabarRequisito(Requisito requisito){		
		this.NuevoRequisito(requisito);
	}
	
	@Transactional
	public void agregarRequisitoSimpleaCompuesto(RequisitoSimple requisitoSimple,RequisitoCompuesto requisitoCompuesto){		
		requisitoSimple.setEstado(requisitoCompuesto.getEstado());
		requisitoSimple.setProyecto(requisitoCompuesto.getProyecto());
		requisitoCompuesto.getRequisitos().add(requisitoSimple);
		
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
	}
	
	public Object cambiarEstadoResuelto(Long id) {
		return this.cambiarEstado(id, repositorioEstado.findOne(RequisitoResuelto.getEstado().getId()));
	}
	
	public Object cambiarEstadoCerrado(Long id) {
		return this.cambiarEstado(id,repositorioEstado.findOne(RequisitoCerrado.getEstado().getId()));
	}
	
	public Object cambiarEstadoReabierto(Long id) {
		return this.cambiarEstado(id, repositorioEstado.findOne(RequisitoReabierto.getEstado().getId()));
	}
	
	public Object cambiarEstadoEnProgreso(Long id) {
		// TODO Auto-generated method stub
		return this.cambiarEstado(id, repositorioEstado.findOne(RequisitoEnProgreso.getEstado().getId()));
	}
}
