package com.example.preauth.security;

import com.example.preauth.domain.account.Account;
import com.example.preauth.domain.account.repository.AccountRepository;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.AuthenticationUserDetailsService;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.web.authentication.preauth.PreAuthenticatedAuthenticationToken;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

/**
 * {@link org.springframework.security.web.authentication.preauth.RequestHeaderAuthenticationFilter} 에서 넘겨준 토큰에 담긴 헤더값을 사용하여
 * 사용자 정보를 조회한다.
 */
@Service @RequiredArgsConstructor
public class CustomPreAuthenticationUserDetailService implements AuthenticationUserDetailsService<PreAuthenticatedAuthenticationToken> {

    private final AccountRepository repository;

    @Override
    public UserDetails loadUserDetails(PreAuthenticatedAuthenticationToken token) throws UsernameNotFoundException {
        String name = token.getName();

        if(StringUtils.hasText(name)){
            Account account = repository.findByAccountId(name)
                    .orElseThrow(() -> new UsernameNotFoundException("사용자 정보를 찿을수 없습니다. ["+name+"]"));
            return CustomUser.builder()
                    .roles(account.getAccountType().name())
                    .username(name)
                    .account(account)
                    .build();
        }

        return null;


    }
}
