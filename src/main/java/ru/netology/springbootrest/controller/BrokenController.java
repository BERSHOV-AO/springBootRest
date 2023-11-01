package ru.netology.springbootrest.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;
import ru.netology.springbootrest.domain.Person;

// Заведомо надломенный контроллер
@RequestMapping("/error")
@RestController
public class BrokenController {

    // запрос get по id
    @GetMapping("/{id}")
    public Person getPersonById(@PathVariable long id) {
        // Мы не будем писаль логику получения пользователя
        try {
            // не смогли мы найти пользователя
            throw new IllegalArgumentException("IllegalArgumentException");
            // тут мы ловим IllegalArgumentException, так как он является наследником RuntimeException
        } catch (RuntimeException e) {
            // выбрасываем уже спринговую ошибку(ResponseStatusException), спринговое исключени
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "ResponseStatusException", e);
        }
    }

    // Данный хендлер, по гетеру
    // Данный метод просто будет выбрасывать нужное нам исключение
    @GetMapping("/iae")
    public Person throwException() {
        throw new IllegalArgumentException("IllegalArgumentException");
    }
    //------------------------------------------------------------------------------------------------
    // Есть некоторая проблемма в использовании  @ExceptionHandler
    //  - @ExceptionHandler работает только в том контроллере в которм он обьявлен


    //-------------------------------------------------------------------------------------------------

    // Мы создаем отдельный метод, который будет обработчиком исключений
    // будем возврощать ResponseEntity<String> - строчку
    // В параметрах аннотации @ExceptionHandler(), указываем какую ощибку (исключение) мы хотим поймать
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
