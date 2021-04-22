package ua.com.hospital.exception;

import ua.com.hospital.model.enums.ErrorType;

public class SpecializationNotFoundException extends ServiceException{
    public static final String DEFAULT_MESSAGE = "Specialization is not found!";

    public SpecializationNotFoundException() {
        super(DEFAULT_MESSAGE);
    }

    public SpecializationNotFoundException(String s) {
        super(s);
    }

    @Override
    public ErrorType getErrorType() {
        return ErrorType.DATABASE_ERROR_TYPE;
    }
}
