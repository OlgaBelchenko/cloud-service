package com.example.cloudservice;

import com.example.cloudservice.dto.UserDto;
import jakarta.transaction.Transactional;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.util.TestPropertyValues;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.context.ApplicationContextInitializer;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.testcontainers.containers.PostgreSQLContainer;
import org.testcontainers.junit.jupiter.Container;
import org.testcontainers.junit.jupiter.Testcontainers;

import static com.example.cloudservice.testutils.TestUtils.*;

@Testcontainers
@AutoConfigureMockMvc(addFilters = false)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@ContextConfiguration(initializers = {FileServiceApplicationTests.Initializer.class})
@Transactional
class FileServiceApplicationTests {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    TestRestTemplate restTemplate;

    private static final String LOGIN_ENDPOINT = "/login";
    public static final String USERNAME = "test";
    public static final String PASSWORD = "test";
    //    public static final String PASSWORD = "test";
    @Container
    public static final PostgreSQLContainer<?> DB_CONTAINER = new PostgreSQLContainer<>("postgres")
            .withReuse(true)
            .withExposedPorts(DB_PORT)
            .withDatabaseName(DB_NAME)
            .withUsername(DB_USERNAME)
            .withPassword(DB_PASSWORD)
//            .withInitScript("db/init.sql")
            .withNetwork(NETWORK);

    @Test
    void testPostgresLoads() {
        Assertions.assertTrue(DB_CONTAINER.isRunning());
    }

// --- AuthController tests ---

    @Test
    @Rollback
    void login() {
        UserDto request = new UserDto(USERNAME, PASSWORD);
        ResponseEntity<?> response = restTemplate.exchange(
                LOGIN_ENDPOINT, HttpMethod.POST, new HttpEntity<>(request), String.class);
        System.out.println(response.getBody());
        Assertions.assertEquals(HttpStatus.OK, response.getStatusCode());
        assert (response.hasBody());
    }

//    @Test
//    void loginWithJson() {
//
//    }

    // --- FileController tests ---
    @Test
    void uploadFile() {
    }

    @Test
    void deleteFile() {
    }

    @Test
    void downloadFile() {
    }

    @Test
    void editFileName() {
    }

    @Test
    void getAllFiles() {
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
