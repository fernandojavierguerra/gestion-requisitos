package com.durgam.guerra.repositorio;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.data.jpa.repository.JpaRepository;
import com.durgam.guerra.dominio.Proyecto;
public interface RepositorioProyecto extends JpaRepository<Proyecto, Long> {
	

}
