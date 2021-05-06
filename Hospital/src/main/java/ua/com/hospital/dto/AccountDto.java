package ua.com.hospital.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;
import lombok.ToString;
import org.springframework.format.annotation.DateTimeFormat;
import ua.com.hospital.model.enums.Authority;
import ua.com.hospital.validator.OnPatch;
import ua.com.hospital.validator.OnPost;
import ua.com.hospital.validator.annotation.PasswordMatches;
import ua.com.hospital.validator.annotation.ValueOfEnum;

import javax.validation.constraints.*;
import java.time.LocalDate;

@Data
@PasswordMatches
@JsonInclude(JsonInclude.Include.NON_NULL)
public class AccountDto {
    @Null
    private Long id;
    @NotBlank(groups = OnPost.class)
    @Size(min = 6, max = 16, groups = OnPost.class)
    @Null(groups = OnPatch.class)
    private String username;
    @NotBlank
    @Size(min = 6, max = 16)
    @ToString.Exclude
    private String password;
    @NotBlank
    @Size(min = 6, max = 16)
    @ToString.Exclude
    private String repeatPassword;
    @NotBlank(groups = OnPost.class)
    @Email
    private String email;
    @NotBlank(groups = OnPost.class)
    @ValueOfEnum(enumClass = Authority.class)
    private String authority;
    @NotBlank(groups = OnPost.class)
    @Size(min = 2)
    private String name;
    @NotBlank(groups = OnPost.class)
    @Size(min = 2)
    private String surname;
    @PastOrPresent
    @DateTimeFormat(pattern = "yyyy-mm-dd")
    private LocalDate birthday;
}
