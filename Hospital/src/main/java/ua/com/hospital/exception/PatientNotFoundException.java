package ua.com.hospital.exception;

import ua.com.hospital.model.enums.ErrorType;

public class PatientNotFoundException extends ServiceException{
    public static final String DEFAULT_MESSAGE = "Patient is not found!";

    public PatientNotFoundException() {
        super(DEFAULT_MESSAGE);
    }

    public PatientNotFoundException(String s) {
        super(s);
    }

    @Override
    public ErrorType getErrorType() {
        return ErrorType.DATABASE_ERROR_TYPE;
    }
}
