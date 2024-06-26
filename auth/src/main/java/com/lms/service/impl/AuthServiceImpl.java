package com.lms.service.impl;

import com.lms.model.dto.UserDto;
import com.lms.model.entity.UserEntity;
import com.lms.model.mapper.UserMapper;
import com.lms.repository.UserRepository;
import com.lms.service.AuthService;
import com.lms.tool.JwtUtils;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.security.core.userdetails.User;

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
