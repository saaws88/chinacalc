package com.saaws88.chinacalc.infrastructure.api.v1.currency;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Schema(description = "Транспортный объект для валюты")
public class CurrencyDto {
  
  @Schema(description = "Код валюты в формате ISO 4217")
  @NotNull
  private String code;

  @Schema(description = "Курс валюты к рублю")
  @NotNull
  private String rate;

}
