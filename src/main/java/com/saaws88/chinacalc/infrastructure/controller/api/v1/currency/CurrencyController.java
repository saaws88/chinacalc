package com.saaws88.chinacalc.infrastructure.controller.api.v1.currency;


import com.saaws88.chinacalc.domain.model.CurrencyEntity;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.parameters.RequestBody;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;

import java.util.List;

@Tag(name = "Работа с валютами")
public interface CurrencyController {

  @ApiResponse(responseCode = "201", description = "Валюта создана")
  @Operation
      (summary = "Создание записи о курсе валюты",
          method = "POST",
          requestBody = @RequestBody(
              required = true,
              content = {@Content(mediaType = MediaType.APPLICATION_JSON_VALUE)}
          )
      )
  ResponseEntity<CurrencyEntity> addCurrency(@Valid CurrencyEntity currency);

  @ApiResponse(responseCode = "200", description = "OK")
  @Operation
      (summary = "Обновление курса валюты, либо изменение записи при отсутствии записи о валюте",
          method = "PUT",
          requestBody = @RequestBody(
              required = true,
              content = {@Content(mediaType = MediaType.APPLICATION_JSON_VALUE)}
          )
      )
  ResponseEntity<CurrencyEntity> updateRate(@Valid CurrencyEntity currency);



  @ApiResponse(responseCode = "200", description = "OK")
  @Operation(summary = "Получение всех записей о курсах валют")
  List<CurrencyEntity> getAll();

}
