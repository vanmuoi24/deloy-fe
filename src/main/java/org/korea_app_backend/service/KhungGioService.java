package org.korea_app_backend.service;


import lombok.RequiredArgsConstructor;
import org.korea_app_backend.model.KhungGioModel;
import org.korea_app_backend.repository.KhungGioRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class KhungGioService {
    private final KhungGioRepository repo;

    public List<KhungGioModel> getAll() {
        return repo.findAll();
    }

    public Optional<KhungGioModel> getById(int id) {
        return repo.findById(id);
    }

    public KhungGioModel create(KhungGioModel khungGio) {
        return repo.save(khungGio);
    }

    public KhungGioModel update(int id, KhungGioModel khungGioDetails) {
        KhungGioModel khungGio = repo.findById(id)
                .orElseThrow(() -> new RuntimeException("KhungGio not found with id " + id));
        khungGio.setKhungGio(khungGioDetails.getKhungGio());
        return repo.save(khungGio);
    }

    public void delete(int id) {
        KhungGioModel khungGio = repo.findById(id)
                .orElseThrow(() -> new RuntimeException("KhungGio not found with id " + id));
        repo.delete(khungGio);
    }
}
