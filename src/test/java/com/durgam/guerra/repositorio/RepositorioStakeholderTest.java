package com.durgam.guerra.repositorio;

import static org.junit.Assert.*;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.durgam.guerra.dominio.Stakeholder;

@RunWith(SpringRunner.class)
@SpringBootTest

public class RepositorioStakeholderTest {
	
	private RepositorioStakeholder repositorioStakeholder;

	@Autowired
	public void setRepositorioStakeholder(RepositorioStakeholder repositorioStakeholder) {
		this.repositorioStakeholder = repositorioStakeholder;
	}
	
	@Test
	public void testGrabarStakeholder(){
		Stakeholder stakeholder = new Stakeholder();
		stakeholder.setNombre("Interesado Nombre");
		stakeholder.setApellido("Interesado Apellido");
		
		//grabar y verificar id no nulo
		assertNull(stakeholder.getId());
		repositorioStakeholder.save(stakeholder);
		assertNotNull(stakeholder.getId());
		
		//recuperar de la BBDD
		Stakeholder stakeholderRegistrado = repositorioStakeholder.findOne(stakeholder.getId());
		
		//No deberia ser nulo
		assertNotNull(stakeholderRegistrado);
		
		//Deberian ser iguales
		assertEquals(stakeholder.getId(), stakeholderRegistrado.getId());
		assertEquals(stakeholder.getApellido(), stakeholderRegistrado.getApellido());
		
		//Actualizar Descripcion y grabar
		stakeholderRegistrado.setApellido("Otro Apellido Test");
		repositorioStakeholder.saveAndFlush(stakeholderRegistrado);
		
		//recuperar de la BBDD, deberia estar acutalizado
		Stakeholder stakeholderRegistradoActualizado = repositorioStakeholder.findOne(stakeholderRegistrado.getId());
		assertEquals(stakeholderRegistrado.getApellido(), stakeholderRegistradoActualizado.getApellido());
		
		
		
	}
	

}
