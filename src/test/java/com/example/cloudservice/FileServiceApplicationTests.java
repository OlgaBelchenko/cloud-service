package com.example.cloudservice;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.util.TestPropertyValues;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.context.ApplicationContextInitializer;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.testcontainers.containers.GenericContainer;
import org.testcontainers.containers.Network;
import org.testcontainers.containers.PostgreSQLContainer;
import org.testcontainers.junit.jupiter.Container;
import org.testcontainers.junit.jupiter.Testcontainers;

import static org.junit.jupiter.api.Assertions.assertTrue;

@Testcontainers
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@ContextConfiguration(initializers = {FileServiceApplicationTests.Initializer.class})
@AutoConfigureMockMvc(addFilters = false)
class FileServiceApplicationTests {

    private static final int DB_PORT = 5432;
    private static final String DB_NAME = "cloud_db";
    private static final String DB_USERNAME = "postgres";
    private static final String DB_PASSWORD = "postgres";
    private final static Network NETWORK = Network.newNetwork();
//    private final static int BACKEND_PORT = 8080;

    @Autowired
    TestRestTemplate restTemplate;

    @Container
    static final PostgreSQLContainer<?> DB_CONTAINER = new PostgreSQLContainer<>("postgres")
            .withReuse(true)
            .withExposedPorts(DB_PORT)
            .withDatabaseName(DB_NAME)
            .withUsername(DB_USERNAME)
            .withPassword(DB_PASSWORD)
            .withNetwork(NETWORK);

    @Test
    void testPostgresLoads() {
        assertTrue(DB_CONTAINER.isRunning());
    }

    static class Initializer implements ApplicationContextInitializer<ConfigurableApplicationContext> {
        public void initialize(ConfigurableApplicationContext configurableApplicationContext) {
            TestPropertyValues.of(
                    "spring.datasource.username=" + DB_CONTAINER.getUsername(),
                    "spring.datasource.password=" + DB_CONTAINER.getPassword(),
                    "spring.datasource.url=" + DB_CONTAINER.getJdbcUrl()
            ).applyTo(configurableApplicationContext.getEnvironment());
        }
    }
}
