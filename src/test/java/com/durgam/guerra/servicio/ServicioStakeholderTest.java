package com.durgam.guerra.servicio;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.durgam.guerra.dominio.Stakeholder;
import com.durgam.guerra.repositorio.RepositorioStakeholder;

@RunWith(SpringRunner.class)
@SpringBootTest

public class ServicioStakeholderTest {
	
	
	
	private ServicioStakeholder servicioStakeholder;
	
	@Autowired
	public void setServicioStakeholder(ServicioStakeholder servicioStakeholder) {
		this.servicioStakeholder = servicioStakeholder;
	}
	
	@Test
	public void testTransaccionStakeholder(){

		Stakeholder stake1= new Stakeholder((long) 10, "22111333","Juan","Programador", "Programador Junior");
		servicioStakeholder.NuevoStakeholder(stake1);
		
		System.out.println(stake1.toString());
		Stakeholder stake2 = servicioStakeholder.buscarStakeholderPorId(stake1.getId());
		System.out.println(stake2.toString());
        try {
        	servicioStakeholder.NuevoStakeholder(stake1);
        } catch (RuntimeException e) {
        	System.out.println("Esta excepcion es esperada porque ya existe stake1");
        }
				
        for (Stakeholder interesado : servicioStakeholder.obtenerTodosLosStakeholder()) {
           // logger.info("So far, " + interesado.toString() + " is booked.");
        	System.out.println(interesado.toString());
        }
		
		/*
		 * 
		 * public void run(String... args) throws Exception {
        bookingService.book("Alice", "Bob", "Carol");
        Assert.isTrue(bookingService.findAllBookings().size() == 3,
                "First booking should work with no problem");
        logger.info("Alice, Bob and Carol have been booked");
        try {
            bookingService.book("Chris", "Samuel");
        } catch (RuntimeException e) {
            logger.info("v--- The following exception is expect because 'Samuel' is too " +
                    "big for the DB ---v");
            logger.error(e.getMessage());
        }

        for (String person : bookingService.findAllBookings()) {
            logger.info("So far, " + person + " is booked.");
        }
        logger.info("You shouldn't see Chris or Samuel. Samuel violated DB constraints, " +
                "and Chris was rolled back in the same TX");
        Assert.isTrue(bookingService.findAllBookings().size() == 3,
                "'Samuel' should have triggered a rollback");

        try {
            bookingService.book("Buddy", null);
        } catch (RuntimeException e) {
            logger.info("v--- The following exception is expect because null is not " +
                    "valid for the DB ---v");
            logger.error(e.getMessage());
        }

        for (String person : bookingService.findAllBookings()) {
            logger.info("So far, " + person + " is booked.");
        }
        logger.info("You shouldn't see Buddy or null. null violated DB constraints, and " +
                "Buddy was rolled back in the same TX");
        Assert.isTrue(bookingService.findAllBookings().size() == 3,
                "'null' should have triggered a rollback");
    }
		 */
		
	}

}
