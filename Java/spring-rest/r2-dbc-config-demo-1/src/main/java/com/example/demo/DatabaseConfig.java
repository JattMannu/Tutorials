package com.example.demo;

import io.r2dbc.pool.ConnectionPool;
import io.r2dbc.pool.ConnectionPoolConfiguration;
import io.r2dbc.spi.ConnectionFactories;
import io.r2dbc.spi.ConnectionFactory;
import io.r2dbc.spi.ConnectionFactoryOptions;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.sql.DataSource;


import java.time.Duration;

import static io.r2dbc.pool.PoolingConnectionFactoryProvider.MAX_SIZE;
import static io.r2dbc.pool.PoolingConnectionFactoryProvider.VALIDATION_QUERY;
import static io.r2dbc.spi.ConnectionFactoryOptions.*;

@Configuration
//@EnableR2dbcRepositories
@EnableTransactionManagement
public class DatabaseConfig {

    @Bean
    public ConnectionFactory connectionFactory() {
        ConnectionFactory connectionFactory = ConnectionFactories.get
                (ConnectionFactoryOptions.builder()
                        .option(DRIVER, "pool")
                        .option(PROTOCOL, "postgresql")
                        .option(HOST, "localhost")
                        .option(PORT, 5432)
                        .option(USER, "admin")
                        .option(PASSWORD, "admin")
                        .option(DATABASE, "demo")
                        .option(MAX_SIZE, 3)
                        .option(VALIDATION_QUERY, "SELECT 1")
                        .build());

        ConnectionPoolConfiguration configuration = ConnectionPoolConfiguration.builder(connectionFactory)
                .maxIdleTime(Duration.ofMinutes(30))
                .initialSize(1)
                .maxSize(3)
                .maxCreateConnectionTime(Duration.ofSeconds(5))
                .validationQuery("SELECT 1")
                .build();
        return new ConnectionPool(configuration);
    }


    //https://www.baeldung.com/spring-boot-failed-to-configure-data-source
    @Bean
    public DataSource datasource() {
        return DataSourceBuilder.create()
                .driverClassName("org.postgresql.Driver")
                .url("jdbc:postgresql://localhost:5432/demo")
                .username("admin")
                .password("admin")
                .build();
    }
}
