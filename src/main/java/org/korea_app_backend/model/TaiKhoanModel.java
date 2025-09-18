package org.korea_app_backend.model;


import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "TaiKhoan")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class TaiKhoanModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true, nullable = false)
    private String taiKhoan;

    @Column(nullable = false)
    private String matKhauBam;
}
