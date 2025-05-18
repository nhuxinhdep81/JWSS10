package com.tien.ss10.model;

import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Data
public class Product {
    private String name;
    private double price;
    private String description;
}
