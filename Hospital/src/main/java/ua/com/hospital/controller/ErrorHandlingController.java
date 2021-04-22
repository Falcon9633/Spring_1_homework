package ua.com.hospital.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import ua.com.hospital.exception.ServiceException;
import ua.com.hospital.model.Error;
import ua.com.hospital.model.enums.ErrorType;

import javax.validation.ConstraintViolationException;
import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@RestControllerAdvice
@Slf4j
public class ErrorHandlingController {

    @ExceptionHandler(MethodArgumentNotValidException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public List<Error> handleMethodArgumentNotValidException(MethodArgumentNotValidException ex) {
        if (ex.getBindingResult().getFieldErrors().isEmpty()) {
            return ex.getBindingResult().getAllErrors().stream().
                    map(err -> new Error(
                            err.getDefaultMessage(),
                            ErrorType.VALIDATION_ERROR_TYPE,
                            LocalDateTime.now()
                    )).collect(Collectors.toList());
        }

        return ex.getBindingResult().getFieldErrors().stream()
                .map(fieldError -> fieldError.getField() + " -> " + fieldError.getDefaultMessage())
                .peek(s -> log.error("handleMethodArgumentNotValidException: {}", s))
                .map(err -> new Error(
                        err,
                        ErrorType.VALIDATION_ERROR_TYPE,
                        LocalDateTime.now()
                )).collect(Collectors.toList());
    }

    @ExceptionHandler(ConstraintViolationException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public List<Error> handleConstraintViolationException(ConstraintViolationException ex) {
        return ex.getConstraintViolations().stream()
                .map(cv -> cv.getPropertyPath() + " -> " + cv.getMessage())
                .peek(s -> log.error("handleConstraintViolationException: {}", s))
                .map(err -> new Error(
                        err,
                        ErrorType.VALIDATION_ERROR_TYPE,
                        LocalDateTime.now()
                )).collect(Collectors.toList());
    }

    @ExceptionHandler(DataIntegrityViolationException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public Error handleDataIntegrityViolationException(DataIntegrityViolationException ex) {
        log.error("handleDataIntegrityViolationException: message -> {}", ex.getMostSpecificCause().getMessage());
        return new Error(ex.getMostSpecificCause().getMessage(), ErrorType.VALIDATION_ERROR_TYPE, LocalDateTime.now());
    }

    @ExceptionHandler(ServiceException.class)
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public Error handleServiceException(ServiceException ex) {
        log.error("handleServiceException: message -> {}", ex.getMessage());
        return new Error(ex.getMessage(), ex.getErrorType(), LocalDateTime.now());
    }

    @ExceptionHandler(Exception.class)
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public Error handleException(Exception ex) {
        log.error("handleException: message -> {}", ex.getMessage());
        System.out.println(ex.getClass());
        ex.printStackTrace();
        return new Error(ex.getMessage(), ErrorType.FATAL_ERROR_TYPE, LocalDateTime.now());
    }
}
