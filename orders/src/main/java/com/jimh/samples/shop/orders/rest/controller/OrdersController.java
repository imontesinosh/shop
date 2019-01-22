package com.jimh.samples.shop.orders.rest.controller;

import com.jimh.samples.shop.orders.OrderService;
import com.jimh.samples.shop.orders.devices.DevicesClient;
import com.jimh.samples.shop.orders.domain.Order;
import com.jimh.samples.shop.orders.domain.Phone;
import com.jimh.samples.shop.orders.rest.api.OrderResource;
import com.jimh.samples.shop.orders.rest.api.PlaceOrderRequest;
import com.jimh.samples.shop.orders.rest.OrderRestMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(path= {"/api/orders"})
@Slf4j
public class OrdersController {

    @Autowired
    private OrderService service;

    @Autowired
    private OrderRestMapper mapper;

    @Autowired
    private DevicesClient devices;

    @RequestMapping(method = RequestMethod.POST)
    public ResponseEntity<OrderResource> placeOrder(@RequestBody PlaceOrderRequest incomingOrder) {

        List<Phone> phones = devices.find(incomingOrder.getPhones());

        Order order = mapper.from(incomingOrder, phones);

        service.place(order);

        return new ResponseEntity<>(mapper.from(order), HttpStatus.CREATED);
    }

}
