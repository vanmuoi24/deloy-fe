package org.korea_app_backend.repository;

import org.korea_app_backend.model.BieuMauModel;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface BieuMauRepository extends JpaRepository<BieuMauModel, Integer> {
}
