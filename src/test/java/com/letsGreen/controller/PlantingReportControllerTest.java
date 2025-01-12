package com.letsGreen.controller;

import com.letsGreen.entity.PlantingReport;
import com.letsGreen.service.PlantingReportService;
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

class PlantingReportControllerTest {

    @Mock
    private PlantingReportService plantingReportService;

    @InjectMocks
    private PlantingReportController plantingReportController;

    private PlantingReport plantingReport;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        plantingReport = new PlantingReport();
        plantingReport.setId(1L);
        plantingReport.setTotalPlantsCount(100);
        plantingReport.setActivePlantsCount(80);
        plantingReport.setInactivePlantsCount(20);
       
    }

    @Test
    void testCreatePlantingReport() {
        when(plantingReportService.createPlantingReport(any(PlantingReport.class))).thenReturn(plantingReport);

        ResponseEntity<String> response = plantingReportController.createPlantingReport(plantingReport);

        assertEquals(HttpStatus.CREATED, response.getStatusCode());
        assertEquals("PlantingReport created with ID: 1", response.getBody());
        verify(plantingReportService, times(1)).createPlantingReport(any(PlantingReport.class));
    }

    @Test
    void testGetPlantingReportById() {
        when(plantingReportService.getPlantingReportById(anyLong())).thenReturn(plantingReport);

        ResponseEntity<String> response = plantingReportController.getPlantingReportById(1L);

        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals("PlantingReport found: PlantingReport{id=1, totalPlantsCount=100, activePlantsCount=80, inactivePlantsCount=20, plantingQuotient=80}", response.getBody());
        verify(plantingReportService, times(1)).getPlantingReportById(anyLong());
    }

    @Test
    void testGetPlantingReportByIdNotFound() {
        when(plantingReportService.getPlantingReportById(anyLong())).thenReturn(null);

        ResponseEntity<String> response = plantingReportController.getPlantingReportById(1L);

        assertEquals(HttpStatus.NOT_FOUND, response.getStatusCode());
        assertEquals("PlantingReport not found", response.getBody());
    }

    @Test
    void testGetAllPlantingReports() {
        List<PlantingReport> plantingReportList = Arrays.asList(plantingReport);
        when(plantingReportService.getAllPlantingReports()).thenReturn(plantingReportList);

        ResponseEntity<String> response = plantingReportController.getAllPlantingReports();

        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals("All PlantingReports: [PlantingReport{id=1, totalPlantsCount=100, activePlantsCount=80, inactivePlantsCount=20, plantingQuotient=80}]", response.getBody());
        verify(plantingReportService, times(1)).getAllPlantingReports();
    }

    @Test
    void testUpdatePlantingReport() {
        when(plantingReportService.updatePlantingReport(anyLong(), any(PlantingReport.class))).thenReturn(plantingReport);

        ResponseEntity<String> response = plantingReportController.updatePlantingReport(1L, plantingReport);

        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals("PlantingReport updated: PlantingReport{id=1, totalPlantsCount=100, activePlantsCount=80, inactivePlantsCount=20, plantingQuotient=80}", response.getBody());
        verify(plantingReportService, times(1)).updatePlantingReport(anyLong(), any(PlantingReport.class));
    }

    @Test
    void testUpdatePlantingReportNotFound() {
        when(plantingReportService.updatePlantingReport(anyLong(), any(PlantingReport.class))).thenReturn(null);

        ResponseEntity<String> response = plantingReportController.updatePlantingReport(1L, plantingReport);

        assertEquals(HttpStatus.NOT_FOUND, response.getStatusCode());
        assertEquals("PlantingReport not found", response.getBody());
    }

    @Test
    void testDeletePlantingReport() {
        doNothing().when(plantingReportService).deletePlantingReport(anyLong());

        ResponseEntity<String> response = plantingReportController.deletePlantingReport(1L);

        assertEquals(HttpStatus.NO_CONTENT, response.getStatusCode());
        assertEquals("PlantingReport deleted", response.getBody());
        verify(plantingReportService, times(1)).deletePlantingReport(anyLong());
    }
}
