package ua.com.hospital.api;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.http.HttpStatus;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import ua.com.hospital.controller.model.AccountModel;
import ua.com.hospital.dto.AccountDto;
import ua.com.hospital.validator.OnPatch;
import ua.com.hospital.validator.OnPost;

import javax.validation.Valid;
import javax.validation.constraints.Min;
import java.util.List;

@Api("Account management API")
@RequestMapping("/api/v1/accounts")
@Validated
public interface AccountApi {
    @ApiOperation("create account")
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    @Validated(OnPost.class)
    AccountModel createAccount(@Valid @RequestBody AccountDto accountDto);

    @ApiOperation("get account")
    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    AccountModel getAccount(@PathVariable @Min(1) Long id);

    @ApiOperation("get all accounts")
    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    List<AccountModel> getAllAccounts();

    @ApiOperation("update account")
    @PatchMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    @Validated(OnPatch.class)
    AccountModel updateAccount(@PathVariable @Min(1) Long id, @Valid @RequestBody AccountDto accountDto);
}
