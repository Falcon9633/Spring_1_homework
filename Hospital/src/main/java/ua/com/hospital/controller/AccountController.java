package ua.com.hospital.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;
import ua.com.hospital.api.AccountApi;
import ua.com.hospital.assembler.AccountAssembler;
import ua.com.hospital.controller.model.AccountModel;
import ua.com.hospital.dto.AccountDto;
import ua.com.hospital.service.AccountService;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@Slf4j
@RequiredArgsConstructor
public class AccountController implements AccountApi {

    private final AccountService accountService;
    private final AccountAssembler accountAssembler;

    @Override
    public AccountModel createAccount(AccountDto accountDto) {
        log.info("createAccount -> {}", accountDto);
        AccountDto account = accountService.createAccount(accountDto);
        return accountAssembler.toModel(account);
    }

    @Override
    public AccountModel getAccount(Long id) {
        log.info("getAccount: id -> {}", id);
        AccountDto account = accountService.getAccount(id);
        return accountAssembler.toModel(account);
    }

    @Override
    public List<AccountModel> getAllAccounts() {
        log.info("getAllAccounts");
        List<AccountDto> accounts = accountService.getAllAccounts();
        return accounts.stream().map(accountAssembler::toModel).collect(Collectors.toList());
    }

    @Override
    public AccountModel updateAccount(Long id, AccountDto accountDto) {
        log.info("updateAccount: id -> {}", id);
        AccountDto account = accountService.updateAccount(id, accountDto);
        return accountAssembler.toModel(account);
    }
}