package com.letsGreen.serviceImpl;

import com.letsGreen.entity.PlantingReport;
import com.letsGreen.repository.PlantingReportRepository;
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

class PlantingReportServiceImplTest {

    @Mock
    private PlantingReportRepository plantingReportRepository;

    @InjectMocks
    private PlantingReportServiceImpl plantingReportService;

    private PlantingReport plantingReport;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        plantingReport = new PlantingReport();
        plantingReport.setId(1L);
        //plantingReport.setTreeType("Oak");
        //plantingReport.setQuantity(50);
        // Initialize other fields if necessary
    }

    @Test
    void testCreatePlantingReport() {
        when(plantingReportRepository.save(any(PlantingReport.class))).thenReturn(plantingReport);

        PlantingReport createdPlantingReport = plantingReportService.createPlantingReport(plantingReport);

        assertNotNull(createdPlantingReport);
        assertEquals(1L, createdPlantingReport.getId());
      //  assertEquals("Oak", createdPlantingReport.getTreeType());
        verify(plantingReportRepository, times(1)).save(any(PlantingReport.class));
    }

    @Test
    void testGetPlantingReportById() {
        when(plantingReportRepository.findById(anyLong())).thenReturn(Optional.of(plantingReport));

        PlantingReport foundPlantingReport = plantingReportService.getPlantingReportById(1L);

        assertNotNull(foundPlantingReport);
        assertEquals(1L, foundPlantingReport.getId());
        verify(plantingReportRepository, times(1)).findById(anyLong());
    }

    @Test
    void testGetPlantingReportByIdNotFound() {
        when(plantingReportRepository.findById(anyLong())).thenReturn(Optional.empty());

        PlantingReport foundPlantingReport = plantingReportService.getPlantingReportById(1L);

        assertNull(foundPlantingReport);
        verify(plantingReportRepository, times(1)).findById(anyLong());
    }

    @Test
    void testGetAllPlantingReports() {
        List<PlantingReport> plantingReports = Arrays.asList(plantingReport);
        when(plantingReportRepository.findAll()).thenReturn(plantingReports);

        List<PlantingReport> allPlantingReports = plantingReportService.getAllPlantingReports();

        assertNotNull(allPlantingReports);
        assertEquals(1, allPlantingReports.size());
        verify(plantingReportRepository, times(1)).findAll();
    }

    @Test
    void testUpdatePlantingReport() {
        when(plantingReportRepository.existsById(anyLong())).thenReturn(true);
        when(plantingReportRepository.save(any(PlantingReport.class))).thenReturn(plantingReport);

        PlantingReport updatedPlantingReport = plantingReportService.updatePlantingReport(1L, plantingReport);

        assertNotNull(updatedPlantingReport);
        assertEquals(1L, updatedPlantingReport.getId());
      //  assertEquals("Oak", updatedPlantingReport.getTreeType());
        verify(plantingReportRepository, times(1)).existsById(anyLong());
        verify(plantingReportRepository, times(1)).save(any(PlantingReport.class));
    }

    @Test
    void testUpdatePlantingReportNotFound() {
        when(plantingReportRepository.existsById(anyLong())).thenReturn(false);

        PlantingReport updatedPlantingReport = plantingReportService.updatePlantingReport(1L, plantingReport);

        assertNull(updatedPlantingReport);
        verify(plantingReportRepository, times(1)).existsById(anyLong());
        verify(plantingReportRepository, never()).save(any(PlantingReport.class));
    }

    @Test
    void testDeletePlantingReport() {
        doNothing().when(plantingReportRepository).deleteById(anyLong());

        plantingReportService.deletePlantingReport(1L);

        verify(plantingReportRepository, times(1)).deleteById(anyLong());
    }
}
