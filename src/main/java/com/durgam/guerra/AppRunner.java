package com.durgam.guerra;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.durgam.guerra.dominio.GestionRequisito;
import com.durgam.guerra.servicio.ServicioGestionRequisito;



@Component
public class AppRunner implements CommandLineRunner {
    private final static Logger logger = LoggerFactory.getLogger(AppRunner.class);

    private final ServicioGestionRequisito servicioGestionRequisito;

    public AppRunner(ServicioGestionRequisito servicioGestionRequisito) {
        this.servicioGestionRequisito = servicioGestionRequisito;
    }
    
	@Override
	public void run(String... arg0) throws Exception {
	
		GestionRequisito app = (servicioGestionRequisito.buscarGestionRequisitoPorId((long) 1));
		System.out.println(app.getNombre());
		app.setNombre("App 2017");		
		servicioGestionRequisito.GrabarGestionRequisito(app);
		System.out.println(app.getNombre());
	}
}
