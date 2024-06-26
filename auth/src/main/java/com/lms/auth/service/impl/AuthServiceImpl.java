package com.lms.auth.service.impl;

import com.lms.auth.model.dto.UserDto;
import com.lms.auth.model.entity.UserEntity;
import com.lms.auth.model.mapper.UserMapper;
import com.lms.auth.repository.UserRepository;
import com.lms.auth.service.AuthService;
import com.lms.auth.tool.JwtUtils;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class AuthServiceImpl implements AuthService, UserDetailsService {

    private UserRepository userRepository;
    private JwtUtils jwtUtils;
    private UserMapper userMapper;
    private PasswordEncoder passwordEncoder;

    @Override
    public String login(String username) {
        return null;
    }

    @Override
    public UserEntity register(UserDto userDto, String username, String password) {
        return null;
    }

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        UserEntity user = userRepository.findUserByEmail(email);
        List<SimpleGrantedAuthority> authorities = new ArrayList<>();
        authorities.add(new SimpleGrantedAuthority(user.getRole().toString()));
        return new User(user.getEmail(), user.getPassword(), authorities);
    }
}
