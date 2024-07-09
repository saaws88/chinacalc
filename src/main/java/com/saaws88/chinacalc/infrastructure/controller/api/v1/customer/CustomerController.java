package com.saaws88.chinacalc.infrastructure.controller.api.v1.customer;

import org.springframework.http.ResponseEntity;

import java.util.List;

import org.springframework.http.MediaType;

import com.saaws88.chinacalc.domain.model.customer.Customer;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.parameters.RequestBody;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;

@Tag(name = "Клиенты")
public interface CustomerController {

  @Operation
      (summary = "Создание клиента",
          method = "POST",
          requestBody = @RequestBody(
              required = true,
              content = {@Content(mediaType = MediaType.APPLICATION_JSON_VALUE)}
          )
      )
  @ApiResponse(responseCode = "201", description = "Клиент создан")
  ResponseEntity<Customer> createCustomer(@Valid Customer customer);

  @Operation
      (summary = "Получение списка клиентов",
          method = "GET")
  List<Customer> listAll();

  @Operation
      (summary = "Удаление клиента по ID",
          method = "DELETE",
          parameters = {@Parameter(name = "id", required = true, description = "Id клиента")}
      )
  @ApiResponse(responseCode = "200", description = "Клиент удален")
  ResponseEntity<String> deleteCustomerById(Long id);


}

