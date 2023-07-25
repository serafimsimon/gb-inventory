package ru.gb.inventory.department.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import ru.gb.inventory.department.api.DepartmentError;
import ru.gb.inventory.department.api.ResourceNotFoundException;

@Component
@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler
    public ResponseEntity<?> catchResourceNotFoundException(ResourceNotFoundException e){
        return new ResponseEntity<>(new DepartmentError(e.getMessage()), HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler
    public ResponseEntity<?> catchValidationException(ru.gb.inventory.department.exceptions.DataValidationException e){
        return new ResponseEntity<>(new DepartmentError(e.getMessages()), HttpStatus.BAD_REQUEST);
    }
}
