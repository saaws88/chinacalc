package com.saaws88.chinacalc.infrastructure.api.v1.user;


import java.util.List;

import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;

import com.saaws88.chinacalc.infrastructure.api.v1.user.dto.UserCreationDto;
import com.saaws88.chinacalc.infrastructure.api.v1.user.dto.UserResponseDto;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.parameters.RequestBody;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;

@Tag(name = "Работа с пользователями")
@Validated
public interface UserController {


  @Operation
    (summary = "Создание пользователя", 
      method = "POST",
      requestBody = @RequestBody(
        required = true,
        content = {@Content(mediaType = MediaType.APPLICATION_JSON_VALUE)}
      )
    )
  @ApiResponse(responseCode = "201", description = "Пользователь создан")
    ResponseEntity<UserResponseDto> createUser(@Valid UserCreationDto user);

  @Operation
    (summary = "Создание администратора",
     method = "POST",
     requestBody = @RequestBody(
       required = true,
       content = {@Content(mediaType = MediaType.APPLICATION_JSON_VALUE)}
       )
     )
  @ApiResponse(responseCode = "201", description = "Админ создан")
    ResponseEntity<UserResponseDto> createAdmin(@Valid UserCreationDto dto);
  @Operation(summary = "Удаление пользователя по id",
    method = "DELETE",
    parameters = {@Parameter(name = "id", required = true, description = "Id пользователя")}
  )
  @ApiResponse(responseCode = "200", description = "Пользователь удален")
  ResponseEntity<String> deleteUserById(Long id);

  @Operation(summary = "Получения списка всех пользователей")
  List<UserResponseDto> listAll();

  @ApiResponses(value = {
    @ApiResponse(responseCode = "200", description = "Пользователь заблокирован"),
    @ApiResponse(responseCode = "404", description = "Пользователь не найден")
  })
  @Operation(
    summary = "Блокировка пользователя по ID",
    method = "POST",
    parameters = {@Parameter(name = "id", required = true, description = "Id пользователя")}
  )
  ResponseEntity<String> blockUserById(Long id);

}

