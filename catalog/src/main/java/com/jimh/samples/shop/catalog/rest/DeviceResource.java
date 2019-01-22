package com.jimh.samples.shop.catalog.rest;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
public class DeviceResource {

    private String image;

    private String name;

    private String description;

    private Double price;

}
