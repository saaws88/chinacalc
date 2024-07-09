package com.saaws88.chinacalc.infrastructure.controller.api.v1.email;


import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
public class EmailControllerImplementationTest {

  @Autowired
  MockMvc mockMvc;

  @Test
  void sendEmail_sendsTemporaryPassword() throws Exception{

    String to = "test@email.com";

    mockMvc.perform(post("/api/v1/test-email/send").param("to", to)).andExpect(status().isOk());

  }


}
