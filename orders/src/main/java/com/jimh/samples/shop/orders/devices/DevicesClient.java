package com.jimh.samples.shop.orders.devices;

import com.jimh.samples.shop.orders.domain.Phone;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class DevicesClient implements DeviceService {

    @Override
    public List<Phone> getAllDevices() {
        return new ArrayList<>();
    }

    @Override
    public List<Phone> find(List<String> phones) {
        return new ArrayList<>();
    }
}
