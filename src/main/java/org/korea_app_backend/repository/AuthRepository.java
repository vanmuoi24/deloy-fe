package org.korea_app_backend.repository;


import org.korea_app_backend.model.TaiKhoanModel;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface AuthRepository extends JpaRepository<TaiKhoanModel, Integer> {
    Optional<TaiKhoanModel> findByTaiKhoan(String taiKhoan);
    boolean existsByTaiKhoan(String taiKhoan);
}
