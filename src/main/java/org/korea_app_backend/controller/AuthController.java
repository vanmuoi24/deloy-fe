package org.korea_app_backend.controller;

import lombok.RequiredArgsConstructor;
import org.korea_app_backend.payload.ApiResponse;
import org.korea_app_backend.service.AuthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;


@RestController
@RequestMapping("/api/auth")
@RequiredArgsConstructor
public class AuthController {

    @Autowired
    private AuthService authService;

    @PostMapping("/login")
    public ResponseEntity<ApiResponse<Object>> login(@RequestBody Map<String, String> req) {
        try {
            String token = authService.login(req.get("taiKhoan"), req.get("matKhauBam"));

            Map<String, String> data = Map.of("token", token);

            return ResponseEntity.ok(
                    new ApiResponse<>(true, "Login success", data)
            );

        } catch (RuntimeException ex) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED)
                    .body(new ApiResponse<>(false, ex.getMessage(), null));
        }
    }

}