package ua.com.hospital.repository.impl;

import org.springframework.stereotype.Component;
import ua.com.hospital.model.Account;
import ua.com.hospital.model.Role;
import ua.com.hospital.repository.AccountRepository;

import java.util.ArrayList;
import java.util.List;

@Component
public class AccountRepositoryImpl implements AccountRepository {
    @Override
    public Account getById(Long id) {
        Account account = new Account();
        account.setEmail("email1");
        account.setId(12L);
        account.setLocked(false);
        account.setPassword("pass");
        account.setLogin("login1");
        account.setRole(Role.ADMIN);
        return account;
    }

    @Override
    public List<Account> getAll() {
        List<Account> accounts = new ArrayList<>();
        accounts.add(getById(10L));
        accounts.add(getById(10L));
        return accounts;
    }

    @Override
    public Account create(Account account) {
        return null;
    }

    @Override
    public Account updateAccount(Account account) {
        return null;
    }
}
