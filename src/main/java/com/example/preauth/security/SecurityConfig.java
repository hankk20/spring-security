package com.example.preauth.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.security.web.authentication.preauth.PreAuthenticatedAuthenticationProvider;
import org.springframework.security.web.authentication.preauth.RequestHeaderAuthenticationFilter;

@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    public static final String SECURITY_HEADER = "Authentication";
    public static final String ROLE_ANONYMOUS = "ANONYMOUS";

    private CustomPreAuthenticationUserDetailService customPreAuthenticationUserDetailService;

    @Autowired
    public void setCustomPreAuthenticationUserDetailService(CustomPreAuthenticationUserDetailService customPreAuthenticationUserDetailService) {
        this.customPreAuthenticationUserDetailService = customPreAuthenticationUserDetailService;
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests()
                .anyRequest()
                .authenticated()
                .and()
                .addFilterAt(requestHeaderAuthenticationFilter(), RequestHeaderAuthenticationFilter.class);
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.authenticationProvider(preAuthenticatedAuthenticationProvider());
    }

    public RequestHeaderAuthenticationFilter requestHeaderAuthenticationFilter() throws Exception {
        RequestHeaderAuthenticationFilter requestHeaderAuthenticationFilter = new RequestHeaderAuthenticationFilter();
        requestHeaderAuthenticationFilter.setPrincipalRequestHeader(SECURITY_HEADER);
        requestHeaderAuthenticationFilter.setAuthenticationManager(authenticationManager());
        requestHeaderAuthenticationFilter.setContinueFilterChainOnUnsuccessfulAuthentication(false); //실패시 계속 진행 여부
        return requestHeaderAuthenticationFilter;
    }

    public PreAuthenticatedAuthenticationProvider preAuthenticatedAuthenticationProvider(){
        PreAuthenticatedAuthenticationProvider preAuthenticatedAuthenticationProvider = new PreAuthenticatedAuthenticationProvider();
        preAuthenticatedAuthenticationProvider.setPreAuthenticatedUserDetailsService(customPreAuthenticationUserDetailService);
        return preAuthenticatedAuthenticationProvider;
    }

}
