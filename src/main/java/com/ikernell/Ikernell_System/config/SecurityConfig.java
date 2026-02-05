package com.ikernell.Ikernell_System.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {

        http
                .csrf(csrf -> csrf.disable())
                .authorizeHttpRequests(auth -> auth

                        // 🔓 Públicos
                        .requestMatchers(
                                "/api/auth/**",
                                "/api/faq/**",
                                "/api/biblioteca/**"
                        ).permitAll()

                        // 🔐 Coordinador
                        .requestMatchers("/api/usuarios/**")
                        .hasRole("COORDINADOR")
                        .requestMatchers("/api/proyectos/**")
                        .hasAnyRole("COORDINADOR", "LIDER")


                        // 🔐 Líder
                        .requestMatchers("/api/etapas/**")
                        .hasAnyRole("COORDINADOR", "LIDER")


                        // 🔐 Desarrollador
                        .requestMatchers("/api/actividades/**")
                        .hasAnyRole("LIDER", "DESARROLLADOR")


                        // 🔐 Todo lo demás
                        .anyRequest().authenticated()
                )

                // 🔑 Login básico
                .httpBasic(Customizer.withDefaults());

        return http.build();
    }

    // 🔐 Password encoder obligatorio
    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
}
