package com.security.micro.demo.controller;


import com.security.micro.demo.dto.request.LoginForm;
import com.security.micro.demo.dto.request.SignUpForm;
import com.security.micro.demo.dto.response.IdentityResponse;
import com.security.micro.demo.services.SignUpAndSignInService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import javax.validation.Valid;


@Slf4j
@RestController
@RequestMapping("/api/auth")
@CrossOrigin(origins = "*")
public class AuthRestAPIs {

    @Autowired
    private SignUpAndSignInService signUpAndSignInService;


    @PostMapping("/signin")
    public ResponseEntity<?> authenticateUser(@Valid @RequestBody LoginForm loginRequest) {

        return ResponseEntity.ok(signUpAndSignInService.signIn(loginRequest));
    }

    @PostMapping("/signup")
    public IdentityResponse registerUser(@RequestBody SignUpForm signUpRequest) {
        return signUpAndSignInService.signUp(signUpRequest);
    }
    @GetMapping("/users")
    public String getLoggedAuthId() {
        return signUpAndSignInService.getLoggedAuthUser();
    }

}