package com.jimh.samples.shop.catalog.config;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.jimh.samples.shop.catalog.persistence.DeviceEntity;
import com.jimh.samples.shop.catalog.persistence.DeviceRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;

import javax.annotation.PostConstruct;
import java.io.IOException;
import java.util.Arrays;

/*
 * This class was made only for illustrative purposes. It reads the contents of sample-devices.json
 * and creates an entity for each entry in the file, so that they may be retrieved from the rest API later.
 */
@Configuration
@Slf4j
public class DeviceRepositoryInitializer {

    @Autowired
    private DeviceRepository repository;

    @Autowired
    private ObjectMapper mapper;

    @PostConstruct
    private void insertSomeRecords() throws IOException {
        if(!repository.findAll().iterator().hasNext()){
            log.info("Adding sample devices to in memory storage...");
            Arrays.stream(readSampleDevices()).forEach(repository::save);
        }
    }

    private DeviceEntity[] readSampleDevices() throws IOException {
        return mapper.readValue(new ClassPathResource("sample-devices.json").getInputStream(), DeviceEntity[].class);
    }

}
