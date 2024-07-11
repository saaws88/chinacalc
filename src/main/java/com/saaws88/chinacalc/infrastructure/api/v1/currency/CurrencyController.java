package com.saaws88.chinacalc.infrastructure.api.v1.currency;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.parameters.RequestBody;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;

import java.util.List;

@Validated
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
  ResponseEntity<CurrencyDto> addCurrency(@Valid CurrencyDto dto);

  @ApiResponse(responseCode = "200", description = "OK")
  @Operation
      (summary = "Обновление курса валюты, либо изменение записи при отсутствии записи о валюте",
          method = "PUT",
          requestBody = @RequestBody(
              required = true,
              content = {@Content(mediaType = MediaType.APPLICATION_JSON_VALUE)}
          )
      )
  ResponseEntity<CurrencyDto> updateRate(@Valid CurrencyDto dto);



  @ApiResponse(responseCode = "200", description = "OK")
  @Operation(summary = "Получение всех записей о курсах валют")
  List<CurrencyDto> getAll();

}
