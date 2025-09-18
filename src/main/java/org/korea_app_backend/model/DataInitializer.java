package org.korea_app_backend.model;

import org.korea_app_backend.repository.AuthRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
public class DataInitializer {
    @Bean
    CommandLineRunner init(AuthRepository repo, PasswordEncoder encoder) {
        return args -> {
            String username = "admin";

            // Kiểm tra xem admin đã tồn tại chưa
            if (!repo.existsByTaiKhoan(username)) {
                TaiKhoanModel admin = TaiKhoanModel.builder()
                        .taiKhoan(username)
                        .matKhauBam(encoder.encode("123456"))
                        .build();
                repo.save(admin);
                System.out.println("Admin created");
            }
        };
    }
}
