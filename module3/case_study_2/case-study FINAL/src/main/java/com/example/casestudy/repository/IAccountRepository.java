package com.example.casestudy.repository;


import com.example.casestudy.dto.AccountDto;
import com.example.casestudy.model.Account;
import com.example.casestudy.model.Role;

import java.util.List;

public interface IAccountRepository {
    void insertAccount(Account account);

    Account selectAccount(int id);

    List<AccountDto> selectAllAccount();

    boolean deleteAccount(int id);
    boolean deleteAccountByUsername(String username);

    boolean updateAccount(Account account);
    List<Role> selectRole();
    int selectIdAccount(String username);
     Account check(String username, String password);

}
