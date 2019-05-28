package com.example.demo.beans.xd;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class MapElementExceptionController {
    @ExceptionHandler(value = MapElementNotFound.class)
    public ResponseEntity<Object> exception(MapElementNotFound exception) {
        return new ResponseEntity<>("MapElement not found", HttpStatus.NOT_FOUND);
    }
}
