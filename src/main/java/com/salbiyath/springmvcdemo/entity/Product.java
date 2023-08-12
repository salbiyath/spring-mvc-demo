package com.salbiyath.springmvcdemo.entity;

import lombok.*;

import java.math.BigDecimal;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
@ToString
public class Product {
    
    private Long id;
    private String name;
    private Number price;
    private Integer stock;

}
