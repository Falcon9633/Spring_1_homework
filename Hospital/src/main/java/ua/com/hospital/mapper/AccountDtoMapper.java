package ua.com.hospital.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import ua.com.hospital.dto.AccountDto;
import ua.com.hospital.model.Account;
import ua.com.hospital.model.AccountDetails;
import ua.com.hospital.model.Patient;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

@Mapper(componentModel = "spring")
public interface AccountDtoMapper {
    @Mapping(target = ".", source = "accountDetails")
    @Mapping(target = "password", ignore = true)
    AccountDto mapAccountToDto(Account account);

    @Mapping(source = "account.id", target = "id")
    @Mapping(target = "password", ignore = true)
    AccountDto mapAccountAndAccDetailsAndPatientToDto(Account account, AccountDetails accountDetails, Patient patient);

    List<AccountDto> mapAccountsToDtos(List<Account> accounts);

    Account mapDtoToAccount(AccountDto accountDto);

    AccountDetails mapDtoToAccDetails(AccountDto accountDto);

    @Mapping(target = "birthday", dateFormat = "yyyy-mm-dd")
    Patient mapDtoToPatient(AccountDto accountDto);
}
