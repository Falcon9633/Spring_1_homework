package ua.com.hospital.assembler;

import org.springframework.hateoas.Link;
import org.springframework.hateoas.server.mvc.RepresentationModelAssemblerSupport;
import org.springframework.stereotype.Component;
import ua.com.hospital.controller.SpecializationController;
import ua.com.hospital.controller.model.SpecializationModel;
import ua.com.hospital.dto.SpecializationDto;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.*;

@Component
public class SpecializationAssembler extends RepresentationModelAssemblerSupport<SpecializationDto, SpecializationModel> {

    public SpecializationAssembler() {
        super(SpecializationController.class, SpecializationModel.class);
    }

    @Override
    public SpecializationModel toModel(SpecializationDto entity) {
        SpecializationModel specializationModel = new SpecializationModel(entity);
        Link create = linkTo(methodOn(SpecializationController.class).createSpecialization(entity))
                .withRel("createSpecialization");
        Link get = linkTo(methodOn(SpecializationController.class).getSpecialization(entity.getId()))
                .withRel("getSpecialization");
        Link update = linkTo(methodOn(SpecializationController.class).updateSpecialization(entity.getId(), entity))
                .withRel("updateSpecialization");
        specializationModel.add(create, get, update);
        return specializationModel;
    }
}
