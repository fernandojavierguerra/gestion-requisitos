package com.durgam.guerra;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.orm.ObjectOptimisticLockingFailureException;
import org.springframework.test.context.junit4.SpringRunner;

import com.durgam.guerra.dominio.Proyecto;
import com.durgam.guerra.servicio.ServicioProyecto;

@RunWith(SpringRunner.class)
@SpringBootTest
public class GestionRequisitosApplicationTests {

	private ServicioProyecto servicioProyecto;

	@Autowired
	public void setRepositorioProyecto(ServicioProyecto servicioProyecto) {
		this.servicioProyecto = servicioProyecto;
	}

	@Test
	public void contextLoads() {
	}

	@Test(expected = ObjectOptimisticLockingFailureException.class)
	public void bloqueoOptimista() {

		Proyecto proyecto = servicioProyecto.buscarProyectoPorId((long)1);
		proyecto.setNombreProyecto("Actualizado");
		System.out.println("Proyecto: " + proyecto.toString());
		servicioProyecto.grabarProyecto(proyecto);
		//excepcion
		System.out.println("Proyecto: " + proyecto.toString());
		servicioProyecto.grabarProyecto(proyecto);
		
	}

}
