package com.proyectosjuan.libreria.config;


import com.proyectosjuan.libreria.filter.JwtAuthenticationFilter;
import com.proyectosjuan.libreria.filter.JwtAuthorizationFilter;
import com.proyectosjuan.libreria.util.JwtUtil;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http, JwtUtil jwtUtil) throws Exception {
        http
                .csrf(AbstractHttpConfigurer::disable)
                .sessionManagement(session -> session.sessionCreationPolicy(SessionCreationPolicy.STATELESS))
                .authorizeHttpRequests(auth -> auth
                        .requestMatchers("/libreria/libros/**").hasAnyRole("CLIENT", "ADMIN")
                        .requestMatchers("/libreria/crearLibro", "/libreria/actualizarLibro", "/libreria/eliminarLibro").hasRole("ADMIN")
                        .anyRequest().authenticated()
                )
                .addFilter(new JwtAuthenticationFilter(authenticationManager(http), jwtUtil))
                .addFilter(new JwtAuthorizationFilter(authenticationManager(http), jwtUtil));

        return http.build();
    }

    private AuthenticationManager authenticationManager(HttpSecurity http) throws Exception {
        return http.getSharedObject(AuthenticationManagerBuilder.class).build();
    }
}
