package com.example.casestudy.service.impl;


import com.example.casestudy.dto.AccountDto;
import com.example.casestudy.model.Account;
import com.example.casestudy.model.Role;
import com.example.casestudy.repository.IAccountRepository;
import com.example.casestudy.repository.impl.AccountRepository;
import com.example.casestudy.service.IAccountService;

import java.util.List;

public class AccountService implements IAccountService {
    private final IAccountRepository accountRepository = new AccountRepository();
    @Override
    public void insertAccount(Account account) {
        accountRepository.insertAccount(account);
    }

    @Override
    public Account selectAccount(int id) {
        return accountRepository.selectAccount(id);
    }

    @Override
    public List<AccountDto> selectAllAccount() {
        return accountRepository.selectAllAccount();
    }

    @Override
    public boolean deleteAccount(int id) {
        return accountRepository.deleteAccount(id);
    }

    @Override
    public boolean updateAccount(Account account) {
        return accountRepository.updateAccount(account);
    }

    @Override
    public List<Role> selectRole() {
        return accountRepository.selectRole();
    }

    @Override
    public int selectIdAccount(String username) {
        return accountRepository.selectIdAccount(username);
    }

    @Override
    public Account check(String username, String password) {
        return accountRepository.check(username,password);
    }

    @Override
    public boolean deleteAccountByUsername(String username) {
        return accountRepository.deleteAccountByUsername(username);
    }
}
