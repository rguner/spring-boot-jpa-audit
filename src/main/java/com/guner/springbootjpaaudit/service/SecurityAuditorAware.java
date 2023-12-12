package com.guner.springbootjpaaudit.service;

import org.springframework.data.domain.AuditorAware;
import org.springframework.stereotype.Service;

import java.util.Optional;


@Service
public class SecurityAuditorAware implements AuditorAware<String> {
 
    @Override
    public Optional<String> getCurrentAuditor() {
        return Optional.of("StaticUser");
    }

}