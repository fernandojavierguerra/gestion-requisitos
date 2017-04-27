package com.durgam.guerra.repositorio;

import org.springframework.data.jpa.repository.JpaRepository;

import com.durgam.guerra.dominio.Stakeholder;


public interface RepositorioStakeholder extends JpaRepository<Stakeholder, Long> {

}
