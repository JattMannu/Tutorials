package com.book.config;

import io.r2dbc.postgresql.PostgresqlConnectionConfiguration;
import io.r2dbc.postgresql.PostgresqlConnectionFactory;
import io.r2dbc.postgresql.PostgresqlConnectionFactoryProvider;
import io.r2dbc.spi.ConnectionFactories;
import io.r2dbc.spi.ConnectionFactory;
import io.r2dbc.spi.ConnectionFactoryOptions;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.r2dbc.config.AbstractR2dbcConfiguration;
import org.springframework.data.r2dbc.repository.config.EnableR2dbcRepositories;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
@EnableR2dbcRepositories
@EnableTransactionManagement
public class DatabaseConfig   extends AbstractR2dbcConfiguration {

    @Bean
    public ConnectionFactory connectionFactory() {
        return ConnectionFactories.get(ConnectionFactoryOptions.builder()
                .option(ConnectionFactoryOptions.DRIVER, PostgresqlConnectionFactoryProvider.POSTGRESQL_DRIVER)
                .option(ConnectionFactoryOptions.DATABASE, "demo")
                .option(ConnectionFactoryOptions.HOST, "localhost")
                .option(ConnectionFactoryOptions.PORT, 5432)
                .option(ConnectionFactoryOptions.PASSWORD, "admin")
                .option(ConnectionFactoryOptions.USER, "admin")
                .build());
    }
//    @Bean
//    public ConnectionFactory connectionFactory() {
//      PostgresqlConnectionConfiguration config = PostgresqlConnectionConfiguration.builder() //
//              .host("localhost") //
//              .port(5432) //
//              .database("demo") //
//              .username("admin") //
//              .password("admin") //
//              .build();
//      return new PostgresqlConnectionFactory(config);
//  }

}
