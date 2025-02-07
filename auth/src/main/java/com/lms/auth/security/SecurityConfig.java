package com.lms.auth.security;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;

import static com.lms.auth.model.enums.Role.ADMINISTRATOR;
import static com.lms.auth.model.enums.Role.TEACHER;

@Configuration
@EnableWebSecurity
@RequiredArgsConstructor
public class SecurityConfig {

    private final LmsAuthenticationManager lmsAuthenticationManager;
    private final UserDetailsService userDetailsService;
    private final PasswordEncoder passwordEncoder;

    @Value("${allowed-origin}")
    private String allowedOrigin;

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http, JwtAuthFilter jwtAuthFilter) throws Exception {
        http.cors(Customizer.withDefaults())
                .csrf().disable()
                .authorizeHttpRequests(authorizeRequests ->
                                authorizeRequests
                                        .requestMatchers(HttpMethod.OPTIONS, "/**").permitAll()
                                        .requestMatchers("/api/auth/**").permitAll()
                                        .requestMatchers("/api/algo/**").permitAll()
                                        .requestMatchers("/ws/**").permitAll()
                                        .requestMatchers("/swagger-ui").permitAll()
                                        .requestMatchers("/v3/api-docs").permitAll()

                                        .requestMatchers(HttpMethod.POST, "/api/categories/**").hasAuthority(ADMINISTRATOR.name())
                                        .requestMatchers(HttpMethod.DELETE, "/api/categories/**").hasAuthority(ADMINISTRATOR.name())
                                        .requestMatchers(HttpMethod.PATCH, "/api/categories/**").hasAuthority(ADMINISTRATOR.name())
                                        .requestMatchers(HttpMethod.PUT, "/api/categories/**").hasAuthority(ADMINISTRATOR.name())

                                        .requestMatchers(HttpMethod.POST, "/api/attachments/**").hasAnyAuthority(TEACHER.name(), ADMINISTRATOR.name())
                                        .requestMatchers(HttpMethod.DELETE, "/api/attachments/**").hasAnyAuthority(TEACHER.name(), ADMINISTRATOR.name())
                                        .requestMatchers(HttpMethod.PATCH, "/api/attachments/**").hasAnyAuthority(TEACHER.name(), ADMINISTRATOR.name())
                                        .requestMatchers(HttpMethod.PUT, "/api/attachments/**").hasAnyAuthority(TEACHER.name(), ADMINISTRATOR.name())

                                        .requestMatchers(HttpMethod.POST, "/api/chapters/**").hasAnyAuthority(TEACHER.name(), ADMINISTRATOR.name())
                                        .requestMatchers(HttpMethod.DELETE, "/api/chapters/**").hasAnyAuthority(TEACHER.name(), ADMINISTRATOR.name())
                                        .requestMatchers(HttpMethod.PATCH, "/api/chapters/**").hasAnyAuthority(TEACHER.name(), ADMINISTRATOR.name())
                                        .requestMatchers(HttpMethod.PUT, "/api/chapters/**").hasAnyAuthority(TEACHER.name(), ADMINISTRATOR.name())

                                        .requestMatchers(HttpMethod.POST, "/api/courses/**").hasAnyAuthority(TEACHER.name(), ADMINISTRATOR.name())
                                        .requestMatchers(HttpMethod.DELETE, "/api/courses/**").hasAnyAuthority(TEACHER.name(), ADMINISTRATOR.name())
                                        .requestMatchers(HttpMethod.PATCH, "/api/courses/**").hasAnyAuthority(TEACHER.name(), ADMINISTRATOR.name())
                                        .requestMatchers(HttpMethod.PUT, "/api/courses/**").hasAnyAuthority(TEACHER.name(), ADMINISTRATOR.name())

//                                TODO: TO DO
                                        .requestMatchers(HttpMethod.POST, "/api/enrollments/**").hasAnyAuthority(TEACHER.name(), ADMINISTRATOR.name())
                                        .requestMatchers(HttpMethod.DELETE, "/api/enrollments/**").hasAnyAuthority(TEACHER.name(), ADMINISTRATOR.name())
                                        .requestMatchers(HttpMethod.PATCH, "/api/enrollments/**").hasAnyAuthority(TEACHER.name(), ADMINISTRATOR.name())
                                        .requestMatchers(HttpMethod.PUT, "/api/enrollments/**").hasAnyAuthority(TEACHER.name(), ADMINISTRATOR.name())

                                        .anyRequest().authenticated()
                ).httpBasic(Customizer.withDefaults())
                .sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS)
                .and()
                .authenticationManager(lmsAuthenticationManager)
                .addFilterBefore(jwtAuthFilter, UsernamePasswordAuthenticationFilter.class)
                .httpBasic(Customizer.withDefaults());

        return http.build();
    }

    @Bean
    public AuthenticationProvider authenticationProvider() {
        final DaoAuthenticationProvider authenticationProvider = new DaoAuthenticationProvider();
        authenticationProvider.setUserDetailsService(userDetailsService);
        authenticationProvider.setPasswordEncoder(passwordEncoder);

        return authenticationProvider;
    }

    @Bean
    CorsConfigurationSource corsConfigurationSource() {
        CorsConfiguration configuration = new CorsConfiguration();
        configuration.setAllowCredentials(true);
        configuration.addAllowedOrigin(allowedOrigin);
        configuration.addAllowedHeader("*");
        configuration.addAllowedMethod("*");
        UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
        source.registerCorsConfiguration("/**", configuration);
        return source;
    }
}
