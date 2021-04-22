package ua.com.hospital.service;

import ua.com.hospital.dto.SpecializationDto;

public interface SpecializationService {
    SpecializationDto createSpecialization(SpecializationDto specializationDto);

    SpecializationDto getSpecialization(Long id);

    SpecializationDto updateSpecialization(Long id, SpecializationDto specializationDto);
}
