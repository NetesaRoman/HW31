package com.example.hw31.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

/*
 *
 * @author Roman Netesa
 *
 */
@Data
@AllArgsConstructor
public class ProductDto {
    private Integer id;

    private String name;

    private Double cost;
}
