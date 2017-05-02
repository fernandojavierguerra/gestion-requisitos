package com.durgam.guerra;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.durgam.guerra.dominio.RequisitoCerrado;

@SpringBootApplication
public class GestionRequisitosApplication {

	public static void main(String[] args) {
		SpringApplication.run(GestionRequisitosApplication.class, args);
	
		System.out.println("hola");
		RequisitoCerrado cerrado = RequisitoCerrado.getEstado();
		System.out.println(cerrado.getId() + cerrado.getDescripcionEstado());
		RequisitoCerrado cerrado1 = RequisitoCerrado.getEstado();
		System.out.println(cerrado1.getId() + cerrado1.getDescripcionEstado());
	System.out.println(cerrado.siguiente());
	}
}
