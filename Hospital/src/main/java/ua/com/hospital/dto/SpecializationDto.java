package ua.com.hospital.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Null;
import javax.validation.constraints.Size;

@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class SpecializationDto {
    @Null
    private Long id;
    @NotBlank
    @Size(min = 3, max = 45)
    private String name;
}
