package com.lms.auth.security;

import com.lms.auth.service.impl.AuthServiceImpl;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

@Component
public class LmsAuthenticationManager implements AuthenticationManager {
    private AuthServiceImpl customUserDetailsService;
    private PasswordEncoder passwordEncoder;

    @Override
    public Authentication authenticate(Authentication authentication) throws AuthenticationException {
        UserDetails userDetail = customUserDetailsService.loadUserByUsername(authentication.getName());
        if (!passwordEncoder.matches(authentication.getCredentials().toString(), userDetail.getPassword())) {
            throw new BadCredentialsException("Wrong password");
        }

        return new UsernamePasswordAuthenticationToken(userDetail.getUsername(),
                userDetail.getPassword(), userDetail.getAuthorities());
    }
}
