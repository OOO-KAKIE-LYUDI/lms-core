package com.lms.core.controller;

import com.lms.auth.model.dto.RegisterUserDto;
import com.lms.auth.model.dto.UserDto;
import com.lms.auth.security.LmsAuthenticationManager;
import com.lms.auth.service.AuthService;
import com.lms.auth.service.UserService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequestMapping("/api/auth")
@CrossOrigin(origins = "*")
@RequiredArgsConstructor
public class AuthController {
    private final AuthService authService;
    private final UserService userService;
    private final LmsAuthenticationManager lmsAuthenticationManager;

    @PostMapping("/login")
    public ResponseEntity<UserDto> login(@RequestHeader String email,
                                         @RequestHeader String password) {
        try {

            lmsAuthenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(email, password));

            String jwt = authService.login(email, password);
            var user = userService.getUserByEmail(email);

            return ResponseEntity.ok()
                    .header(HttpHeaders.AUTHORIZATION, jwt)
                    .body(user);
        } catch (RuntimeException ex) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
        }
    }

    @PostMapping("/register")
    public ResponseEntity<?> register(@RequestBody RegisterUserDto user,
                                      @RequestHeader String email, @RequestHeader String password) {

        return ResponseEntity.ok(authService.register(user, email, password));
    }
}
