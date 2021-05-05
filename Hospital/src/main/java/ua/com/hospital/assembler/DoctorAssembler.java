package ua.com.hospital.assembler;

import org.springframework.hateoas.Link;
import org.springframework.hateoas.server.mvc.RepresentationModelAssemblerSupport;
import org.springframework.stereotype.Component;
import ua.com.hospital.controller.DoctorController;
import ua.com.hospital.controller.model.DoctorModel;
import ua.com.hospital.dto.DoctorDto;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.*;

@Component
public class DoctorAssembler extends RepresentationModelAssemblerSupport<DoctorDto, DoctorModel> {

    public DoctorAssembler() {
        super(DoctorController.class, DoctorModel.class);
    }

    @Override
    public DoctorModel toModel(DoctorDto entity) {
        DoctorModel doctorModel = new DoctorModel(entity);
        Link setSpecialization = linkTo(
                methodOn(DoctorController.class).
                setSpecialization(entity.getId(), entity.getSpecializationId())
        ).withRel("setSpecialization");
        doctorModel.add(setSpecialization);
        return doctorModel;
    }
}
