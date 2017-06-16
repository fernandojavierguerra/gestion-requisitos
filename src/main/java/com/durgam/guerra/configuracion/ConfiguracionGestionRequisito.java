package com.durgam.guerra.configuracion;

import javax.persistence.EntityManagerFactory;

import org.apache.tomcat.jdbc.pool.DataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.jdbc.DataSourceBuilder;
import org.springframework.boot.autoconfigure.orm.jpa.JpaProperties;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.orm.jpa.EntityManagerFactoryBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.JpaVendorAdapter;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.persistenceunit.PersistenceUnitManager;
import org.springframework.orm.jpa.vendor.AbstractJpaVendorAdapter;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;

import com.durgam.guerra.dominio.GestionRequisito;

//import demo.customer.domain.Customer;

//@Configuration
//@EnableJpaRepositories(
//		entityManagerFactoryRef = "gestionRequisitoEntityManager",
//		transactionManagerRef = "gestionRequisitoTransactionManager",
//		basePackageClasses = GestionRequisito.class)
public class ConfiguracionGestionRequisito {
	
//	@Autowired(required = false)
//	private PersistenceUnitManager persistenceUnitManager;
//
//	@Bean
//	@ConfigurationProperties("app.jpa")
//	public JpaProperties gestionRequisitoJpaProperties() {
//		return new JpaProperties();
//	}
//
//	@Bean
//	@Primary
//	@ConfigurationProperties(prefix = "app.datasource")
//	public DataSource gestionRequisitoDataSource() {
//		return (DataSource) DataSourceBuilder.create().type(DataSource.class).build();
//	}
//
//	@Bean
//	public LocalContainerEntityManagerFactoryBean gestionRequisitoEntityManager(
//			JpaProperties gestionRequisitoJpaProperties) {
//		EntityManagerFactoryBuilder builder = createEntityManagerFactoryBuilder(gestionRequisitoJpaProperties);
//		return builder
//				.dataSource(gestionRequisitoDataSource())
//				.packages(GestionRequisito.class)
//				.persistenceUnit("gestionRequisitoPersistencia")
//				.build();
//	}
//
//	@Bean
//	@Primary
//	public JpaTransactionManager gestionRequisitoTransactionManager(EntityManagerFactory gestionRequisitoEntityManager) {
//		return new JpaTransactionManager(gestionRequisitoEntityManager);
//	}
//
//	private EntityManagerFactoryBuilder createEntityManagerFactoryBuilder(JpaProperties gestionRequisitoJpaProperties) {
//		JpaVendorAdapter jpaVendorAdapter = createJpaVendorAdapter(gestionRequisitoJpaProperties);
//		return new EntityManagerFactoryBuilder(jpaVendorAdapter,
//				gestionRequisitoJpaProperties.getProperties(), this.persistenceUnitManager);
//	}
//
//	private JpaVendorAdapter createJpaVendorAdapter(JpaProperties jpaProperties) {
//		AbstractJpaVendorAdapter adapter = new HibernateJpaVendorAdapter();
//		adapter.setShowSql(jpaProperties.isShowSql());
//		adapter.setDatabase(jpaProperties.getDatabase());
//		adapter.setDatabasePlatform(jpaProperties.getDatabasePlatform());
//		adapter.setGenerateDdl(jpaProperties.isGenerateDdl());
//		return adapter;
//	}

}
