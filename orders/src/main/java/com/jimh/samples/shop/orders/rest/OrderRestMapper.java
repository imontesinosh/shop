package com.jimh.samples.shop.orders.rest;

import com.jimh.samples.shop.orders.domain.Customer;
import com.jimh.samples.shop.orders.domain.Order;
import com.jimh.samples.shop.orders.domain.Phone;
import com.jimh.samples.shop.orders.rest.api.Item;
import com.jimh.samples.shop.orders.rest.api.OrderResource;
import com.jimh.samples.shop.orders.rest.api.PlaceOrderRequest;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;

@Component
public class OrderRestMapper {

    public Order from (PlaceOrderRequest resource, List<Phone> phones){
        return Order.builder()
                .customer(getCustomer(resource))
                .phones(phones)
                .build();
    }

    private Customer getCustomer(PlaceOrderRequest resource) {
        return Customer.builder().email(resource.getEmail())
                .name(resource.getName())
                .surname(resource.getSurname())
                .build();
    }

    public OrderResource from(Order order){
        return OrderResource.builder()
                .customer(mapCustomer(order.getCustomer()))
                .items(mapItems(order.getPhones()))
                .build();
    }

    private List<Item> mapItems(List<Phone> phones) {
        return phones.stream().map(toItem()).collect(Collectors.toList());
    }

    private Function<Phone, Item> toItem() {
        return phone -> Item.builder()
                .model(phone.getName())
                .price(phone.getPrice())
                .build();
    }

    private com.jimh.samples.shop.orders.rest.api.Customer mapCustomer(Customer order) {
        return com.jimh.samples.shop.orders.rest.api.Customer.builder()
                .email(order.getEmail())
                .name(order.getName())
                .build();
    }



}
