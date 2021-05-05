package ua.com.hospital.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;

@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class DoctorDto {
    private Long id;
    private String name;
    private String surname;
    private Long specializationId;
    private String specializationName;
}
