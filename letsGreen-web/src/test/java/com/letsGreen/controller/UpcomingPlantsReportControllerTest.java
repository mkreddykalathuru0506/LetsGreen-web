package com.letsGreen.controller;

import com.letsGreen.entity.UpcomingPlantsReport;
import com.letsGreen.service.UpcomingPlantsReportService;
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

class UpcomingPlantsReportControllerTest {

    @Mock
    private UpcomingPlantsReportService upcomingPlantsReportService;

    @InjectMocks
    private UpcomingPlantsReportController upcomingPlantsReportController;

    private UpcomingPlantsReport upcomingPlantsReport;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        upcomingPlantsReport = new UpcomingPlantsReport();
        upcomingPlantsReport.setPlantId(1L);
        upcomingPlantsReport.setName("Oak");
        
        // Initialize other fields if necessary
    }

    @Test
    void testCreateUpcomingPlantsReport() {
        when(upcomingPlantsReportService.createUpcomingPlantsReport(any(UpcomingPlantsReport.class)))
                .thenReturn(upcomingPlantsReport);

        ResponseEntity<String> response = upcomingPlantsReportController.createUpcomingPlantsReport(upcomingPlantsReport);

        assertEquals(HttpStatus.CREATED, response.getStatusCode());
        assertEquals("UpcomingPlantsReport created with Plant ID: " + upcomingPlantsReport.getPlantId(), response.getBody());
        verify(upcomingPlantsReportService, times(1)).createUpcomingPlantsReport(any(UpcomingPlantsReport.class));
    }

    @Test
    void testGetUpcomingPlantsReportById() {
        when(upcomingPlantsReportService.getUpcomingPlantsReportById(anyLong())).thenReturn(upcomingPlantsReport);

        ResponseEntity<String> response = upcomingPlantsReportController.getUpcomingPlantsReportById(1L);

        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals("UpcomingPlantsReport found: " + upcomingPlantsReport.toString(), response.getBody());
        verify(upcomingPlantsReportService, times(1)).getUpcomingPlantsReportById(anyLong());
    }

    @Test
    void testGetUpcomingPlantsReportByIdNotFound() {
        when(upcomingPlantsReportService.getUpcomingPlantsReportById(anyLong())).thenReturn(null);

        ResponseEntity<String> response = upcomingPlantsReportController.getUpcomingPlantsReportById(1L);

        assertEquals(HttpStatus.NOT_FOUND, response.getStatusCode());
        assertEquals("UpcomingPlantsReport not found", response.getBody());
    }

    @Test
    void testGetAllUpcomingPlantsReports() {
        List<UpcomingPlantsReport> upcomingPlantsReportList = Arrays.asList(upcomingPlantsReport);
        when(upcomingPlantsReportService.getAllUpcomingPlantsReports()).thenReturn(upcomingPlantsReportList);

        ResponseEntity<String> response = upcomingPlantsReportController.getAllUpcomingPlantsReports();

        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals("All UpcomingPlantsReports: " + upcomingPlantsReportList.toString(), response.getBody());
        verify(upcomingPlantsReportService, times(1)).getAllUpcomingPlantsReports();
    }

    @Test
    void testUpdateUpcomingPlantsReport() {
        when(upcomingPlantsReportService.updateUpcomingPlantsReport(anyLong(), any(UpcomingPlantsReport.class)))
                .thenReturn(upcomingPlantsReport);

        ResponseEntity<String> response = upcomingPlantsReportController.updateUpcomingPlantsReport(1L, upcomingPlantsReport);

        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals("UpcomingPlantsReport updated: " + upcomingPlantsReport.toString(), response.getBody());
        verify(upcomingPlantsReportService, times(1)).updateUpcomingPlantsReport(anyLong(), any(UpcomingPlantsReport.class));
    }

    @Test
    void testUpdateUpcomingPlantsReportNotFound() {
        when(upcomingPlantsReportService.updateUpcomingPlantsReport(anyLong(), any(UpcomingPlantsReport.class)))
                .thenReturn(null);

        ResponseEntity<String> response = upcomingPlantsReportController.updateUpcomingPlantsReport(1L, upcomingPlantsReport);

        assertEquals(HttpStatus.NOT_FOUND, response.getStatusCode());
        assertEquals("UpcomingPlantsReport not found", response.getBody());
    }

    @Test
    void testDeleteUpcomingPlantsReport() {
        doNothing().when(upcomingPlantsReportService).deleteUpcomingPlantsReport(anyLong());

        ResponseEntity<String> response = upcomingPlantsReportController.deleteUpcomingPlantsReport(1L);

        assertEquals(HttpStatus.NO_CONTENT, response.getStatusCode());
        assertEquals("UpcomingPlantsReport deleted", response.getBody());
        verify(upcomingPlantsReportService, times(1)).deleteUpcomingPlantsReport(anyLong());
    }
}
