package com.ogl.api_estacionamento.domain.controller.exception;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.NoSuchElementException;

@RestControllerAdvice
public class GlobalExceptionHandler {

    private final Logger logger = LoggerFactory.getLogger(GlobalExceptionHandler.class);

    // CLIENT EXCEPTIONS
    @ExceptionHandler(ClientNotFoundException.class)
    public ResponseEntity<String> handleClientNotFoundException(ClientNotFoundException clientNotFoundException) {
        return new ResponseEntity<>(clientNotFoundException.getMessage(), HttpStatus.NOT_FOUND);
    }
    @ExceptionHandler(CpfAlreadyUsedException.class)
    public ResponseEntity<String> handleCpfAlreadyUsedException(CpfAlreadyUsedException cpfAlreadyUsedException) {
        return new ResponseEntity<>(cpfAlreadyUsedException.getMessage(), HttpStatus.CONFLICT);
    }

    // VEHICLE EXCEPTIONS
    @ExceptionHandler(VehicleNotFoundException.class)
    public ResponseEntity<String> handleVehicleNotFoundException(VehicleNotFoundException vehicleNotFoundException) {
        return new ResponseEntity<>(vehicleNotFoundException.getMessage(), HttpStatus.NOT_FOUND);
    }
    @ExceptionHandler(PlacaAlreadyUsedException.class)
    public ResponseEntity<String> handlePlacaAlreadyUsedException(PlacaAlreadyUsedException placeAlreadyUsedException) {
        return new ResponseEntity<>(placeAlreadyUsedException.getMessage(), HttpStatus.CONFLICT);
    }

    // GENERAL EXCEPTIONS
    @ExceptionHandler(NoSuchElementException.class)
    public ResponseEntity<String> handleNotFoundException(NoSuchElementException notFoundException) {
        return new ResponseEntity<>("Object not found", HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(IllegalArgumentException.class)
    public ResponseEntity<String> handleBusinessException(IllegalArgumentException businessException) {
        return new ResponseEntity<>(businessException.getMessage(), HttpStatus.UNPROCESSABLE_ENTITY);
    }

    @ExceptionHandler(Throwable.class)
    public ResponseEntity<String> handleUnexpectedException(Throwable unexpectedException) {
        var message = "Unexpected server error, see the logs";
        logger.error(message, unexpectedException);
        return new ResponseEntity<>(message, HttpStatus.INTERNAL_SERVER_ERROR);
    }

}
