package com.durgam.guerra.repositorio;

import org.springframework.data.jpa.repository.JpaRepository;

import com.durgam.guerra.dominio.Requisito;
import com.durgam.guerra.dominio.RequisitoCompuesto;

public interface RepositorioRequisitoCompuesto extends JpaRepository<RequisitoCompuesto, Long>  {

}
