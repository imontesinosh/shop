package com.jimh.samples.shop.orders.rest.api;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
public class PlaceOrderRequest {

    private String name;

    private String surname;

    private String email;

    private List<String> phones;

}
