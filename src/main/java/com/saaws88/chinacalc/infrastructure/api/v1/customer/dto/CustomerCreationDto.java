package com.saaws88.chinacalc.infrastructure.api.v1.customer.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Email;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Schema(description = "Транспортный объект для создания клиента")
public class CustomerCreationDto {

  @Schema(description = "Частное лицо")
  @NotNull
  private boolean privatePerson;

  @Schema(description = "Наименование клиента")
  @NotNull
  private String customerName;

  @Schema(description = "Фамилия контактного лица")
  @NotNull
  private String contactLastName;

  @Schema(description = "Имя контактного лица") 
  @NotNull
  private String contactFirstName;

  @Schema(description = "Отчество контактного лица")
  private String contactPatronymic;

  @Schema(description = "Город")
  @NotNull
  private String city;

  @Schema(description = "Электронная почта")
  @NotNull
  @Email
  private String email;

  @Schema(description = "Номер телефона")
  @NotNull
  private String phoneNumber;

  @Schema(description = "ИНН")
  @NotNull
  private String taxpayerIdentificationNumber;

}
