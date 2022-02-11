package com.company.accountservice.service;

import com.company.accountservice.dto.AccountDto;
import com.company.accountservice.model.AccountPageModel;

public interface AccountService {
     AccountPageModel getAll(Integer page, Integer pageSize);

     AccountDto get(String id);

     AccountDto save(AccountDto account);

     AccountDto update(String id, AccountDto account);

     void delete(String id);
}
