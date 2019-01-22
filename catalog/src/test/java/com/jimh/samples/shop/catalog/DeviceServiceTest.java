package com.jimh.samples.shop.catalog;


import com.jimh.samples.shop.catalog.persistence.DeviceEntity;
import com.jimh.samples.shop.catalog.persistence.DeviceEntityMapper;
import com.jimh.samples.shop.catalog.persistence.DeviceRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.Collections;

import static java.util.Arrays.asList;
import static org.mockito.Mockito.*;

@RunWith(MockitoJUnitRunner.class)
public class DeviceServiceTest {

    @Mock
    private DeviceRepository storage;

    @Mock
    private DeviceEntityMapper mapper;

    @InjectMocks
    private DeviceService service;

    @Test
    public void emptyRepositoryReturnsEmptyList(){
        when(storage.findAll()).thenReturn(Collections.emptyList());
        service.listAll();
        verify(mapper, times(0)).from(any(DeviceEntity.class));
    }

    @Test
    public void nonEmptyRepositoryReturnsNonEmptyList(){
        DeviceEntity entity = new DeviceEntity(1L, "a", "b", "c", 1.0) ;
        when(storage.findAll()).thenReturn(asList(entity));
        when(mapper.from(any(DeviceEntity.class))).thenCallRealMethod();
        service.listAll();
        verify(mapper).from(any(DeviceEntity.class));
    }
}
