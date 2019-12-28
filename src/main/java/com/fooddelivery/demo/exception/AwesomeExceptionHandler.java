package com.fooddelivery.demo.exception;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class AwesomeExceptionHandler extends ResponseEntityExceptionHandler {

  @ExceptionHandler(ThereIsNoSuchElementException.class)
  protected ResponseEntity<AwesomeException> handleThereIsNoSuchElementException() {
    return new ResponseEntity<>(new AwesomeException("There is no such element"),
        HttpStatus.NOT_FOUND);
  }

  @Data
  @AllArgsConstructor
  private static class AwesomeException {

    private String message;
  }
}
