package com.letsGreen.controller;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import com.letsGreen.entity.Decease;
import com.letsGreen.service.DeceaseService;

class DeceaseControllerTest {

    @Mock
    private DeceaseService deceaseService;

    @InjectMocks
    private DeceaseController deceaseController;

    private Decease decease;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        decease = new Decease();
        decease.setId(1L);
        decease.setName("Test Decease");
        decease.setTenure("6 months");
        decease.setNeededMedicineId("med123");
    }

    @Test
    void testCreateDecease() {
        when(deceaseService.createDecease(any(Decease.class))).thenReturn(decease);

        ResponseEntity<String> response = deceaseController.createDecease(decease);

        assertEquals(HttpStatus.CREATED, response.getStatusCode());
        assertEquals("Decease created with ID: 1", response.getBody());
        verify(deceaseService, times(1)).createDecease(any(Decease.class));
    }

    @Test
    void testGetDeceaseById() {
        when(deceaseService.getDeceaseById(anyLong())).thenReturn(decease);

        ResponseEntity<String> response = deceaseController.getDeceaseById(1L);

        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals("Decease found: Decease{id=1, name='Test Decease', tenure='6 months', totalTreatmentTenure='3 months', remainingTreatmentTenure='2 months', neededMedicineId='med123'}", response.getBody());
        verify(deceaseService, times(1)).getDeceaseById(anyLong());
    }

    @Test
    void testGetDeceaseByIdNotFound() {
        when(deceaseService.getDeceaseById(anyLong())).thenReturn(null);

        ResponseEntity<String> response = deceaseController.getDeceaseById(1L);

        assertEquals(HttpStatus.NOT_FOUND, response.getStatusCode());
        assertEquals("Decease not found", response.getBody());
    }

    @Test
    void testGetAllDeceases() {
        List<Decease> deceaseList = Arrays.asList(decease);
        when(deceaseService.getAllDeceases()).thenReturn(deceaseList);

        ResponseEntity<String> response = deceaseController.getAllDeceases();

        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals("All Deceases: [Decease{id=1, name='Test Decease', tenure='6 months', totalTreatmentTenure='3 months', remainingTreatmentTenure='2 months', neededMedicineId='med123'}]", response.getBody());
        verify(deceaseService, times(1)).getAllDeceases();
    }

    @Test
    void testUpdateDecease() {
        when(deceaseService.updateDecease(anyLong(), any(Decease.class))).thenReturn(decease);

        ResponseEntity<String> response = deceaseController.updateDecease(1L, decease);

        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals("Decease updated: Decease{id=1, name='Test Decease', tenure='6 months', totalTreatmentTenure='3 months', remainingTreatmentTenure='2 months', neededMedicineId='med123'}", response.getBody());
        verify(deceaseService, times(1)).updateDecease(anyLong(), any(Decease.class));
    }

    @Test
    void testUpdateDeceaseNotFound() {
        when(deceaseService.updateDecease(anyLong(), any(Decease.class))).thenReturn(null);

        ResponseEntity<String> response = deceaseController.updateDecease(1L, decease);

        assertEquals(HttpStatus.NOT_FOUND, response.getStatusCode());
        assertEquals("Decease not found", response.getBody());
    }

    @Test
    void testDeleteDecease() {
        doNothing().when(deceaseService).deleteDecease(anyLong());

        ResponseEntity<String> response = deceaseController.deleteDecease(1L);

        assertEquals(HttpStatus.NO_CONTENT, response.getStatusCode());
        assertEquals("Decease deleted", response.getBody());
        verify(deceaseService, times(1)).deleteDecease(anyLong());
    }
}
