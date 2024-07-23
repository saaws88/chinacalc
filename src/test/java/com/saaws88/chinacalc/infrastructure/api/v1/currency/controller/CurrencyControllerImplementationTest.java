package com.saaws88.chinacalc.infrastructure.api.v1.currency.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.saaws88.chinacalc.domain.model.CurrencyEntity;
import com.saaws88.chinacalc.infrastructure.api.v1.currency.CurrencyDto;
import com.saaws88.chinacalc.service.CurrencyService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.Mockito.when;

@SpringBootTest
@AutoConfigureMockMvc
class CurrencyControllerImplementationTest {

  @Autowired
  private MockMvc mockMvc;

  @Mock
  private CurrencyService service;

  @BeforeEach
  void setUp() {

    MockitoAnnotations.openMocks(this);

  }

  @Test
  void testAddCurrency() throws Exception {
    CurrencyDto dto = new CurrencyDto();
    dto.setCode("USD");
    dto.setRate(12.01);
    ObjectMapper objectMapper = new ObjectMapper();
    String jsonBody = objectMapper.writeValueAsString(dto);

    mockMvc.perform(MockMvcRequestBuilders.post("/api/v1/currency/add")
            .contentType(MediaType.APPLICATION_JSON)
            .content(jsonBody))
        .andExpect(MockMvcResultMatchers.status().isCreated());
  }

  @Test
  void testGetAll() throws Exception {
    List<CurrencyEntity> currencyList = new ArrayList<>();
    when(service.findAll()).thenReturn(currencyList);

    mockMvc.perform(MockMvcRequestBuilders.get("/api/v1/currency/all"))
        .andExpect(MockMvcResultMatchers.status().isOk());
  }
}
