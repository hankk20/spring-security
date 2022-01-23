package com.example.preauth;

import com.example.preauth.security.CustomPreAuthenticationUserDetailService;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.test.context.support.WithSecurityContextFactory;
import org.springframework.security.test.context.support.WithUserDetails;
import org.springframework.security.web.authentication.preauth.PreAuthenticatedAuthenticationToken;
import org.springframework.util.Assert;

import java.lang.annotation.Annotation;

public class CustomWithSecurityContext implements WithSecurityContextFactory<WithRequestHeaderUser> {

    private static final String beanName = "customPreAuthenticationUserDetailService";
    private BeanFactory beans;

    @Autowired
    CustomWithSecurityContext(BeanFactory beans) {
        this.beans = beans;
    }

    @Override
    public SecurityContext createSecurityContext(WithRequestHeaderUser withUser) {
        CustomPreAuthenticationUserDetailService userDetailService = beans.getBean(CustomPreAuthenticationUserDetailService.class);
        String username = withUser.value();
        Assert.hasLength(username, "value() must be non empty String");
        UserDetails principal = userDetailService.loadUserDetails(new PreAuthenticatedAuthenticationToken(username, null));
        Authentication authentication = new PreAuthenticatedAuthenticationToken(principal, principal.getPassword(),
                principal.getAuthorities());
        SecurityContext context = SecurityContextHolder.createEmptyContext();
        context.setAuthentication(authentication);
        return context;
    }

}
