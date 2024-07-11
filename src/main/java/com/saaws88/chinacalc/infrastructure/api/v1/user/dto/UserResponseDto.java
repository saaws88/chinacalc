package com.saaws88.chinacalc.infrastructure.api.v1.user.dto;

import java.util.Set;

import com.saaws88.chinacalc.domain.model.user.enumerated.Role;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Schema(description = "Транспортный объект для получение информации о пользователе")
public class UserResponseDto {
   
  @Schema(description = "Идентификатор пользователя в БД")
  private Long id;

  @Schema(description = "Электронная почта пользователя")
  private String email;

  @Schema(description = "Роли пользователя")
  private Set<Role> roles;

  @Schema(description = "Данные для доступа аккаунта активны")
  private boolean credentialsNonExpired;

}
