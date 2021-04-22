package ua.com.hospital.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import ua.com.hospital.api.SpecializationApi;
import ua.com.hospital.assembler.SpecializationAssembler;
import ua.com.hospital.controller.model.SpecializationModel;
import ua.com.hospital.dto.SpecializationDto;
import ua.com.hospital.service.SpecializationService;

@RestController
@Slf4j
@RequiredArgsConstructor
public class SpecializationController implements SpecializationApi {

    private final SpecializationService specializationService;
    private final SpecializationAssembler specializationAssembler;

    @Override
    public SpecializationModel createSpecialization(SpecializationDto specializationDto) {
        log.info("createSpecialization -> {}", specializationDto);
        SpecializationDto specialization = specializationService.createSpecialization(specializationDto);
        return specializationAssembler.toModel(specialization);
    }

    @Override
    public SpecializationModel getSpecialization(Long id) {
        log.info("getSpecialization: id -> {}", id);
        SpecializationDto specialization = specializationService.getSpecialization(id);
        return specializationAssembler.toModel(specialization);
    }

    @Override
    public SpecializationModel updateSpecialization(Long id, SpecializationDto specializationDto) {
        log.info("updateSpecialization: id -> {}", id);
        SpecializationDto specialization = specializationService.updateSpecialization(id, specializationDto);
        return specializationAssembler.toModel(specialization);
    }
}
