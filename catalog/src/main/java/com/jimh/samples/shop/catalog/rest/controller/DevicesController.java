package com.jimh.samples.shop.catalog.rest.controller;

import com.jimh.samples.shop.catalog.DeviceService;
import com.jimh.samples.shop.catalog.rest.DeviceResource;
import com.jimh.samples.shop.catalog.rest.DevicesRestMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping(path= {"/api/devices"})
@Slf4j
public class DevicesController {

    @Autowired
    private DeviceService service;

    @Autowired
    private DevicesRestMapper mapper;

    @RequestMapping(method = RequestMethod.GET)
    public List<DeviceResource> listAllDevices() {
        return  service.listAll().stream().map(device -> mapper.from(device)).collect(Collectors.toList());
    }

}
