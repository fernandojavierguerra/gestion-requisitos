package com.durgam.guerra.repositorio;

import static org.junit.Assert.*;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.durgam.guerra.dominio.Proyecto;


@RunWith(SpringRunner.class)
@SpringBootTest

public class RepositorioProyectoTest {
	
	private RepositorioProyecto repositorioProyecto;

	@Autowired
	public void setRepositorioProyecto(RepositorioProyecto repositorioProyecto) {
		this.repositorioProyecto = repositorioProyecto;
	}
	
	@Test
	public void testGrabarProyecto(){
		Proyecto proyecto = new Proyecto();
		proyecto.setDescripcionProyecto("Test Proyecto");
		proyecto.setNombreProyecto("Testing");
		
		//grabar proyecto, verificar id no nulo
		assertNull(proyecto.getId());
		repositorioProyecto.save(proyecto);
		assertNotNull(proyecto.getId());
		
		//recuperar de la BBDD
		Proyecto proyectoRegistrado = repositorioProyecto.findOne(proyecto.getId());
		
		//No deberia ser nulo
		assertNotNull(proyectoRegistrado);
		
		//Deberian ser iguales
		assertEquals(proyecto.getId(), proyectoRegistrado.getId());
		assertEquals(proyecto.getDescripcionProyecto(), proyectoRegistrado.getDescripcionProyecto());
		
		//Actualizar Descripcion y grabar
		proyectoRegistrado.setDescripcionProyecto("Nueva Descipcion Test");
		repositorioProyecto.saveAndFlush(proyectoRegistrado);
		
		//recuperar de la BBDD, deberia estar acutalizado
		Proyecto proyectoRegistradoActualizado = repositorioProyecto.findOne(proyectoRegistrado.getId());
		assertEquals(proyectoRegistrado.getDescripcionProyecto(), proyectoRegistradoActualizado.getDescripcionProyecto());
		
		
	}
	

/*
    @Test
    public void testSaveProduct(){
        //setup product
        Product product = new Product();
        product.setDescription("Spring Framework Guru Shirt");
        product.setPrice(new BigDecimal("18.95"));
        product.setProductId("1234");

        //save product, verify has ID value after save
        assertNull(product.getId()); //null before save
        productRepository.save(product);
        assertNotNull(product.getId()); //not null after save
        //fetch from DB
        Product fetchedProduct = productRepository.findOne(product.getId());

        //should not be null
        assertNotNull(fetchedProduct);

        //should equal
        assertEquals(product.getId(), fetchedProduct.getId());
        assertEquals(product.getDescription(), fetchedProduct.getDescription());

        //update description and save
        fetchedProduct.setDescription("New Description");
        productRepository.save(fetchedProduct);

        //get from DB, should be updated
        Product fetchedUpdatedProduct = productRepository.findOne(fetchedProduct.getId());
        assertEquals(fetchedProduct.getDescription(), fetchedUpdatedProduct.getDescription());

        //verify count of products in DB
        long productCount = productRepository.count();
        assertEquals(productCount, 1);

        //get all products, list should only have one
        Iterable<Product> products = productRepository.findAll();

        int count = 0;

        for(Product p : products){
            count++;
        }

        assertEquals(count, 1);
    }

	
*/
	

}
