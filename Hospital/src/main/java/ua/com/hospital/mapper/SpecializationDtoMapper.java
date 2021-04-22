package ua.com.hospital.mapper;

import org.mapstruct.BeanMapping;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;
import org.mapstruct.NullValuePropertyMappingStrategy;
import ua.com.hospital.dto.SpecializationDto;
import ua.com.hospital.model.Specialization;

@Mapper(componentModel = "spring")
public interface SpecializationDtoMapper {

    SpecializationDto mapSpecToDto(Specialization specialization);

    Specialization mapDtoToSpec(SpecializationDto specializationDto);

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    void updateSpecializationFromDto(SpecializationDto specializationDto, @MappingTarget Specialization specialization);
}
