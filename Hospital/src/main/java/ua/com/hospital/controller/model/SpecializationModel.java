package ua.com.hospital.controller.model;

import com.fasterxml.jackson.annotation.JsonUnwrapped;
import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.hateoas.RepresentationModel;
import ua.com.hospital.dto.SpecializationDto;

@Data
@AllArgsConstructor
public class SpecializationModel extends RepresentationModel<SpecializationModel> {
    @JsonUnwrapped
    private SpecializationDto specializationDto;
}
