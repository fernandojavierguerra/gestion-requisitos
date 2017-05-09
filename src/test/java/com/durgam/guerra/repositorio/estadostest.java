package com.durgam.guerra.repositorio;

import static org.junit.Assert.*;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.durgam.guerra.dominio.GestionRequisito;
import com.durgam.guerra.dominio.Proyecto;
import com.durgam.guerra.dominio.RequisitoSimple;
@RunWith(SpringRunner.class)
@SpringBootTest
public class estadostest {
	@Autowired
	private RepositorioGestionRequisito repositorioapp;
	@Test
	public void test() {
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

}
