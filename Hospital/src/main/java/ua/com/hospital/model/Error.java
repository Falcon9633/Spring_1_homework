package ua.com.hospital.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import ua.com.hospital.model.enums.ErrorType;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
public class Error {
    private String message;
    private ErrorType errorType;
    private LocalDateTime timestamp;
}
