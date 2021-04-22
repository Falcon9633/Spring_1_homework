package ua.com.hospital.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import ua.com.hospital.assembler.AccountAssembler;
import ua.com.hospital.controller.model.AccountModel;
import ua.com.hospital.dto.AccountDto;
import ua.com.hospital.service.AccountService;

import javax.validation.Valid;
import javax.validation.constraints.Min;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@Slf4j
@RequiredArgsConstructor
public class AccountController implements ua.com.hospital.api.AccountAPI {

    private final AccountService accountService;
    private final AccountAssembler accountAssembler;

    @Override
    public AccountModel createAccount(AccountDto accountDto) {
        log.info("create account -> {}", accountDto);
        AccountDto account = accountService.createAccount(accountDto);
        return accountAssembler.toModel(account);
    }

    @Override
    public AccountModel getAccount(Long id) {
        log.info("get account: id -> {}", id);
        AccountDto account = accountService.getAccount(id);
        return accountAssembler.toModel(account);
    }

    @Override
    public List<AccountModel> getAllAccounts() {
        log.info("get all accounts");
        List<AccountDto> accounts = accountService.getAllAccounts();
        return accounts.stream().map(accountAssembler::toModel).collect(Collectors.toList());
    }



    @Override
    public AccountDto updateAccount(Long id, AccountDto accountDto) {
        log.info("update account: id -> {}, account -> {}", id, accountDto);
        return accountService.updateAccount(id, accountDto);
    }
}