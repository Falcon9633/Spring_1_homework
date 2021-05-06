package ua.com.hospital.validator.annotation;

import ua.com.hospital.dto.AccountDto;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class PasswordMatchesValidator implements ConstraintValidator<PasswordMatches, Object> {

    @Override
    public void initialize(PasswordMatches constraintAnnotation) {
    }

    @Override
    public boolean isValid(Object value, ConstraintValidatorContext context) {
        AccountDto accountDto = (AccountDto) value;
        return accountDto.getPassword().equals(accountDto.getRepeatPassword());
    }
}
