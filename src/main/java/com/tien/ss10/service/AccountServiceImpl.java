package com.tien.ss10.service;

import com.tien.ss10.model.Account;
import com.tien.ss10.repository.AccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AccountServiceImpl implements AccountService {

    @Autowired
    private AccountRepository accountRepository;

    @Override
    public boolean save(Account account) {
        return accountRepository.save(account);
    }
}
