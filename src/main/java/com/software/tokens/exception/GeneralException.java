package com.software.tokens.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

@ControllerAdvice
public class GeneralException {

    @ExceptionHandler(value = Exception.class)
    public ResponseEntity<?> handleException(Exception exception, WebRequest webRequest) {

        List<String> errors = new ArrayList<>();
        errors.add(exception.getMessage());

        ErrorDetails errorDetails = new ErrorDetails(

                Calendar.getInstance(), exception.getClass().getSimpleName(),
                errors, webRequest.getDescription(false)
        );

        return new ResponseEntity(errorDetails, HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @ExceptionHandler(value = ObjectNotFoundException.class)
    public ResponseEntity<?> handleObjectNotFoundException(
            ObjectNotFoundException objectNotFoundException, WebRequest webRequest
    ) {

        List<String> errors = new ArrayList<>();
        errors.add(objectNotFoundException.getMessage());

        ErrorDetails errorDetails = new ErrorDetails(
                Calendar.getInstance(), objectNotFoundException.getClass().getSimpleName(),
                errors, webRequest.getDescription(false)
        );

        return new ResponseEntity(errorDetails, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(value = MethodArgumentNotValidException.class)
    public ResponseEntity<?> handleMethodArgumentNotValidException(
            MethodArgumentNotValidException methodArgumentNotValidException, WebRequest webRequest) {


        List<String> errors = new ArrayList<>();
        for (FieldError error : methodArgumentNotValidException.getBindingResult().getFieldErrors()) {
            errors.add(error.getField() + ": " + error.getDefaultMessage());
        }
        for (ObjectError error : methodArgumentNotValidException.getBindingResult().getGlobalErrors()) {
            errors.add(error.getObjectName() + ": " + error.getDefaultMessage());
        }

        ErrorDetails errorDetails = new ErrorDetails(Calendar.getInstance(),
                methodArgumentNotValidException.getClass().getSimpleName(),
                errors,
                webRequest.getDescription(false));

        return new ResponseEntity(errorDetails, HttpStatus.BAD_REQUEST);
    }


}
