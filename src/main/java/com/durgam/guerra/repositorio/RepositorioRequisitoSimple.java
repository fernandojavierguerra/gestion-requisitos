package com.durgam.guerra.repositorio;

import org.springframework.data.jpa.repository.JpaRepository;

import com.durgam.guerra.dominio.RequisitoCompuesto;
import com.durgam.guerra.dominio.RequisitoSimple;

public interface RepositorioRequisitoSimple extends JpaRepository<RequisitoSimple, Long>{

}
