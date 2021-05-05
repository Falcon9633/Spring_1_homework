package ua.com.hospital.service;

import org.springframework.transaction.annotation.Transactional;
import ua.com.hospital.dto.AccountDto;

import java.util.List;

public interface AccountService {
    @Transactional
    AccountDto createAccount(AccountDto accountDto);

    AccountDto getAccount(Long id);

    List<AccountDto> getAllAccounts();

    @Transactional
    AccountDto updateAccount(Long id, AccountDto accountDto);
}
