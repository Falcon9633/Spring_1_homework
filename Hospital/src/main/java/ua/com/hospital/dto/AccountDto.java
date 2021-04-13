package ua.com.hospital.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;
import ua.com.hospital.model.Role;
import ua.com.hospital.validator.ValueOfEnum;

import javax.validation.constraints.*;
import java.time.LocalDateTime;

@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class AccountDto {
    private Long id;
    @NotBlank
    @Size(min = 6, max = 16)
    private String login;
    @NotBlank
    @Size(min = 6, max = 16)
    private String password;
    @NotBlank
    @Size(min = 6, max = 16)
    private String repeatPassword;
    @NotBlank
    @Email
    private String email;
    private LocalDateTime createdTime;
    private LocalDateTime updatedTime;
    private boolean locked;
    @ValueOfEnum(enumClass = Role.class)
    private String role;
}
