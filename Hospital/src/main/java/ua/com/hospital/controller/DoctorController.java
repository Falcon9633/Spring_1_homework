package ua.com.hospital.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.RestController;
import ua.com.hospital.api.DoctorApi;
import ua.com.hospital.assembler.DoctorAssembler;
import ua.com.hospital.controller.model.DoctorModel;
import ua.com.hospital.dto.DoctorDto;
import ua.com.hospital.service.DoctorService;

@RestController
@Slf4j
@RequiredArgsConstructor
public class DoctorController implements DoctorApi {

    private final DoctorService doctorService;
    private final DoctorAssembler doctorAssembler;

    @Override
    public DoctorModel setSpecialization(Long doctorId, Long specId) {
        log.info("setSpecialization: doctorId -> {}, specializationId -> {}", doctorId, specId);
        DoctorDto doctorDto = doctorService.setSpecialization(doctorId, specId);
        return doctorAssembler.toModel(doctorDto);
    }
}
