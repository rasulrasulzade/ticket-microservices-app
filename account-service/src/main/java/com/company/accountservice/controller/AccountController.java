package com.company.accountservice.controller;

import com.company.accountservice.entity.Account;
import com.company.accountservice.service.AccountService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/accounts")
public class AccountController {
    private final AccountService accountService;

    public AccountController(AccountService accountService) {
        this.accountService = accountService;
    }

    @GetMapping()
    public List<Account> getAll(){
        //TODO add pagination
        return accountService.getAll();
    }

    @PostMapping
    public Account save(@RequestBody Account account){
        //TODO check account if not valid throw exception
        return accountService.save(account);
    }

    @GetMapping("/{id}")
    public Account getById(@PathVariable String id){
        //TODO check id if null throw exception
        return accountService.get(id);
    }

    @PutMapping("/{id}")
    public Account update(@PathVariable String id, @RequestBody Account account){
        //TODO check id if null throw exception
        //TODO check account if not valid throw exception
        return accountService.update(id, account);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable String id){
        //TODO check id if null throw exception
        accountService.delete(id);
    }

}
