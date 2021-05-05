package ua.com.hospital.controller.model;

import com.fasterxml.jackson.annotation.JsonUnwrapped;
import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.hateoas.RepresentationModel;
import ua.com.hospital.dto.DoctorDto;

@Data
@AllArgsConstructor
public class DoctorModel extends RepresentationModel<DoctorModel> {
    @JsonUnwrapped
    private DoctorDto doctorDto;
}
