package com.company.accountservice.service;

import com.company.accountservice.dto.AccountDto;
import com.company.accountservice.entity.Account;
import com.company.accountservice.model.AccountPageModel;
import com.company.accountservice.respository.AccountRepository;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.data.cassandra.core.query.CassandraPageRequest;
import org.springframework.data.domain.Slice;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Service
public class AccountServiceImpl implements AccountService {
    private final AccountRepository accountRepository;
    private final ModelMapper mapper;

    @Override
    public AccountPageModel getAll(Integer page, Integer pageSize) {
        Slice<Account> pageData = accountRepository.findAll(
                CassandraPageRequest.of(page, pageSize)
        );

        List<AccountDto> accounts = pageData.getContent().stream().map(account -> new AccountDto(account.getId(),
                account.getUsername(),
                account.getName(),
                account.getSurname(),
                account.getEmail(),
                account.getBirthDate())).collect(Collectors.toList());

        AccountPageModel pageModel = new AccountPageModel();
        pageModel.setAccounts(accounts);
        pageModel.setPage(pageData.getNumber());
        pageModel.setPageSize(pageData.getSize());
        pageModel.setLast(pageData.isLast());
        pageModel.setTotalCount(pageData.getNumberOfElements());

        return pageModel;
    }

    @Override
    public AccountDto get(String id) {
        return mapper.map(accountRepository.findById(id).orElse(null), AccountDto.class);
    }

    @Override
    public AccountDto save(AccountDto accountDto) {
        Account account = mapper.map(accountDto, Account.class);
        account = accountRepository.save(account);
        accountDto.setId(account.getId());
        return accountDto;
    }

    @Override
    public AccountDto update(String id, AccountDto accountDto) {
        Account foundAccount = accountRepository.findById(id).orElseThrow(IllegalArgumentException::new);
        foundAccount.setEmail(accountDto.getEmail());
        foundAccount.setName(accountDto.getName());
        foundAccount.setSurname(accountDto.getSurname());
        foundAccount.setBirthDate(accountDto.getBirthDate());
        foundAccount.setUsername(accountDto.getUsername());
        return mapper.map(accountRepository.save(foundAccount), AccountDto.class);
    }

    @Override
    public void delete(String id) {
        Account account = accountRepository.findById(id).orElseThrow(IllegalArgumentException::new);
        accountRepository.delete(account);
    }
}
