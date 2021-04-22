package ua.com.hospital.controller.model;

import com.fasterxml.jackson.annotation.JsonUnwrapped;
import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.hateoas.RepresentationModel;
import ua.com.hospital.dto.AccountDto;

@Data
@AllArgsConstructor
public class AccountModel extends RepresentationModel<AccountModel> {
    @JsonUnwrapped
    private AccountDto accountDto;
}