package com.letsGreen.serviceImpl;

import com.letsGreen.entity.UpcomingPlantsReport;
import com.letsGreen.repository.UpcomingPlantsReportRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.*;

class UpcomingPlantsReportServiceImplTest {

    @Mock
    private UpcomingPlantsReportRepository upcomingPlantsReportRepository;

    @InjectMocks
    private UpcomingPlantsReportServiceImpl upcomingPlantsReportService;

    private UpcomingPlantsReport upcomingPlantsReport;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        upcomingPlantsReport = new UpcomingPlantsReport();
        upcomingPlantsReport.setPlantId(1L);
       // upcomingPlantsReport.setReportDetails("Sample Report Details");
        // Initialize other fields as needed
    }

    @Test
    void testCreateUpcomingPlantsReport() {
        when(upcomingPlantsReportRepository.save(any(UpcomingPlantsReport.class))).thenReturn(upcomingPlantsReport);

        UpcomingPlantsReport createdReport = upcomingPlantsReportService.createUpcomingPlantsReport(upcomingPlantsReport);

        assertNotNull(createdReport);
        assertEquals(1L, createdReport.getPlantId());
       // assertEquals("Sample Report Details", createdReport.getReportDetails());
        // Assert other fields if needed
        verify(upcomingPlantsReportRepository, times(1)).save(any(UpcomingPlantsReport.class));
    }

    @Test
    void testGetUpcomingPlantsReportById() {
        when(upcomingPlantsReportRepository.findById(anyLong())).thenReturn(Optional.of(upcomingPlantsReport));

        UpcomingPlantsReport foundReport = upcomingPlantsReportService.getUpcomingPlantsReportById(1L);

        assertNotNull(foundReport);
        assertEquals(1L, foundReport.getPlantId());
       // assertEquals("Sample Report Details", foundReport.getReportDetails());
        // Assert other fields if needed
        verify(upcomingPlantsReportRepository, times(1)).findById(anyLong());
    }

    @Test
    void testGetUpcomingPlantsReportByIdNotFound() {
        when(upcomingPlantsReportRepository.findById(anyLong())).thenReturn(Optional.empty());

        UpcomingPlantsReport foundReport = upcomingPlantsReportService.getUpcomingPlantsReportById(1L);

        assertNull(foundReport);
        verify(upcomingPlantsReportRepository, times(1)).findById(anyLong());
    }

    @Test
    void testGetAllUpcomingPlantsReports() {
        List<UpcomingPlantsReport> reports = Arrays.asList(upcomingPlantsReport);
        when(upcomingPlantsReportRepository.findAll()).thenReturn(reports);

        List<UpcomingPlantsReport> allReports = upcomingPlantsReportService.getAllUpcomingPlantsReports();

        assertNotNull(allReports);
        assertEquals(1, allReports.size());
        assertEquals(1L, allReports.get(0).getPlantId());
       // assertEquals("Sample Report Details", allReports.get(0).getReportDetails());
        verify(upcomingPlantsReportRepository, times(1)).findAll();
    }

    @Test
    void testUpdateUpcomingPlantsReport() {
        UpcomingPlantsReport updatedReport = new UpcomingPlantsReport();
        updatedReport.setPlantId(1L);
       // updatedReport.setReportDetails("Updated Report Details");
        // Set other updated fields as needed

        when(upcomingPlantsReportRepository.findById(anyLong())).thenReturn(Optional.of(upcomingPlantsReport));
        when(upcomingPlantsReportRepository.save(any(UpcomingPlantsReport.class))).thenReturn(updatedReport);

        UpcomingPlantsReport result = upcomingPlantsReportService.updateUpcomingPlantsReport(1L, updatedReport);

       // assertNotNull(result);
        //assertEquals(1L, result.getPlantId());
       // assertEquals("Updated Report Details", result.getReportDetails());
        // Assert other updated fields if needed
        verify(upcomingPlantsReportRepository, times(1)).findById(anyLong());
        verify(upcomingPlantsReportRepository, times(1)).save(any(UpcomingPlantsReport.class));
    }

    @Test
    void testUpdateUpcomingPlantsReportNotFound() {
        UpcomingPlantsReport updatedReport = new UpcomingPlantsReport();
        updatedReport.setPlantId(1L);
       // updatedReport.setReportDetails("Updated Report Details");
        // Set other updated fields as needed

        when(upcomingPlantsReportRepository.findById(anyLong())).thenReturn(Optional.empty());

        UpcomingPlantsReport result = upcomingPlantsReportService.updateUpcomingPlantsReport(1L, updatedReport);

        assertNull(result);
       // verify(upcomingPlantsReportRepository, times(1)).findById(anyLong());
        verify(upcomingPlantsReportRepository, never()).save(any(UpcomingPlantsReport.class));
    }

    @Test
    void testDeleteUpcomingPlantsReport() {
        doNothing().when(upcomingPlantsReportRepository).deleteById(anyLong());

        upcomingPlantsReportService.deleteUpcomingPlantsReport(1L);

        verify(upcomingPlantsReportRepository, times(1)).deleteById(anyLong());
    }
}
