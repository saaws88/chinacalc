package com.saaws88.chinacalc.infrastructure.api.v1.customer.dto;

import com.saaws88.chinacalc.domain.model.customer.enumerated.CustomerCategory;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Schema(description = "Транспортный объект для получения информации о клиенте")
public class CustomerResponseDto {

  @Schema(description = "Идентификатор в БД")
  private Long id;

  @Schema(description = "Частное лицо")
  private boolean privatePerson;

  @Schema(description = "Наименование клиента")
  private String customerName;

  @Schema(description = "Фамилия контактного лица")
  private String contactLastName;

  @Schema(description = "Имя контактного лица") 
  private String contactFirstName;

  @Schema(description = "Отчество контактного лица")
  private String contactPatronymic;

  @Schema(description = "Город")
  private String city;

  @Schema(description = "Электронная почта")
  private String email;

  @Schema(description = "Номер телефона")
  private String phoneNumber;

  @Schema(description = "Категория клиента по количеству отправок через сервис")
  private CustomerCategory category;

  @Schema(description = "ИНН")
  private String taxpayerIdentificationNumber;

}
