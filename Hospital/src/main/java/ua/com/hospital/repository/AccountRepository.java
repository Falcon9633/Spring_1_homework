package ua.com.hospital.repository;

import ua.com.hospital.model.Account;

import java.util.List;

public interface AccountRepository {
    Account getById(Long id);

    List<Account> getAll();

    Account create(Account account);

    Account updateAccount(Account account);
}
