package com.company.accountservice.service;

import com.company.accountservice.entity.Account;

import java.util.List;

public interface AccountService {
     List<Account> getAll();

     Account get(String id);

     Account save(Account account);

     Account update(String id, Account account);

     void delete(String id);
}
