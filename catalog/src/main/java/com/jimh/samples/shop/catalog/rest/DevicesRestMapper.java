package com.jimh.samples.shop.catalog.rest;

import com.jimh.samples.shop.catalog.domain.Device;
import org.springframework.stereotype.Component;

@Component
public class DevicesRestMapper {

    public DeviceResource from(Device device){
        return DeviceResource.builder()
                .description(device.getDescription())
                .image(device.getImage())
                .name(device.getName())
                .price(device.getPrice())
                .build();
    }

    public Device from (DeviceResource resource){
        return Device.builder()
                .description(resource.getDescription())
                .image(resource.getImage())
                .name(resource.getName())
                .price(resource.getPrice())
                .build();
    }

}
