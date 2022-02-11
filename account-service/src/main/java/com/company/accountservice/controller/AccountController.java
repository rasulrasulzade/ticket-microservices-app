package com.company.accountservice.controller;

import com.company.accountservice.dto.AccountDto;
import com.company.accountservice.model.AccountPageModel;
import com.company.accountservice.service.AccountService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Optional;

@RequiredArgsConstructor
@RestController
@RequestMapping("/accounts")
public class AccountController {
    private final AccountService accountService;

    @GetMapping()
    public ResponseEntity<AccountPageModel> getAll(@RequestParam Optional<Integer> page, @RequestParam Optional<Integer> pageSize) {
        AccountPageModel pageModel = accountService.getAll(page.orElse(0), pageSize.orElse(10));
        return ResponseEntity.ok(pageModel);
    }

    @PostMapping
    public AccountDto save(@Valid @RequestBody AccountDto accountDto) {
        return accountService.save(accountDto);
    }

    @GetMapping("/{id}")
    public AccountDto getById(@PathVariable String id) {
        return accountService.get(id);
    }

    @PutMapping("/{id}")
    public AccountDto update(@PathVariable String id, @Valid @RequestBody AccountDto accountDto) {
        if (id == null) {
            throw new IllegalArgumentException("Id cannot be null");
        }
        return accountService.update(id, accountDto);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable String id) {
        accountService.delete(id);
    }

}
