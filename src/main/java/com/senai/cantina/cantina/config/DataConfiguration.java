package com.senai.cantina.cantina.config;

import javax.sql.DataSource;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.jpa.JpaVendorAdapter;
import org.springframework.orm.jpa.vendor.Database;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;

@Configuration
public class DataConfiguration {

    private static final String URL = System.getenv().getOrDefault(
            "DB_URL",
            "jdbc:mysql://localhost:3306/cantina"
                    + "?createDatabaseIfNotExist=true"
                    + "&useSSL=false"
                    + "&serverTimezone=America/Sao_Paulo"
    );

    private static final String USUARIO = System.getenv().getOrDefault(
            "DB_USERNAME",
            "root"
    );

    private static final String SENHA = System.getenv("DB_PASSWORD");

    @Bean
    public DataSource dataSource() {
        DriverManagerDataSource dataSource =
                new DriverManagerDataSource();

        dataSource.setDriverClassName(
                "com.mysql.cj.jdbc.Driver"
        );

        dataSource.setUrl(URL);
        dataSource.setUsername(USUARIO);
        dataSource.setPassword(SENHA);

        return dataSource;
    }

    @Bean
    public JpaVendorAdapter jpaVendorAdapter() {
        HibernateJpaVendorAdapter adapter =
                new HibernateJpaVendorAdapter();

        adapter.setDatabase(Database.MYSQL);
        adapter.setShowSql(true);
        adapter.setGenerateDdl(true);

        adapter.setDatabasePlatform(
                "org.hibernate.dialect.MySQLDialect"
        );

        adapter.setPrepareConnection(true);

        return adapter;
    }
}