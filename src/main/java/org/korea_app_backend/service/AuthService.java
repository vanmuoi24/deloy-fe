package org.korea_app_backend.service;

import lombok.RequiredArgsConstructor;
import org.korea_app_backend.config.JwtUtil;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthService {
    private final AuthenticationManager authenticationManager;
    private final JwtUtil jwtUtil;

    public String login(String email, String password) {
        try {
            Authentication authentication = authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(email, password)
            );

            UserDetails user = (UserDetails) authentication.getPrincipal();
            return jwtUtil.generateToken(user.getUsername());

        } catch (BadCredentialsException ex) {
            throw new RuntimeException("Incorrect account or password");
        } catch (AuthenticationException ex) {
            throw new RuntimeException("Authentication failed: " + ex.getMessage());
        }
    }


}
