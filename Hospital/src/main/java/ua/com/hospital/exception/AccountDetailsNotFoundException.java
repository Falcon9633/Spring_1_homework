package ua.com.hospital.exception;

import ua.com.hospital.model.enums.ErrorType;

public class AccountDetailsNotFoundException extends ServiceException {
    public static final String DEFAULT_MESSAGE = "AccountDetails is not found!";

    public AccountDetailsNotFoundException() {
        super(DEFAULT_MESSAGE);
    }

    public AccountDetailsNotFoundException(String s) {
        super(s);
    }

    @Override
    public ErrorType getErrorType() {
        return ErrorType.DATABASE_ERROR_TYPE;
    }
}
