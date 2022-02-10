package com.company.accountservice.model;

import com.company.accountservice.dto.AccountDto;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class AccountPageModel {
    private List<AccountDto> accounts;
    private int page;
    private int pageSize;
    private boolean isLast;
    private long totalCount;
}
