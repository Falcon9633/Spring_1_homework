package ua.com.hospital.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import ua.com.hospital.dto.DoctorDto;
import ua.com.hospital.model.AccountDetails;
import ua.com.hospital.model.Doctor;
import ua.com.hospital.model.Specialization;

@Mapper(componentModel = "spring")
public interface DoctorDtoMapper {
    @Mapping(source = "doctor.id", target = "id")
    @Mapping(source = "accountDetails.name", target = "name")
    @Mapping(source = "specialization.id", target = "specializationId")
    @Mapping(source = "specialization.name", target = "specializationName")
    DoctorDto mapDoctorAndAccDetailsAndSpecializationToDto(Doctor doctor,
                                                           AccountDetails accountDetails,
                                                           Specialization specialization);
}
