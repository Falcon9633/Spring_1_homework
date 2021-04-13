package ua.com.hospital.service;

import ua.com.hospital.dto.AccountDto;

import java.util.List;

public interface AccountService {
    AccountDto getAccount(Long id);

    AccountDto createAccount(AccountDto accountDto);

    AccountDto updateAccount(Long id, AccountDto accountDto);

    List<AccountDto> getAllAccounts();

}
