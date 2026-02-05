package com.ikernell.Ikernell_System.controller;

import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/auth")
public class LoginController {

    @GetMapping("/me")
    public Authentication usuarioActual(Authentication authentication) {
        return authentication;
    }
}
