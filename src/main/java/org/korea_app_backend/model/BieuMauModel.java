package org.korea_app_backend.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;

import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

@Entity
@Table(name = "BieuMau")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class BieuMauModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(nullable = false)
    private String thu;

    @Column(nullable = false)
    private String hoTen;

    @Column(nullable = false)
    @JsonFormat(pattern = "dd-MM-yyyy") // hiển thị JSON dd-MM-yyyy
    private LocalDate ngaySinh;

    @Column(nullable = false)
    private String loaiGiayToXN;

    @Column(nullable = false)
    private String loaiBangCap;

    @Column(nullable = false)
    private String donViCapBang;
    @Column(nullable = false)
    private String thangDiem;
    @Column(nullable = false)
    private String nganhDaotao;

    @Column(nullable = false)
    private String soHieuBang;

    @Column(nullable = false)
    private Short namTotNghiep;

    @Column(nullable = false)
    private float diemTotNghiep;

    @Column(nullable = false)
    @JsonFormat(pattern = "dd-MM-yyyy")
    private LocalDate ngayHen;

    @JsonFormat(pattern = "dd-MM-yyyy")
    private LocalDate ngayTao;

    @JsonFormat(pattern = "dd-MM-yyyy")
    private LocalDate ngayXacNhan;

    @JsonFormat(pattern = "dd-MM-yyyy")
    private LocalDate ngaybieumau;

    @Column(nullable = false)
    private String maICD;

    @Column(nullable = false)
    private String ghiChu;

    @Column(nullable = false)
    private String maSV;

    @ManyToOne
    @JoinColumn(name = "khung_gio_id", foreignKey = @ForeignKey(name = "FK_bieumau_khunggio"))
    @OnDelete(action = OnDeleteAction.CASCADE) // hoặc SET_NULL
    private KhungGioModel khungGio;
}
