package com.example.preauth.configuration;

import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@EnableJpaAuditing(auditorAwareRef = "springSecurityAuditorAware")
public class ApplicationConfiguration {
}
