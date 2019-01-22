package com.jimh.samples.shop.catalog.persistence;

import com.jimh.samples.shop.catalog.domain.Device;
import org.springframework.stereotype.Component;

@Component
public class DeviceEntityMapper {

    public Device from (DeviceEntity entity){
        return Device.builder()
                .description(entity.getDescription())
                .image(entity.getImage())
                .name(entity.getName())
                .price(entity.getPrice())
                .build();
    }

    public DeviceEntity from (Device device){
        return new DeviceEntity(null, device.getImage(), device.getName(), device.getDescription(), device.getPrice());
    }

}
