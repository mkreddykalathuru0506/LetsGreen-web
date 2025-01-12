package com.letsGreen.controller;

import com.letsGreen.entity.Nursery;
import com.letsGreen.service.NurseryService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.*;

class NurseryControllerTest {

    @Mock
    private NurseryService nurseryService;

    @InjectMocks
    private NurseryController nurseryController;

    private Nursery nursery;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        nursery = new Nursery();
        nursery.setId(1L);
        nursery.setStartDate(java.sql.Date.valueOf("2023-01-01"));
        nursery.setCapacity(100);
    }

    @Test
    void testCreateNursery() {
        when(nurseryService.createNursery(any(Nursery.class))).thenReturn(nursery);

        ResponseEntity<String> response = nurseryController.createNursery(nursery);

        assertEquals(HttpStatus.CREATED, response.getStatusCode());
        assertEquals("Nursery created with ID: 1", response.getBody());
        verify(nurseryService, times(1)).createNursery(any(Nursery.class));
    }

    @Test
    void testGetNurseryById() {
        when(nurseryService.getNurseryById(anyLong())).thenReturn(nursery);

        ResponseEntity<String> response = nurseryController.getNurseryById(1L);

        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals("Nursery found: Nursery{id=1, address='123 Green St', startDate=2023-01-01, capacity=100}", response.getBody());
        verify(nurseryService, times(1)).getNurseryById(anyLong());
    }

    @Test
    void testGetNurseryByIdNotFound() {
        when(nurseryService.getNurseryById(anyLong())).thenReturn(null);

        ResponseEntity<String> response = nurseryController.getNurseryById(1L);

        assertEquals(HttpStatus.NOT_FOUND, response.getStatusCode());
        assertEquals("Nursery not found", response.getBody());
    }

    @Test
    void testGetAllNurseries() {
        List<Nursery> nurseryList = Arrays.asList(nursery);
        when(nurseryService.getAllNurseries()).thenReturn(nurseryList);

        ResponseEntity<String> response = nurseryController.getAllNurseries();

        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals("All Nurseries: [Nursery{id=1, address='123 Green St', startDate=2023-01-01, capacity=100}]", response.getBody());
        verify(nurseryService, times(1)).getAllNurseries();
    }

    @Test
    void testUpdateNursery() {
        when(nurseryService.updateNursery(anyLong(), any(Nursery.class))).thenReturn(nursery);

        ResponseEntity<String> response = nurseryController.updateNursery(1L, nursery);

        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals("Nursery updated: Nursery{id=1, address='123 Green St', startDate=2023-01-01, capacity=100}", response.getBody());
        verify(nurseryService, times(1)).updateNursery(anyLong(), any(Nursery.class));
    }

    @Test
    void testUpdateNurseryNotFound() {
        when(nurseryService.updateNursery(anyLong(), any(Nursery.class))).thenReturn(null);

        ResponseEntity<String> response = nurseryController.updateNursery(1L, nursery);

        assertEquals(HttpStatus.NOT_FOUND, response.getStatusCode());
        assertEquals("Nursery not found", response.getBody());
    }

    @Test
    void testDeleteNursery() {
        doNothing().when(nurseryService).deleteNursery(anyLong());

        ResponseEntity<String> response = nurseryController.deleteNursery(1L);

        assertEquals(HttpStatus.NO_CONTENT, response.getStatusCode());
        assertEquals("Nursery deleted", response.getBody());
        verify(nurseryService, times(1)).deleteNursery(anyLong());
    }
}
