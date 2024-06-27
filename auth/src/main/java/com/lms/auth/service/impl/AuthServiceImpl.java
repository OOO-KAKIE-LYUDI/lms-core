package com.lms.auth.service.impl;

import com.lms.auth.exception.LmsAuthConflictException;
import com.lms.auth.exception.LmsAuthNotFoundException;
import com.lms.auth.model.dto.RegisterUserDto;
import com.lms.auth.model.dto.UserDto;
import com.lms.auth.model.mapper.UserMapper;
import com.lms.auth.repository.UserRepository;
import com.lms.auth.service.AuthService;
import com.lms.auth.tool.JwtUtils;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Slf4j
@Service
@RequiredArgsConstructor
public class AuthServiceImpl implements AuthService, UserDetailsService {

    @Autowired
    private UserRepository userRepository;
    @Autowired
    private JwtUtils jwtUtils;
    @Autowired
    private UserMapper userMapper;
    @Autowired
    private PasswordEncoder passwordEncoder;

    @Override
    public String login(String email, String password) {
        UserDetails user = loadUserByUsername(email);
//        if (!Objects.equals(passwordEncoder.encode(user.getPassword()), password)) {
//            throw new LmsAuthUnauthorizedException("Адрес электронной почты или пароль введены неверно. Попробуйте еще раз!");
//        }

        return jwtUtils.generateToken(user);
    }

    @Override
    public UserDto register(RegisterUserDto userDto, String email, String password) {
        if (userRepository.findUserByEmail(email).isPresent()) {
            throw new LmsAuthConflictException("Пользователь с почтовым адресом %s уже зарегистрирован в системе!".formatted(email));
        }

        var userEntity = userMapper.createUser(userDto, email, password);
        userEntity.setPassword(passwordEncoder.encode(password));

        userRepository.save(userEntity);
        return userMapper.createGetUserDto(userEntity);
    }

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        var user = userRepository.findUserByEmail(email)
                .orElseThrow(() -> new LmsAuthNotFoundException("Пользователь с email = <%s> не найден".formatted(email)));
        List<SimpleGrantedAuthority> authorities = new ArrayList<>();
        authorities.add(new SimpleGrantedAuthority(user.getRole().toString()));
        return new User(user.getEmail(), user.getPassword(), authorities);
    }
}
