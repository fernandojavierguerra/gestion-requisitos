package com.durgam.guerra;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.durgam.guerra.dominio.GestionRequisito;

@SpringBootApplication
public class GestionRequisitosApplication {

	public static void main(String[] args) {
		SpringApplication.run(GestionRequisitosApplication.class, args);
	
		GestionRequisito app= GestionRequisito.getSistema();
		System.out.println("Creando Objeto Aplicación en la Base de Datos");
	}
}
