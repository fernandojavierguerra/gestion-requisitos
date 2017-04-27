package com.durgam.guerra.servicio;

import java.util.List;
import javax.annotation.PostConstruct;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import com.durgam.guerra.dominio.Proyecto;
import com.durgam.guerra.dominio.RequisitoSimple;
import com.durgam.guerra.repositorio.RepositorioProyecto;
@Service
@Repository
public class ServicioProyecto {
	@Autowired
	private RepositorioProyecto repositorioProyecto;

	@PostConstruct // La anotación PostConstruct se utiliza en un método que debe ejecutarse tras una inyección de dependencia para efectuar cualquier inicialización
	@Transactional
	public void populate(){
		System.out.println("Creando Proyectos en la Base de Datos");
		Proyecto proyecto1 = new Proyecto ("Proyecto 1", "Cambio de version de BBDD");
		Proyecto proyecto2 = new Proyecto ("Proyecto 2", "Proyecto Semaforos");
		Proyecto proyecto3 = new Proyecto ("Proyecto 3", "Sistema Contable");
		proyecto1.agregarRequisito(new RequisitoSimple(0, "Req1Proy1","Tensión Arterial","Media","Deshidratación", null));
		proyecto1.agregarRequisito(new RequisitoSimple(0, "Req2Proy1","Cierre Automatico de Puertas","Alta","Suministro Electrico Interrumpido", null));
		proyecto2.agregarRequisito(new RequisitoSimple(0, "Req1Proy2","Despachar Cajero Automatico","Media","Seguridad de Cierre", null));
		proyecto2.agregarRequisito(new RequisitoSimple(0, "Req2Proy2","Desemcriptar Llave Bancaria","Alta","Sobrecarga Algoritmica", null));
		proyecto3.agregarRequisito(new RequisitoSimple(0, "Req1Proy3","Mayor Productividad","Alta","Costo de Oportunidad", null));
		proyecto3.agregarRequisito(new RequisitoSimple(0, "Req2Proy3","Menor tiempo de Respuesta","Media","Latencia ente request", null));
		repositorioProyecto.saveAndFlush(proyecto1);
		repositorioProyecto.saveAndFlush(proyecto2);
		repositorioProyecto.saveAndFlush(proyecto3);
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
	public void ActualizarProyecto(Proyecto proyecto){
		repositorioProyecto.saveAndFlush(proyecto);
	}	
	@Transactional
	public Proyecto buscarProyectoPorId(Long id){
			return repositorioProyecto.findOne(id);
	}
	
	
}

