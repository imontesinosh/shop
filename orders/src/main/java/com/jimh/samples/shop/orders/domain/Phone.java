package com.jimh.samples.shop.orders.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Phone {

    private String image;

    private String name;

    private String description;

    private Double price;

}
