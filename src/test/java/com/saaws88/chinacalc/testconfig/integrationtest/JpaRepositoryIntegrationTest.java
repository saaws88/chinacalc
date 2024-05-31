package com.saaws88.chinacalc.testconfig.integrationtest;

import org.springframework.test.context.DynamicPropertyRegistry;
import org.springframework.test.context.DynamicPropertySource;
import org.testcontainers.containers.PostgreSQLContainer;
import org.testcontainers.junit.jupiter.Container;

public class JpaRepositoryIntegrationTest {

  @Container
  static PostgreSQLContainer<?> testPGDB = new PostgreSQLContainer<>("postgres:14-alpine");

  @DynamicPropertySource
  static void configureProperties(DynamicPropertyRegistry registry) {
    registry.add("spring.datasource.url", testPGDB::getJdbcUrl);
    registry.add("spring.datasource.username", testPGDB::getUsername);
    registry.add("spring.datasource.password", testPGDB::getPassword);
  }

}