package tr.edu.ogu.ceng.product;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.testcontainers.containers.PostgreSQLContainer;
import org.testcontainers.containers.GenericContainer;
import org.testcontainers.utility.DockerImageName;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class DatabaseTest {

    // PostgreSQL konteyneri
    @SuppressWarnings("resource")
	static PostgreSQLContainer<?> postgresContainer =
            new PostgreSQLContainer<>(DockerImageName.parse("postgres:14"))
                    .withDatabaseName("ilerijava")
                    .withUsername("devuser")
                    .withPassword("devpassword");

    // Redis konteyneri
    @SuppressWarnings("resource")
	static GenericContainer<?> redisContainer =
            new GenericContainer<>(DockerImageName.parse("redis:6"))
                    .withExposedPorts(6379);

    static {
        postgresContainer.start();  // PostgreSQL konteynerini başlat
        redisContainer.start();      // Redis konteynerini başlat
    }

    @Test
    void contextLoads() {
        // Testlerinizi burada çalıştırabilirsiniz
        System.out.println("PostgreSQL container is running at: " + postgresContainer.getJdbcUrl());
        System.out.println("Redis container is running at: " + redisContainer.getHost() + ":" + redisContainer.getMappedPort(6379));
    }
    
    @AfterAll
    static void tearDown() {
        postgresContainer.stop();  // PostgreSQL konteynerini durdur
        redisContainer.stop();      // Redis konteynerini durdur
    }
}
