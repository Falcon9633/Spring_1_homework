package ua.com.hospital.assembler;

import org.springframework.hateoas.Link;
import org.springframework.hateoas.server.mvc.RepresentationModelAssemblerSupport;
import org.springframework.hateoas.server.mvc.WebMvcLinkBuilder;
import org.springframework.stereotype.Component;
import ua.com.hospital.controller.AccountController;
import ua.com.hospital.controller.model.AccountModel;
import ua.com.hospital.dto.AccountDto;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.*;

@Component
public class AccountAssembler extends RepresentationModelAssemblerSupport<AccountDto, AccountModel> {

    public AccountAssembler() {
        super(AccountController.class, AccountModel.class);
    }

    @Override
    public AccountModel toModel(AccountDto entity) {
        AccountModel accountModel = new AccountModel(entity);
        Link create = linkTo(methodOn(AccountController.class).createAccount(entity)).withRel("createAccount");
        Link get = linkTo(methodOn(AccountController.class).getAccount(entity.getId())).withRel("getAccount");
        Link getAll = linkTo(methodOn(AccountController.class).getAllAccounts()).withRel("getAllAccounts");
//        Link update = WebMvcLinkBuilder.linkTo(WebMvcLinkBuilder.methodOn(AccountController.class)
//                .updateAccount(entity.getId(), )).withRel("updateAccount");
        accountModel.add(create, get, getAll);
        return accountModel;
    }
}
