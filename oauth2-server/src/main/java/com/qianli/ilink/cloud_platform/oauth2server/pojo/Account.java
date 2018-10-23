package com.qianli.ilink.cloud_platform.oauth2server.pojo;

public class Account {
    private String accountId;
    private String username;
    private String accountName;
    private String password;

    public String getAccountId() {
        return accountId;
    }

    public void setAccountId(String accountId) {
        this.accountId = accountId;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getAccountName() {
        return accountName;
    }

    public void setAccountName(String accountName) {
        this.accountName = accountName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Account(){}

    public Account(String accountId, String username,String password, String accountName) {
        this.accountId = accountId;
        this.username = username;
        this.password = password;
        this.accountName = accountName;
    }
}
