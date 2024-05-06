package org.example.prices.infrastructure.configuration;

import jakarta.persistence.EntityManagerFactory;
import org.springframework.beans.factory.FactoryBean;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.PlatformTransactionManager;

import javax.sql.DataSource;

@Configuration
@EnableJpaRepositories(
        basePackages = "org.example.prices.infrastructure.persistence",
        entityManagerFactoryRef = "entityManagerFactoryBean",
        transactionManagerRef = "transactionManager"
)
public class PersistenceH2Config {

    @Bean
    public FactoryBean<EntityManagerFactory> entityManagerFactoryBean() {
        final var em = new LocalContainerEntityManagerFactoryBean();
        em.setDataSource(dataSource());
        em.setPackagesToScan(
                "org.example.prices.infrastructure.persistence.entity");
        final var vendorAdapter = new HibernateJpaVendorAdapter();
        em.setJpaVendorAdapter(vendorAdapter);
        return em;
    }

    @Bean
    public DataSource dataSource() {
        return DataSourceBuilder.create()
            .driverClassName("org.h2.Driver")
            .url("jdbc:h2:mem:test")
            .username("user")
            .password("")
            .build();
    }

    @Bean
    public PlatformTransactionManager transactionManager() throws Exception {
        final var transactionManager = new JpaTransactionManager();
        transactionManager.setEntityManagerFactory(
                entityManagerFactoryBean().getObject());
        return transactionManager;
    }
}
