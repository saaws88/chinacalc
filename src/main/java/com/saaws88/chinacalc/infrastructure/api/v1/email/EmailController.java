package com.saaws88.chinacalc.infrastructure.api.v1.email;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;

@Tag(name = "Отправка электронной почты")
public interface EmailController {

  @ApiResponse(responseCode = "200", description = "Сообщение отправлено")
  @Operation(summary = "Отправка тестового сообщения",
    method = "POST",
    parameters = {@Parameter(required = true, name = "to", description = "Email получателя")}
  )
  String sendEmail(String to);


}
