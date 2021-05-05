package ua.com.hospital.service.impl;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import ua.com.hospital.dto.SpecializationDto;
import ua.com.hospital.exception.SpecializationNotFoundException;
import ua.com.hospital.mapper.SpecializationDtoMapper;
import ua.com.hospital.model.Specialization;
import ua.com.hospital.repository.SpecializationRepository;
import ua.com.hospital.service.SpecializationService;

@Service
@Slf4j
@RequiredArgsConstructor
public class SpecializationServiceImpl implements SpecializationService {

    private final SpecializationRepository specializationRepository;
    private final SpecializationDtoMapper specializationDtoMapper;

    @Override
    public SpecializationDto createSpecialization(SpecializationDto specializationDto) {
        Specialization specialization = specializationDtoMapper.mapDtoToSpec(specializationDto);
        specialization = specializationRepository.save(specialization);
        return specializationDtoMapper.mapSpecToDto(specialization);
    }

    @Override
    public SpecializationDto getSpecialization(Long id) {
        Specialization specialization = specializationRepository.findById(id)
                .orElseThrow(SpecializationNotFoundException::new);
        log.info("found specialization -> {}", specialization);
        return specializationDtoMapper.mapSpecToDto(specialization);
    }

    @Override
    public SpecializationDto updateSpecialization(Long id, SpecializationDto specializationDto) {
        Specialization specFromDB = specializationRepository.findById(id).orElseThrow(SpecializationNotFoundException::new);
        log.debug("found specialization -> {}", specFromDB);
        specializationDtoMapper.updateSpecializationFromDto(specializationDto, specFromDB);
        Specialization updatedSpec = specializationRepository.save(specFromDB);
        log.info("updated specialization -> {}", updatedSpec);
        return specializationDtoMapper.mapSpecToDto(updatedSpec);
    }
}
