package com.jimh.samples.shop.catalog;

import com.jimh.samples.shop.catalog.domain.Device;
import com.jimh.samples.shop.catalog.persistence.DeviceEntity;
import com.jimh.samples.shop.catalog.persistence.DeviceEntityMapper;
import com.jimh.samples.shop.catalog.persistence.DeviceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Spliterator;
import java.util.function.Consumer;

@Component
public class DeviceService {

    @Autowired
    private DeviceRepository storage;

    @Autowired
    private DeviceEntityMapper mapper;

    public List<Device> listAll(){
        List<Device> results = new ArrayList<>();
        findAllDevices().forEachRemaining(mapThenCollect(results));
        return results;
    }

    private Spliterator<DeviceEntity> findAllDevices() {
        return storage.findAll().spliterator();
    }

    private Consumer<DeviceEntity> mapThenCollect(List<Device> results) {
        return deviceEntity -> {
            Device device = mapper.from(deviceEntity);
            results.add(device);};
    }


}
