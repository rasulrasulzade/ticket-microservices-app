package com.company.accountservice.service;

import com.company.accountservice.entity.Account;
import com.company.accountservice.respository.AccountRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service
public class AccountServiceImpl implements AccountService{
    private final AccountRepository accountRepository;

    @Override
    public List<Account> getAll() {
        return accountRepository.findAll();
    }

    @Override
    public Account get(String id) {
        return accountRepository.findById(id).orElse(null);
    }

    @Override
    public Account save(Account account) {
        return accountRepository.save(account);
    }

    @Override
    public Account update(String id, Account account) {
        Account foundAccount = accountRepository.findById(id).orElseThrow(IllegalArgumentException::new);
        foundAccount.setEmail(account.getEmail());
        foundAccount.setName(account.getName());
        foundAccount.setSurname(account.getSurname());
        foundAccount.setBirthDate(account.getBirthDate());
        foundAccount.setUsername(account.getUsername());
        foundAccount.setPassword(account.getPassword());
        return accountRepository.save(foundAccount);
    }

    @Override
    public void delete(String id) {
        accountRepository.deleteById(id);
    }
}
