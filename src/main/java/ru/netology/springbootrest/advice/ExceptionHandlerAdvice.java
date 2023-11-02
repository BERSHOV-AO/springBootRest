package ru.netology.springbootrest.advice;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

// Создаем свой общий обработчик исключений
@RestControllerAdvice()
public class ExceptionHandlerAdvice {
    // Описываем все свои @ExceptionHandler
    @ExceptionHandler(IllegalArgumentException.class)
    public ResponseEntity<String> ieaHandler(IllegalArgumentException e) {
        // body + статус(HttpStatus.NOT_FOUND) 404
        return new ResponseEntity<>("Exception in throwException method", HttpStatus.NOT_FOUND);

    }

    // HttpStatus.I_AM_A_TEAPOT - 418 ошибка - я чайник)
    @ExceptionHandler(RuntimeException.class)
    public ResponseEntity<String> reHandler(RuntimeException e) {
        return new ResponseEntity<>("Exception in throwException method", HttpStatus.I_AM_A_TEAPOT);
    }
}
