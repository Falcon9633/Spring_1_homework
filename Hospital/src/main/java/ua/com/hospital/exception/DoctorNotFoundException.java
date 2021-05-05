package ua.com.hospital.exception;

import ua.com.hospital.model.enums.ErrorType;

public class DoctorNotFoundException extends ServiceException {
    public static final String DEFAULT_MESSAGE = "Doctor is not found!";

    public DoctorNotFoundException() {
        super(DEFAULT_MESSAGE);
    }

    public DoctorNotFoundException(String s) {
        super(s);
    }

    @Override
    public ErrorType getErrorType() {
        return ErrorType.DATABASE_ERROR_TYPE;
    }
}
