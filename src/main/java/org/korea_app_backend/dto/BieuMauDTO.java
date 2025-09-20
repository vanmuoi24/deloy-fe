package org.korea_app_backend.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import org.springframework.format.annotation.DateTimeFormat;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.*;

import java.time.LocalDate;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class BieuMauDTO {

    @NotNull(message = "This field is required")
    @JsonFormat(pattern = "dd-MM-yyyy")
    @DateTimeFormat(pattern = "dd-MM-yyyy")
    private LocalDate ngaybieumau;

    @NotBlank(message = "This field is required")
    private String hoTen;

    @NotNull(message = "This field is required")
    @JsonFormat(pattern = "dd-MM-yyyy")
    @DateTimeFormat(pattern = "dd-MM-yyyy")
    private LocalDate ngaySinh;

    @NotBlank(message = "This field is required")
    private String loaiGiayToXN;

    @NotBlank(message = "This field is required")
    private String loaiBangCap;

    @NotBlank(message = "This field is required")
    private String donViCapBang;

    @NotBlank(message = "This field is required")
    private String nganhDaotao;

    @NotBlank(message = "This field is required")
    private String soHieuBang;

    @NotNull(message = "This field is required")
    private Short namTotNghiep;

    @NotNull(message = "This field is required")
    private float diemTotNghiep;

    @NotNull(message = "This field is required")
    @JsonFormat(pattern = "dd-MM-yyyy")
    @DateTimeFormat(pattern = "dd-MM-yyyy")
    private LocalDate ngayHen;

    @NotNull(message = "This field is required")
    private Integer khungGioId;

    @NotBlank(message = "This field is required")
    private String thu;

    @JsonFormat(pattern = "dd-MM-yyyy")
    @DateTimeFormat(pattern = "dd-MM-yyyy")
    private LocalDate ngayXacNhan;

    @JsonFormat(pattern = "dd-MM-yyyy")
    @DateTimeFormat(pattern = "dd-MM-yyyy")
    private LocalDate ngayTao;

    @NotBlank(message = "This field is required")
    private String maICD;

    @NotBlank(message = "This field is required")
    private String ghiChu;

    @NotBlank(message = "This field is required")
    private String maSV;
}
