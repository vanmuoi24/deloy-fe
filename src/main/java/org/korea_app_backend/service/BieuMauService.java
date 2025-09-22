package org.korea_app_backend.service;

import lombok.RequiredArgsConstructor;
import org.korea_app_backend.model.BieuMauModel;
import org.korea_app_backend.model.KhungGioModel;
import org.korea_app_backend.repository.BieuMauRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class BieuMauService {
    private final BieuMauRepository repo;

    public List<BieuMauModel> getAll() {
        return repo.findAll();
    }

    public Optional<BieuMauModel> getById(int id) {
        return repo.findById(id);
    }

    public BieuMauModel create(BieuMauModel bieuMau) {

        return repo.save(bieuMau);
    }

    public BieuMauModel update(int id, BieuMauModel bieuMauDetail) {
        BieuMauModel bieuMau = repo.findById(id)
                .orElseThrow(() -> new RuntimeException("KhungGio not found with id " + id));
        bieuMau.setHoTen(bieuMauDetail.getHoTen());
        bieuMau.setNgaySinh(bieuMauDetail.getNgaySinh());
        bieuMau.setLoaiGiayToXN(bieuMauDetail.getLoaiGiayToXN());
        bieuMau.setLoaiBangCap(bieuMauDetail.getLoaiBangCap());
        bieuMau.setDonViCapBang(bieuMauDetail.getDonViCapBang());
        bieuMau.setNganhDaotao(bieuMauDetail.getNganhDaotao());
        bieuMau.setSoHieuBang(bieuMauDetail.getSoHieuBang());
        bieuMau.setNamTotNghiep(bieuMauDetail.getNamTotNghiep());
        bieuMau.setDiemTotNghiep(bieuMauDetail.getDiemTotNghiep());
        bieuMau.setNgayHen(bieuMauDetail.getNgayHen());
        bieuMau.setKhungGio(bieuMauDetail.getKhungGio());
         bieuMau.setThu(bieuMauDetail.getThu());
         bieuMau.setNgaybieumau(bieuMauDetail.getNgaybieumau());
         bieuMau.setNgayTao(bieuMauDetail.getNgayTao());
         bieuMau.setNgayXacNhan(bieuMauDetail.getNgayXacNhan());
         bieuMau.setMaICD(bieuMauDetail.getMaICD());
         bieuMau.setGhiChu(bieuMauDetail.getGhiChu());
         bieuMau.setMaSV(bieuMauDetail.getMaSV());
         bieuMau.setThangDiem(bieuMauDetail.getThangDiem());
        return repo.save(bieuMau);
    }

    public void delete(int id) {
        BieuMauModel bieuMau = repo.findById(id)
                .orElseThrow(() -> new RuntimeException("BieuMau not found with id " + id));
        repo.delete(bieuMau);
    }

}
