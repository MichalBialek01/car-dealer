//package pl.bialek.configuration;
//
//import com.zaxxer.hikari.HikariDataSource;
//import org.springframework.beans.factory.annotation.Qualifier;
//import org.springframework.boot.jdbc.DataSourceBuilder;
//import org.springframework.boot.test.context.TestConfiguration;
//import org.springframework.context.annotation.Bean;
//import org.testcontainers.containers.PostgreSQLContainer;
//
//import javax.sql.DataSource;
//
//@TestConfiguration
//public class PersistenceContainerTestConfiguration {
//    public static final String USERNAME = "test";
//    public static final String PASSWORD = "test";
//    public static final String POSTGRESQL = "postgresql";
//    public static final String POSTGRESQL_CONTAINER = "postgres:16.0";
//
//    //    Naming bean -> Qualifier
//    @Bean
//    @Qualifier(POSTGRESQL)
//    PostgreSQLContainer<?> postgresqlContainer() {
//        PostgreSQLContainer<?> postgresqlContainer = new PostgreSQLContainer<>(POSTGRESQL_CONTAINER)
//                .withUsername(USERNAME)
//                .withPassword(PASSWORD);
//        postgresqlContainer.start();
//        return postgresqlContainer;
//    }
//
//    @Bean
//    DataSource dataSource(final PostgreSQLContainer<?> postgresqlContainer) {
//        return DataSourceBuilder.create()
//                .type(HikariDataSource.class)
//                .driverClassName(postgresqlContainer.getDriverClassName())
//                .url(postgresqlContainer.getJdbcUrl())
//                .username(postgresqlContainer.getUsername())
//                .password(postgresqlContainer.getPassword())
//                .build();
//    }
//
//}
