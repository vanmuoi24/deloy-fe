package org.korea_app_backend.controller;

import lombok.RequiredArgsConstructor;
import org.korea_app_backend.dto.BieuMauDTO;
import org.korea_app_backend.model.BieuMauModel;
import org.korea_app_backend.model.KhungGioModel;
import org.korea_app_backend.payload.ApiResponse;
import org.korea_app_backend.service.BieuMauService;
import org.korea_app_backend.service.KhungGioService;
import org.korea_app_backend.service.QRCodeService;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/bieumau")
@RequiredArgsConstructor
@Validated
public class BieuMauController {
    private final BieuMauService bieuMauService;
    private final KhungGioService khungGioService;
    private final QRCodeService qrCodeService;

    @GetMapping
    public ResponseEntity<ApiResponse<List<BieuMauModel>>> getAll() {
        List<BieuMauModel> list = bieuMauService.getAll();
        return ResponseEntity.ok(new ApiResponse<>(true, "Danh sách biểu mẫu", list));
    }

    @PostMapping
    public ResponseEntity<ApiResponse<BieuMauModel>> create(@Validated @RequestBody BieuMauDTO bm) {
        KhungGioModel khungGio = khungGioService.getById(bm.getKhungGioId())
                .orElseThrow(() -> new RuntimeException("Không tìm thấy khung giờ"));

        BieuMauModel bieuMau = BieuMauModel.builder()
                .hoTen(bm.getHoTen())
                .ngaySinh(bm.getNgaySinh())
                .loaiGiayToXN(bm.getLoaiGiayToXN())
                .loaiBangCap(bm.getLoaiBangCap())
                .donViCapBang(bm.getDonViCapBang())
                .nganhDaotao(bm.getNganhDaotao())
                .soHieuBang(bm.getSoHieuBang())
                .namTotNghiep(bm.getNamTotNghiep())
                .diemTotNghiep(bm.getDiemTotNghiep())
                .ngayHen(bm.getNgayHen())
                .khungGio(khungGio)
                .thu(bm.getThu())
                .ngaybieumau(bm.getNgaybieumau())
                .ngayXacNhan(bm.getNgayXacNhan())
                .ngayTao(bm.getNgayTao())
                .ngayHen(bm.getNgayHen())
                .maICD(bm.getMaICD())
                .ghiChu(bm.getGhiChu())
                .maSV(bm.getMaSV())
                .build();

        BieuMauModel saved = bieuMauService.create(bieuMau);

        return ResponseEntity.ok(
                new ApiResponse<>(true, "Thêm thành công", saved)
        );
    }

    @PutMapping("/{id}")
    public ResponseEntity<ApiResponse<BieuMauModel>> update(
            @PathVariable int id,
            @Validated @RequestBody BieuMauDTO bm) {

        KhungGioModel khungGio = khungGioService.getById(bm.getKhungGioId())
                .orElseThrow(() -> new RuntimeException("Không tìm thấy khung giờ"));

        BieuMauModel detail = BieuMauModel.builder()
                .hoTen(bm.getHoTen())
                .ngaySinh(bm.getNgaySinh())
                .loaiGiayToXN(bm.getLoaiGiayToXN())
                .loaiBangCap(bm.getLoaiBangCap())
                .donViCapBang(bm.getDonViCapBang())
                .nganhDaotao(bm.getNganhDaotao())
                .soHieuBang(bm.getSoHieuBang())
                .namTotNghiep(bm.getNamTotNghiep())
                .diemTotNghiep(bm.getDiemTotNghiep())
                .ngayHen(bm.getNgayHen())
                .khungGio(khungGio)
                .ngaybieumau(bm.getNgaybieumau())
                .ngayTao(bm.getNgayTao())
                .ngayXacNhan(bm.getNgayXacNhan())
                .maICD(bm.getMaICD())
                .ghiChu(bm.getGhiChu())
                .maSV(bm.getMaSV())
                .thu(bm.getThu())
                .build();

        BieuMauModel updated = bieuMauService.update(id, detail);

        return ResponseEntity.ok(
                new ApiResponse<>(true, "Cập nhật thành công", updated)
        );
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<ApiResponse<Void>> delete(@PathVariable int id) {
        bieuMauService.delete(id);
        return ResponseEntity.ok(new ApiResponse<>(true, "Xóa biểu mẫu thành công", null));
    }


    // API lấy QR code ảnh từ id
    @GetMapping("/{id}/qr")
    public ResponseEntity<byte[]> getQRCode(@PathVariable int id) throws Exception {
            BieuMauModel bm = bieuMauService.getById(id)
                            .orElseThrow(() -> new RuntimeException("Không tìm thấy biểu mẫu"));

            // link bạn muốn nhúng vào QR
            String qrContent = "https://korea-app-fe.onrender.com/member/" + bm.getId();

            byte[] qrImage = qrCodeService.generateQRCode(qrContent, 360, 360);

            return ResponseEntity.ok()
                            .header(HttpHeaders.CONTENT_DISPOSITION, "inline; filename=\"bm-" + bm.getId() + ".png\"")
                            .contentType(MediaType.IMAGE_PNG)
                            .body(qrImage);
    }



    // API xem thông tin qua QR code(maQR la id)
    @GetMapping("/view/{maQR}")
    public ResponseEntity<ApiResponse<BieuMauModel>> getByQR(@PathVariable int maQR) {
        BieuMauModel bm = bieuMauService.getById(maQR)
                .orElseThrow(() -> new RuntimeException("Không tìm thấy biểu mẫu"));

        return ResponseEntity.ok(
                new ApiResponse<>(true, "Lấy biểu mẫu thành công", bm)
        );
    }
}
