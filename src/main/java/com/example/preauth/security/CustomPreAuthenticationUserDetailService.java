package com.example.preauth.security;

import com.example.preauth.account.domain.Account;
import com.example.preauth.account.repository.AccountRepository;
import lombok.AllArgsConstructor;
import org.springframework.security.core.userdetails.AuthenticationUserDetailsService;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.web.authentication.preauth.PreAuthenticatedAuthenticationToken;
import org.springframework.security.web.authentication.preauth.PreAuthenticatedGrantedAuthoritiesUserDetailsService;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.Optional;

@Service @AllArgsConstructor
public class CustomPreAuthenticationUserDetailService implements AuthenticationUserDetailsService<PreAuthenticatedAuthenticationToken> {

    private final AccountRepository repository;

    @Override
    public UserDetails loadUserDetails(PreAuthenticatedAuthenticationToken token) throws UsernameNotFoundException {
        String name = token.getName();
        if(StringUtils.hasText(name)){
            Account account = repository.findByAccountId(name)
                    .orElseThrow(() -> new UsernameNotFoundException("사용자 정보를 찿을수 없습니다."));
            return User.builder()
                    .roles(account.getAccountType().name())
                    .username(token.getName())
                    .build();
        }

        return User.builder()
                .roles(SecurityConfig.ROLE_ANONYMOUS)
                .username("GUEST")
                .build();


    }
}
