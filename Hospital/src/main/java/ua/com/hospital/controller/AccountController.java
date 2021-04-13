package ua.com.hospital.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import ua.com.hospital.dto.AccountDto;
import ua.com.hospital.service.AccountService;

import javax.validation.Valid;
import javax.validation.constraints.Min;
import java.util.List;

@RestController
@RequestMapping("/accounts")
@Slf4j
@RequiredArgsConstructor
@Validated
public class AccountController {

    private final AccountService accountService;

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public AccountDto getAccount(@PathVariable @Min(1) Long id) {
        return accountService.getAccount(id);
    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<AccountDto> getAllAccounts(){
        return accountService.getAllAccounts();
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public AccountDto createAccount(@Valid @RequestBody AccountDto accountDto) {
        log.info("create account -> {}", accountDto);
        return accountService.createAccount(accountDto);
    }

    @PatchMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public AccountDto updateAccount(@PathVariable @Min(1) Long id, @RequestBody AccountDto accountDto){
        log.info("update account -> {}", accountDto);
        return accountService.updateAccount(id, accountDto);
    }
}