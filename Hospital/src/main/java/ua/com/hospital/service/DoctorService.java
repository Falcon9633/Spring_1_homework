package ua.com.hospital.service;

import ua.com.hospital.dto.DoctorDto;

public interface DoctorService {
    DoctorDto setSpecialization(Long doctorId, Long specializationId);
}
