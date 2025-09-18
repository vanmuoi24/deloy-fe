package org.korea_app_backend.dto;



import jakarta.validation.constraints.NotBlank;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class KhungGioDTO {

    @NotBlank(message = "This field is required")
    private String khungGio;
}
