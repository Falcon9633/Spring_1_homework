package ua.com.hospital.exception;

import lombok.Data;
import ua.com.hospital.model.Error;
import ua.com.hospital.model.enums.ErrorType;

@Data
public class ServiceException extends RuntimeException {
    private ErrorType errorType;

    public ServiceException() {
    }

    public ServiceException(String s) {
        super(s);
    }

    public ErrorType getErrorType() {
        return ErrorType.FATAL_ERROR_TYPE;
    }
}
