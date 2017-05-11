package com.durgam.guerra.repositorio;
import org.springframework.data.jpa.repository.JpaRepository;
import com.durgam.guerra.dominio.EstadoRequisito;
public interface RepositorioEstado extends JpaRepository<EstadoRequisito, Long> {

}
