package com.azvtech.busdatasourceservice.dto;

import lombok.*;

/**
 * @author Fellipe Toledo
 */
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor

public class BusResponse {
    private Long id;
    private String plate;
    private String orderCode;
}

