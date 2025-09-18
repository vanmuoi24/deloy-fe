package org.korea_app_backend.repository;

import org.korea_app_backend.model.KhungGioModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface KhungGioRepository extends JpaRepository<KhungGioModel, Integer> {

}
