package com.jimh.samples.shop.orders.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Customer {

    private String name;

    private String surname;

    private String email;

}
