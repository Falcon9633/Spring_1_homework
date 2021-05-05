package ua.com.hospital.service.impl;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import ua.com.hospital.dto.DoctorDto;
import ua.com.hospital.exception.AccountDetailsNotFoundException;
import ua.com.hospital.exception.DoctorNotFoundException;
import ua.com.hospital.exception.SpecializationNotFoundException;
import ua.com.hospital.mapper.DoctorDtoMapper;
import ua.com.hospital.model.AccountDetails;
import ua.com.hospital.model.Doctor;
import ua.com.hospital.model.Specialization;
import ua.com.hospital.repository.AccountDetailsRepository;
import ua.com.hospital.repository.DoctorRepository;
import ua.com.hospital.repository.SpecializationRepository;
import ua.com.hospital.service.DoctorService;

@Service
@Slf4j
@RequiredArgsConstructor
public class DoctorServiceImpl implements DoctorService {
    private final DoctorRepository doctorRepository;
    private final SpecializationRepository specializationRepository;
    private final AccountDetailsRepository accountDetailsRepository;

    private final DoctorDtoMapper doctorDtoMapper;

    @Override
    public DoctorDto setSpecialization(Long doctorId, Long specializationId) {
        Doctor doctor = doctorRepository.findById(doctorId).orElseThrow(DoctorNotFoundException::new);
        Specialization specialization = specializationRepository.findById(specializationId)
                .orElseThrow(SpecializationNotFoundException::new);
        AccountDetails accountDetails = accountDetailsRepository.findById(doctorId)
                .orElseThrow(AccountDetailsNotFoundException::new);
        log.debug("found: doctor -> {}, specialization -> {}, accDetails -> {}", doctor, specialization, accountDetails);
        doctor.setSpecialization(specialization);
        Doctor updatedDoctor = doctorRepository.save(doctor);
        log.info("updated doctor spec -> {}", updatedDoctor);
        return doctorDtoMapper.mapDoctorAndAccDetailsAndSpecializationToDto(updatedDoctor, accountDetails, specialization);
    }
}
