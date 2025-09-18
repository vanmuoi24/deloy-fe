package org.korea_app_backend.service;

import lombok.RequiredArgsConstructor;
import org.korea_app_backend.model.TaiKhoanModel;
import org.korea_app_backend.repository.AuthRepository;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
@RequiredArgsConstructor
public class CustomUserDetailsService implements UserDetailsService {
    private final AuthRepository authRepository;

    @Override
    public UserDetails loadUserByUsername(String taiKhoan) throws UsernameNotFoundException {
        TaiKhoanModel user = authRepository.findByTaiKhoan(taiKhoan)
                .orElseThrow(() -> new UsernameNotFoundException("User not found"));

        return new org.springframework.security.core.userdetails.User(
                user.getTaiKhoan(),
                user.getMatKhauBam(),
                new ArrayList<>()
        );
    }
}
