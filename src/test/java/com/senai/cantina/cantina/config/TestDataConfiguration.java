package com.senai.cantina.cantina.config;

import javax.sql.DataSource;

import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Primary;
import org.springframework.boot.test.context.TestConfiguration;

@TestConfiguration
public class TestDataConfiguration {

    @Bean
    @Primary
    public DataSource dataSource() {
        return DataSourceBuilder.create()
                .driverClassName("org.h2.Driver")
                .url("jdbc:h2:mem:testdb;DB_CLOSE_DELAY=-1")
                .username("sa")
                .password("")
                .build();
    }
}
