package com.saaws88.chinacalc.infrastructure.api.v1.user.dto;

import java.util.Set;

import com.saaws88.chinacalc.domain.model.user.enumerated.Role;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Schema(description = "Транспортный объект для создания пользователя")
public class UserCreationDto {
    
  @Schema(description = "Электронная почта пользователя")
  @NotNull
  private String email;

  @Schema(description = "Роли пользователя")
  private Set<Role> roles;
}
