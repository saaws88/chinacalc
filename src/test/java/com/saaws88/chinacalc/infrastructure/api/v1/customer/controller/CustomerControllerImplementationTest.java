package com.saaws88.chinacalc.infrastructure.api.v1.customer.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.saaws88.chinacalc.domain.model.customer.Customer;
import com.saaws88.chinacalc.domain.model.customer.enumerated.CustomerCategory;
import com.saaws88.chinacalc.service.CustomerService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import java.util.ArrayList;

import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.when;

@SpringBootTest
@AutoConfigureMockMvc
class CustomerControllerImplementationTest {

  @Autowired
  private MockMvc mockMvc;

  @MockBean
  private CustomerService service;

  @BeforeEach
  void setUp() {
    MockitoAnnotations.openMocks(this);
  }

  @Test
  void testCreateCustomer() throws Exception {

    Customer customer = Customer.builder()
        .privatePerson(false)
        .customerName("ООО ООО")
        .contactLastName("Брыба")
        .contactFirstName("Николай")
        .contactPatronymic("Николаевич")
        .city("Новосибирск")
        .email("v.zibnitsky@nekot.site")
        .phoneNumber("+79130692199")
        .category(CustomerCategory.INITIAL)
        .taxpayerIdentificationNumber("007")
        .build();

    ObjectMapper objectMapper = new ObjectMapper();
    String jsonBody = objectMapper.writeValueAsString(customer);

    mockMvc.perform(MockMvcRequestBuilders.post("/api/v1/customer/add")
            .contentType(MediaType.APPLICATION_JSON)
            .content(jsonBody))
        .andExpect(MockMvcResultMatchers.status().isCreated());
  }

  @Test
  void testListAllCustomers() throws Exception {
    when(service.findAll()).thenReturn(new ArrayList<>());

    mockMvc.perform(MockMvcRequestBuilders.get("/api/v1/customer/all"))
        .andExpect(MockMvcResultMatchers.status().isOk());
  }

  @Test
  void testDeleteCustomerById() throws Exception {

    Long customerId = 1L;

    Customer customer = Customer.builder()
        .id(customerId)
        .privatePerson(false)
        .customerName("ООО ООО")
        .contactLastName("Брыба")
        .contactFirstName("Николай")
        .contactPatronymic("Николаевич")
        .city("Новосибирск")
        .email("v.zibnitsky@nekot.site")
        .phoneNumber("+79130692199")
        .category(CustomerCategory.INITIAL)
        .taxpayerIdentificationNumber("007")
        .build();

    when(service.getCustomerById(eq(customerId))).thenReturn(customer);

    mockMvc.perform(MockMvcRequestBuilders.delete("/api/v1/customer/delete/{id}", customerId))
        .andExpect(MockMvcResultMatchers.status().isOk());
  }

}
