package com.jimh.samples.shop.orders.devices;

import com.jimh.samples.shop.orders.domain.Phone;

import java.util.List;

public interface DeviceService {

    List<Phone> getAllDevices();

    List<Phone> find(List<String> phones);
}
