package com.azvtech.busdatasourceservice.model;

import jakarta.persistence.*;
import lombok.*;

/**
 * @author Fellipe Toledo
 */

@Entity
@Getter
@Setter
@Table(name = "buses")
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Bus {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false)
    private String plate;
    @Column(nullable = false)
    private String orderCode;

}
