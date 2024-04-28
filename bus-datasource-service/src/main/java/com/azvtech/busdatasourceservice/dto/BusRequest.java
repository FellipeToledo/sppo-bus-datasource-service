package com.azvtech.busdatasourceservice.dto;

import jakarta.validation.constraints.NotBlank;
import lombok.*;

/**
 * @author Fellipe Toledo
 */
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class BusRequest {

    @NotBlank
    private String plate;
    @NotBlank
    private String orderCode;

}
