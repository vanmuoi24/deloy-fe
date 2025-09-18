package org.korea_app_backend.model;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;

@Entity
@Table(name = "KhungGio")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class KhungGioModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(nullable = false)
    private String khungGio;

}
