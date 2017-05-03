package com.durgam.repositorio.configuracion;

import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
@EnableAutoConfiguration
@EntityScan(basePackages = {"com.durgam.guerra.dominio"})
@EnableJpaRepositories(basePackages = {"com.durgam.guerra.repositorio"})
@EnableTransactionManagement
public class ConfiguracionRepositorio {

}
