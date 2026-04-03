package com.br.bookhub.framework.in.controller;

import com.br.bookhub.framework.in.security.UserDetailImpl;
import com.br.bookhub.framework.in.security.service.AuthenticationService;
import com.br.bookhub.framework.in.records.UserRecord;
import com.br.bookhub.framework.in.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
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

    private final UserRepository userRepository;

    private final PasswordEncoder passwordEncoder;

    @PostMapping("/login")
    public String authenticate (@RequestBody UserRecord user) {
        return authenticationService.authenticate(user.email(), user.password());
    }


    @PostMapping("/create")
    public ResponseEntity<UserDetailImpl> create (@RequestBody UserRecord userRecord) {
        UserDetailImpl user = new UserDetailImpl();
        user.setEmail(userRecord.email());
        user.setPassword(passwordEncoder.encode(userRecord.password()));
        return ResponseEntity.ok(userRepository.save(user));
    }
}
