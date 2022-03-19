package kamysh.controller;

import kamysh.dto.ErrorDTO;
import kamysh.dto.ValidationErrorDTO;
import kamysh.exceptions.*;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.HttpMediaTypeNotSupportedException;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.persistence.EntityNotFoundException;
import javax.validation.ConstraintViolationException;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;


@ControllerAdvice
public class ErrorController {

    private final Map<String, ErrorCode> errorsMap;
    private final Map<String, HttpStatus> statusesMap;

    public ErrorController() {
        this.errorsMap = new HashMap<>();
        this.statusesMap = new HashMap<>();

        this.statusesMap.put(EntityEntryNotFound.class.getName(), HttpStatus.NOT_FOUND);
        this.statusesMap.put(EntityNotFoundException.class.getName(), HttpStatus.NOT_FOUND);
        this.statusesMap.put(javax.persistence.NoResultException.class.getName(), HttpStatus.BAD_REQUEST);
        this.statusesMap.put(NumberFormatException.class.getName(), HttpStatus.BAD_REQUEST);
        this.statusesMap.put(HttpMediaTypeNotSupportedException.class.getName(), HttpStatus.UNSUPPORTED_MEDIA_TYPE);
        this.statusesMap.put(HttpRequestMethodNotSupportedException.class.getName(), HttpStatus.METHOD_NOT_ALLOWED);

        this.errorsMap.put(EntityEntryNotFound.class.getName(), ErrorCode.ENTITY_ENTRY_NOT_FOUND);
        this.errorsMap.put(EntityNotFoundException.class.getName(), ErrorCode.ENTITY_NOT_FOUND);
        this.errorsMap.put(javax.persistence.NoResultException.class.getName(), ErrorCode.ENTITY_ENTRY_NOT_FOUND);
        this.errorsMap.put(NumberFormatException.class.getName(), ErrorCode.INVALID_DATA_FORMAT);
        this.errorsMap.put(HttpMediaTypeNotSupportedException.class.getName(), ErrorCode.INVALID_MEDIA_TYPE);
        this.errorsMap.put(HttpRequestMethodNotSupportedException.class.getName(), ErrorCode.METHOD_NOT_ALLOWED);
    }

    protected Object handleConstraintViolationException(Throwable throwable) {
        ConstraintViolationException validationError = (ConstraintViolationException) throwable;
        Map<String, String> validationErrors = new HashMap<>();
        validationError.getConstraintViolations().forEach(
                c -> validationErrors.put(c.getPropertyPath().toString(), c.getMessage()));
        return ResponseEntity
                .status(HttpStatus.BAD_REQUEST)
                .contentType(MediaType.APPLICATION_XML)
                .body(
                        ValidationErrorDTO.builder()
                                .error(ErrorCode.VALIDATION_ERROR.name())
                                .message(validationErrors)
                                .build()
                );
    }

    protected Object handleDefaultError(Throwable throwable, String errorName) {
        HttpStatus statusCode = HttpStatus.INTERNAL_SERVER_ERROR;
        ErrorCode errorCode = ErrorCode.INTERNAL_SERVER_ERROR;
        throwable.printStackTrace();

        if (this.statusesMap.containsKey(errorName)) statusCode = this.statusesMap.get(errorName);
        if (this.errorsMap.containsKey(errorName)) errorCode = this.errorsMap.get(errorName);
        return ResponseEntity
                .status(statusCode)
                .contentType(MediaType.APPLICATION_XML)
                .body(
                        ErrorDTO.builder()
                                .error(errorCode.name())
                                .message(throwable.getMessage())
                                .build()
                );
    }

    protected Object handleInvalidValueException(Throwable throwable) {
        InvalidValueException exception = (InvalidValueException) throwable;

        ErrorCode errorCode = ErrorCode.VALIDATION_ERROR;
        if (exception.getErrorCode() != null) errorCode = exception.getErrorCode();

        return ResponseEntity
                .status(HttpStatus.BAD_REQUEST)
                .contentType(MediaType.APPLICATION_XML)
                .body(
                        ErrorDTO.builder()
                                .error(errorCode.name())
                                .message(throwable.getMessage())
                                .build()
                );
    }

    protected Object handleFieldNotFoundException(Throwable throwable) {
        FieldNotFoundException exception = (FieldNotFoundException) throwable;
        ErrorCode errorCode = ErrorCode.VALIDATION_ERROR;
        HashMap<String, String> map = new HashMap<>();
        map.put(exception.getField(), exception.getMessage());
        return ResponseEntity
                .status(HttpStatus.BAD_REQUEST)
                .contentType(MediaType.APPLICATION_XML)
                .body(
                        ValidationErrorDTO.builder()
                                .error(errorCode.name())
                                .message(map)
                                .build()
                );
    }


    protected Object handleFilterModeNotFoundException(Throwable throwable) {
        FilterModeNotFound exception = (FilterModeNotFound) throwable;
        ErrorCode errorCode = ErrorCode.VALIDATION_ERROR;
        HashMap<String, String> map = new HashMap<>();
        map.put(exception.getFilterMode(), exception.getMessage());
        return ResponseEntity
                .status(HttpStatus.BAD_REQUEST)
                .contentType(MediaType.APPLICATION_XML)
                .body(
                        ValidationErrorDTO.builder()
                                .error(errorCode.name())
                                .message(map)
                                .build()
                );
    }


    protected Object handlePersistenceException(Throwable throwable) throws IOException {
        return handleCauseException(throwable);
    }

    protected Object handleCauseException(Throwable throwable)
            throws IOException {
        Exception causedException = (Exception) throwable;
        if (causedException.getCause() != null) return handleException(causedException.getCause());
        else return handleDefaultError(throwable, throwable.getClass().getName());
    }

    protected Object handleJsonException(Throwable throwable) {
        throwable.printStackTrace();
        ErrorCode code = ErrorCode.INVALID_BODY_DATA_FORMAT;
        return ResponseEntity
                .status(HttpStatus.BAD_REQUEST)
                .contentType(MediaType.APPLICATION_XML)
                .body(
                        ErrorDTO.builder()
                                .error(code.name())
                                .message(throwable.getMessage())
                                .build()
                );
    }

    protected Object handleDataFormatException(Throwable throwable) {
        throwable.printStackTrace();
        ErrorCode code = ErrorCode.INCORRECT_DATA_FORMAT;
        return ResponseEntity
                .status(HttpStatus.BAD_REQUEST)
                .contentType(MediaType.APPLICATION_XML)
                .body(
                        ErrorDTO.builder()
                                .error(code.name())
                                .message(throwable.getMessage())
                                .build()
                );
    }

    protected Object handleInvalidFilterModeFormatException(Throwable throwable) {
        throwable.printStackTrace();
        ErrorCode code = ErrorCode.INVALID_FILTER_FORMAT;
        return ResponseEntity
                .status(HttpStatus.BAD_REQUEST)
                .contentType(MediaType.APPLICATION_XML)
                .body(
                        ErrorDTO.builder()
                                .error(code.name())
                                .message(throwable.getMessage())
                                .build()
                );
    }

    protected Object handleIncorrectOrderStringException(Throwable throwable) {
        throwable.printStackTrace();
        ErrorCode code = ErrorCode.INCORRECT_ORDER_DATA_FORMAT;
        return ResponseEntity
                .status(HttpStatus.BAD_REQUEST)
                .contentType(MediaType.APPLICATION_XML)
                .body(
                        ErrorDTO.builder()
                                .error(code.name())
                                .message(throwable.getMessage())
                                .build()
                );
    }

    protected Object handleIncorrectFilterStringException(Throwable throwable) {
        throwable.printStackTrace();
        ErrorCode code = ErrorCode.INCORRECT_FILTER_DATA_FORMAT;
        return ResponseEntity
                .status(HttpStatus.BAD_REQUEST)
                .contentType(MediaType.APPLICATION_XML)
                .body(
                        ErrorDTO.builder()
                                .error(code.name())
                                .message(throwable.getMessage())
                                .build()
                );
    }

    @ResponseBody
    @ExceptionHandler(Exception.class)
    protected Object handleException(Throwable throwable) throws IOException {
        String errorName = throwable.getClass().getName();
        switch (errorName) {
            case "kamysh.exceptions.InvalidValueException":
                return handleInvalidValueException(throwable);
            case "kamysh.exceptions.FieldNotFoundException":
                return handleFieldNotFoundException(throwable);
            case "kamysh.exceptions.FilterModeNotFoundException":
                return handleFilterModeNotFoundException(throwable);
            case "javax.validation.ConstraintViolationException":
                return handleConstraintViolationException(throwable);
            case "javax.persistence.PersistenceException":
                return handlePersistenceException(throwable);
            case "java.lang.IllegalArgumentException":
            case "org.springframework.http.converter.HttpMessageNotReadableException":
                return handleCauseException(throwable);
            case "kamysh.exceptions.IncorrectOrderString":
                return handleIncorrectOrderStringException(throwable);
            case "kamysh.exceptions.IncorrectFilterString":
                return handleIncorrectFilterStringException(throwable);
            case "com.fasterxml.jackson.core.io.JsonEOFException":
            case "com.fasterxml.jackson.core.JsonParseException":
                return handleJsonException(throwable);
            case "com.fasterxml.jackson.databind.exc.InvalidFormatException":
            case "com.ctc.wstx.exc.WstxParsingException":
            case "java.io.IOException":
                return handleDataFormatException(throwable);
            case "kamysh.exceptions.FilterModeNotFound":
                return handleInvalidFilterModeFormatException(throwable);
            default:
                return handleCauseException(throwable);
        }
    }
}
