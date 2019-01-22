package com.jimh.samples.shop.catalog.rest.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.jimh.samples.shop.catalog.rest.DeviceResource;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.test.context.junit4.SpringRunner;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.containsString;
import static org.hamcrest.Matchers.is;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@Slf4j
public class DevicesControllerTest {

    @LocalServerPort
    private int port;

    @Autowired
    private TestRestTemplate restTemplate;

    @Autowired
    private ObjectMapper mapper;

    @Test
    public void listAllDevices() throws Exception {
        String responseBody = this.restTemplate.getForObject("http://localhost:" + port + "/api/devices",String.class);
        log.info("Response body is: {}", responseBody);
        DeviceResource[] devices = mapper.readValue(responseBody, DeviceResource[].class);
        assertThat("Three devices were retrieved", devices.length, is(3));
    }

    @Test
    public void postMethodNotSupported() throws Exception {
        String responseBody = this.restTemplate.postForObject("http://localhost:" + port + "/api/devices",null, String.class);
        log.info("Response body is: {}", responseBody);
        assertThat("body has 'Method not Allowed'", responseBody, containsString("Method Not Allowed"));
        assertThat("body has 405", responseBody, containsString("405"));
    }

}
