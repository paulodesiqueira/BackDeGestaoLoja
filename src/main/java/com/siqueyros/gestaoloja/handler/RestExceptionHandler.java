package com.siqueyros.gestaoloja.handler;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.siqueyros.gestaoloja.model.Exception.ResourceNotFoundException;
import com.siqueyros.gestaoloja.model.error.ErrorMessage;

@ControllerAdvice
public class RestExceptionHandler {
    
    @ExceptionHandler (ResourceNotFoundException.class)
    public ResponseEntity <?>handlerResourceNotFoundException(ResourceNotFoundException ex){

        ErrorMessage  error = new ErrorMessage("PAGINA NÃO ENCONTRADA", 
        HttpStatus.NOT_FOUND.value(), 
        ex.getMessage());

        return new ResponseEntity<>(error, HttpStatus.NOT_FOUND);
    }
}
