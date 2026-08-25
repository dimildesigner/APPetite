package com.senai.cantina.cantina.config;

import javax.sql.DataSource;

import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.orm.jpa.JpaVendorAdapter;
import org.springframework.orm.jpa.vendor.Database;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;

@Configuration
@Profile("!test")
public class DataConfiguration {

    private static final String URL =
            "jdbc:mysql://localhost:3306/cantina"
                    + "?createDatabaseIfNotExist=true"
                    + "&useSSL=false"
                    + "&serverTimezone=America/Sao_Paulo";

    private static final String USUARIO = "root";

    @Bean
    public DataSource dataSource() {
        String senha = System.getenv("DB_PASSWORD");

        if (senha == null || senha.isBlank()) {
            throw new IllegalStateException(
                    "A variável de ambiente DB_PASSWORD não foi definida. "
                            + "Configure-a antes de iniciar a aplicação "
                            + "(nunca deixe a senha real escrita no código-fonte)."
            );
        }

        return DataSourceBuilder.create()
                .driverClassName("com.mysql.cj.jdbc.Driver")
                .url(URL)
                .username(USUARIO)
                .password(senha)
                .build();
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
