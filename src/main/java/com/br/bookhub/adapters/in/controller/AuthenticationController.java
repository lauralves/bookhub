package com.br.bookhub.adapters.in.controller;

import com.br.bookhub.adapters.in.records.UserRecord;
import com.br.bookhub.adapters.in.auth.service.AuthenticationService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequestMapping("/auth")
@RequiredArgsConstructor
public class AuthenticationController {

    private final AuthenticationService authenticationService;

    @PostMapping("/login")
    public String authenticate (@RequestBody UserRecord user) {
        log.info("auth route {} {}", user.email(), user.password());
        return authenticationService.authenticate(user.email(), user.password());
    }
}
