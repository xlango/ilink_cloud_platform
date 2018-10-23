package com.qianli.ilink.cloud_platform.oauth2server.pojo;

import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.User;


public class UserPrincipal extends User {

    private static final long serialVersionUID = 1L;

    private String accountId;
    private String token;

    public UserPrincipal(Account account) {
        super(account.getUsername(), account.getPassword(), AuthorityUtils.commaSeparatedStringToAuthorityList("ROLE_USER"));
    }


    public String getAccountId() {
        return accountId;
    }

    public void setAccountId(String accountId) {
        this.accountId = accountId;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }


}
