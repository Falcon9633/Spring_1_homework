package ua.com.hospital.service.impl;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import ua.com.hospital.dto.AccountDto;
import ua.com.hospital.mapper.AccountDtoMapper;
import ua.com.hospital.model.Account;
import ua.com.hospital.repository.AccountRepository;
import ua.com.hospital.service.AccountService;

import java.util.List;

@Service
@Slf4j
@RequiredArgsConstructor
public class AccountServiceImpl implements AccountService {
    private final AccountRepository accountRepository;
    private final AccountDtoMapper accountDtoMapper;

    @Override
    public AccountDto getAccount(Long id) {
        Account account = accountRepository.getById(id);
        return accountDtoMapper.mapAccountToAccountDto(account);
    }

    @Override
    public List<AccountDto> getAllAccounts() {
        List<Account> accounts = accountRepository.getAll();
        return accountDtoMapper.mapAccountToAccountDto(accounts);
    }

    @Override
    public AccountDto createAccount(AccountDto accountDto) {
        Account account = accountDtoMapper.mapAccountDtoToAccount(accountDto);
        log.info("create account -> {}", account);
        return null;
    }

    @Override
    public AccountDto updateAccount(Long id, AccountDto accountDto) {
        return null;
    }

}
