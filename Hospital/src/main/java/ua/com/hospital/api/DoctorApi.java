package ua.com.hospital.api;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.http.HttpStatus;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import ua.com.hospital.controller.model.DoctorModel;

import javax.validation.constraints.Min;

@Api("Doctor management API")
@RequestMapping("/api/v1/doctors")
@Validated
public interface DoctorApi {
    @ApiOperation("set specialization to doctor")
    @PutMapping("/{doctorId}/specialization/{specId}")
    @ResponseStatus(HttpStatus.OK)
    DoctorModel setSpecialization(@PathVariable @Min(1) Long doctorId, @PathVariable @Min(1) Long specId);
}
