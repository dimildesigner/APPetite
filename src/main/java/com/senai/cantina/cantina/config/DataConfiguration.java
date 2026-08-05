package com.senai.cantina.cantina.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.jpa.JpaVendorAdapter;
import org.springframework.orm.jpa.vendor.Database;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;

import javax.sql.DataSource;
import java.sql.*;

@Configuration
public class DataConfiguration {

    private static final String URL =
            "jdbc:mysql://localhost:3306/cantina"
                    + "?createDatabaseIfNotExist=true&useSSL=false&serverTimezone=America/Sao_Paulo";


    private static final String USUARIO = "root";
    private static final String SENHA =
            System.getenv().getOrDefault("DB_PASSWORD", "senai@126");

    @Bean
    public DataSource dataSource() {
        DriverManagerDataSource dataSource = new DriverManagerDataSource();
        dataSource.setDriverClassName("com.mysql.cj.jdbc.Driver");
        dataSource.setUrl(URL);
        dataSource.setUsername(USUARIO);
        dataSource.setPassword(SENHA);
        return dataSource;
    }

    @Bean
    public JpaVendorAdapter jpaVendorAdapter() {
        HibernateJpaVendorAdapter adapter = new HibernateJpaVendorAdapter();
        adapter.setDatabase(Database.MYSQL);
        adapter.setShowSql(true);
        boolean bancoJaCriado = bancoJaCriado();
        adapter.setGenerateDdl(!bancoJaCriado);

        if (bancoJaCriado) {
            System.out.println("[DataConfiguration] Banco já existe -> " + "as tabelas não serão criadas");
        } else {
            System.out.println("[DataConfiguration] Primeira execução ->" + "Criando as tabelas do banco");
        }

        adapter.setDatabasePlatform("org.hibernate.dialect,MySQLDialect");
        adapter.setPrepareConnection(true);
        return adapter;
    }

    public boolean bancoJaCriado() {
        String[] tabelasEsperadas = {"categoria", "comentario", "compra", "contato", "estoque", "formapagamento",
                                    "fornecedor", "funcionario", "itemcompra", "itempedido", "login",
                                    "observacaopedido", "pedido", "produto", "reserva", "usuario", "vendapagamento"};
        try (Connection conexao = DriverManager.getConnection(URL, USUARIO, SENHA)) {
            DatabaseMetaData metadados = conexao.getMetaData();
            for (String tabela : tabelasEsperadas) {
                try (ResultSet rs = metadados.getTables(conexao.getCatalog(), null, tabela, new String[]{"TABLE"})) {
                    if (!rs.next()) {
                        return false;
                    }
                }
            }
            return false;
        } catch (SQLException e) {
            System.out.println("[DataConfiguration] Não foi possivel verificar o"
                    + "banco de dados: " + e.getMessage());
            return false;
        }
    }
}


