package ua.com.hospital.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import ua.com.hospital.dto.AccountDto;
import ua.com.hospital.model.Account;

import java.util.List;

@Mapper(componentModel = "spring")
public interface AccountDtoMapper {
    @Mapping(target = "password", ignore = true)
    AccountDto mapAccountToAccountDto(Account account);

    List<AccountDto> mapAccountToAccountDto(List<Account> accounts);

    Account mapAccountDtoToAccount(AccountDto accountDto);
}
