package com.example.casestudy.dto;

public class AccountDto {
    private int accountId;
    private String username;
    private String password;
    private int roleId;
    private String roles;

    public AccountDto() {
    }

    public AccountDto(int accountId, String username, String password, int roleId, String roles) {
        this.accountId = accountId;
        this.username = username;
        this.password = password;
        this.roleId = roleId;
        this.roles = roles;
    }

    public AccountDto(int accountId, String username, String password, String roles) {
        this.accountId = accountId;
        this.username = username;
        this.password = password;
        this.roles = roles;
    }

    public int getAccountId() {
        return accountId;
    }

    public void setAccountId(int accountId) {
        this.accountId = accountId;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getRoleId() {
        return roleId;
    }

    public void setRoleId(int roleId) {
        this.roleId = roleId;
    }

    public String getRoles() {
        return roles;
    }

    public void setRoles(String roles) {
        this.roles = roles;
    }

    @Override
    public String toString() {
        return "AccountDto{" +
                "accountId=" + accountId +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", roleId=" + roleId +
                ", roles='" + roles + '\'' +
                '}';
    }
}
