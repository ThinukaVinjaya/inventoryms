package com.thinuka.inventoryms.security.controllers;


import com.thinuka.inventoryms.security.services.AuthenticationService;
import com.thinuka.inventoryms.security.models.LoginRequest;
import com.thinuka.inventoryms.services.UserService;
import jakarta.servlet.http.HttpSession;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AuthController {

    private final UserService userService;

    private final AuthenticationService authenticationService;

    public AuthController(UserService userService, AuthenticationService authenticationService) {
        this.userService = userService;
        this.authenticationService = authenticationService;
    }

    @PostMapping("/login")
    public ResponseEntity<String> login(@RequestBody LoginRequest loginRequest, HttpSession session) {
        try {
            boolean isAuthenticated = authenticationService.authenticate(loginRequest.getUsername(), loginRequest.getPassword());
            if (isAuthenticated) {
                session.setAttribute("user", loginRequest.getUsername());
                return ResponseEntity.ok("Login successful");
            } else {
                return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Invalid username or password");
            }
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("An error occurred during login");
        }
    }

    @PostMapping("/logout")
    public ResponseEntity<String> logout(HttpSession session) {
        session.invalidate();  // Invalidate the session
        return ResponseEntity.ok("Logout successful");
    }

}
