package ua.com.hospital.exception;

import ua.com.hospital.model.enums.ErrorType;

public class AccountNotFoundException extends ServiceException {
    public static final String DEFAULT_MESSAGE = "Account is not found!";

    public AccountNotFoundException() {
        super(DEFAULT_MESSAGE);
    }

    public AccountNotFoundException(String s) {
        super(s);
    }

    @Override
    public ErrorType getErrorType() {
        return ErrorType.DATABASE_ERROR_TYPE;
    }
}
