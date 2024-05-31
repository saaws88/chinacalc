package com.saaws88.chinacalc.infrastructure.repo;

import com.saaws88.chinacalc.testconfig.annotation.IntegrationTest;
import com.saaws88.chinacalc.testconfig.integrationtest.JpaRepositoryIntegrationTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.jdbc.Sql;

import static org.junit.jupiter.api.Assertions.assertEquals;

@IntegrationTest
@Sql("/customerrepo_it.sql")
public class CustomerRepositoryIT extends JpaRepositoryIntegrationTest {

  @Autowired
  CustomerRepository repo;

  @Test
  @DisplayName("Создает 2 инстанса клиента")
  public void create_saves_createsTwoCustomers () {

    assertEquals(2, repo.findAll().size());
    System.out.println(repo.findAll().get(0).getId());

  }

  @Test
  @DisplayName("Поиск по id 1 находит сущность с id 1")
  public void findById_idOne_asExpected() {

    assertEquals(1, repo.findById(1L).get().getId());

  }

}
