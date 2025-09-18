package org.korea_app_backend.controller;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.korea_app_backend.dto.KhungGioDTO;
import org.korea_app_backend.model.KhungGioModel;
import org.korea_app_backend.payload.ApiResponse;
import org.korea_app_backend.service.KhungGioService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/khunggio")
@RequiredArgsConstructor
@Validated
public class KhungGioController {
    private final KhungGioService service;

    @GetMapping("/{id}")
    public ResponseEntity<ApiResponse<KhungGioModel>> getByID(@RequestParam("id") int id) {
        KhungGioModel khungGio = service.getById(id)
                .orElseThrow(() -> new RuntimeException("Khong tim thay khung gio"));
        return ResponseEntity.ok(
                new ApiResponse<>(true, "Lay khung gio thanh cong", khungGio)
        );
    }


    @GetMapping
    public ResponseEntity<ApiResponse<List<KhungGioModel>>> getAll() {
        List<KhungGioModel> list = service.getAll();
        return ResponseEntity.ok(new ApiResponse<>(true, "Danh sách khung giờ", list));
    }

    @PostMapping
    public ResponseEntity<ApiResponse<KhungGioModel>> create(@Valid @RequestBody KhungGioDTO khungGioDTO) {
                System.err.println(khungGioDTO.getKhungGio());
        KhungGioModel model = KhungGioModel.builder()
                .khungGio(khungGioDTO.getKhungGio())
                .build();
        KhungGioModel saved = service.create(model);

        return ResponseEntity.ok(
                new ApiResponse<>(true, "Thêm khung giờ thành công", saved)
        );
    }

    @PutMapping("/{id}")
    public ResponseEntity<ApiResponse<KhungGioModel>> update(@PathVariable int id,
                                                             @Valid @RequestBody KhungGioDTO khungGioDTO) {
        KhungGioModel model = KhungGioModel.builder()
                .khungGio(khungGioDTO.getKhungGio())
                .build();

        KhungGioModel updated = service.update(id, model);

        return ResponseEntity.ok(
                new ApiResponse<>(true, "Cập nhật khung giờ thành công", updated)
        );
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<ApiResponse<Void>> delete(@PathVariable int id) {
        service.delete(id);
        return ResponseEntity.ok(new ApiResponse<>(true, "Xóa khung giờ thành công", null));
    }

}
