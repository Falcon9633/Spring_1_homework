package ua.com.hospital.api;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.http.HttpStatus;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import ua.com.hospital.controller.model.SpecializationModel;
import ua.com.hospital.dto.SpecializationDto;

import javax.validation.Valid;
import javax.validation.constraints.Min;

@Api("Specialization management API")
@RequestMapping("/api/v1/specializations")
@Validated
public interface SpecializationApi {
    @ApiOperation("create specialization")
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    SpecializationModel createSpecialization(@Valid @RequestBody SpecializationDto specializationDto);

    @ApiOperation("get specialization")
    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    SpecializationModel getSpecialization(@PathVariable @Min(1) Long id);

    @ApiOperation("update specialization")
    @PatchMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    SpecializationModel updateSpecialization(@PathVariable @Min(1) Long id,
                                             @Valid @RequestBody SpecializationDto specializationDto);
}
