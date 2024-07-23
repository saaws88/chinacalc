package com.saaws88.chinacalc.infrastructure.api.v1;

import com.saaws88.chinacalc.service.implementation.exception.ObjectAlreadyExistsException;
import com.saaws88.chinacalc.service.implementation.exception.ObjectNotFoundException;
import org.springdoc.api.ErrorMessage;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;

@RestControllerAdvice
public class ControllerExceptionHandler {

  @ExceptionHandler(value = ObjectAlreadyExistsException.class)
  @ResponseStatus(value = HttpStatus.BAD_REQUEST)
  private ErrorMessage objectAlreadyExistException(ObjectAlreadyExistsException e) {
    return new ErrorMessage(e.getMessage());
  }

  @ExceptionHandler(value = ObjectNotFoundException.class)
  @ResponseStatus(value = HttpStatus.BAD_REQUEST)
  private ErrorMessage objectNotFoundException(ObjectNotFoundException e) {
    return new ErrorMessage(e.getMessage());
  }

  @ExceptionHandler(value = MethodArgumentNotValidException.class)
  @ResponseStatus(value = HttpStatus.BAD_REQUEST)
  private ErrorMessage methodArgumentNotValidException(MethodArgumentNotValidException e) {
    return new ErrorMessage(e.getMessage());
  }

}
