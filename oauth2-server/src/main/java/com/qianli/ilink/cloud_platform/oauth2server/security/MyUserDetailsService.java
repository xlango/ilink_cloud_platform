package com.qianli.ilink.cloud_platform.oauth2server.security;

import com.qianli.ilink.cloud_platform.oauth2server.pojo.Account;
import com.qianli.ilink.cloud_platform.oauth2server.pojo.UserPrincipal;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

/**
 * 校验用户有效性
 */
@Component
public class MyUserDetailsService implements UserDetailsService {

    @Autowired
    private PasswordEncoder passwordEncoder;

    private final Set<Account> users = new HashSet<>();

    @PostConstruct
    public void init(){
        users.add(new Account("10001","yanghao7",passwordEncoder.encode(""),"杨浩"));
        users.add(new Account("10002","liyq5",passwordEncoder.encode(""),"李逸群"));
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Optional<Account> accountOptional = users.stream()
                .filter((account) -> account.getUsername().equals(username))
                .findFirst();
        if (!accountOptional.isPresent()) {
            throw new UsernameNotFoundException("there's no user founded!");
        }
        else {
            return UserDetailConverter.convert(accountOptional.get());
        }
    }


    private static class UserDetailConverter {
        static UserDetails convert(Account account) {
            UserPrincipal userPrincipal = new UserPrincipal(account);
            return userPrincipal;
        }
    }
}
