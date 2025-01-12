package com.letsGreen.serviceImpl;

import com.letsGreen.entity.TreeLocation;
import com.letsGreen.repository.TreeLocationRepository;
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

class TreeLocationServiceImplTest {

    @Mock
    private TreeLocationRepository treeLocationRepository;

    @InjectMocks
    private TreeLocationServiceImpl treeLocationService;

    private TreeLocation treeLocation;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        treeLocation = new TreeLocation();
        treeLocation.setId(1L);
        //treeLocation.setLatitude(40.7128);
       // treeLocation.setLongitude(-74.0060);
        //treeLocation.setDescription("Central Park");
    }

    @Test
    void testCreateTreeLocation() {
        when(treeLocationRepository.save(any(TreeLocation.class))).thenReturn(treeLocation);

        TreeLocation createdTreeLocation = treeLocationService.createTreeLocation(treeLocation);

        assertNotNull(createdTreeLocation);
        assertEquals(1L, createdTreeLocation.getId());
        //assertEquals(40.7128, createdTreeLocation.getLatitude());
       // assertEquals(-74.0060, createdTreeLocation.getLongitude());
       // assertEquals("Central Park", createdTreeLocation.getDescription());
        verify(treeLocationRepository, times(1)).save(any(TreeLocation.class));
    }

    @Test
    void testGetTreeLocationById() {
        when(treeLocationRepository.findById(anyLong())).thenReturn(Optional.of(treeLocation));

        TreeLocation foundTreeLocation = treeLocationService.getTreeLocationById(1L);

        assertNotNull(foundTreeLocation);
        assertEquals(1L, foundTreeLocation.getId());
        //assertEquals(40.7128, foundTreeLocation.getLatitude());
        //assertEquals(-74.0060, foundTreeLocation.getLongitude());
        //assertEquals("Central Park", foundTreeLocation.getDescription());
        verify(treeLocationRepository, times(1)).findById(anyLong());
    }

    @Test
    void testGetTreeLocationByIdNotFound() {
        when(treeLocationRepository.findById(anyLong())).thenReturn(Optional.empty());

        TreeLocation foundTreeLocation = treeLocationService.getTreeLocationById(1L);

        assertNull(foundTreeLocation);
        verify(treeLocationRepository, times(1)).findById(anyLong());
    }

    @Test
    void testGetAllTreeLocations() {
        List<TreeLocation> treeLocations = Arrays.asList(treeLocation);
        when(treeLocationRepository.findAll()).thenReturn(treeLocations);

        List<TreeLocation> allTreeLocations = treeLocationService.getAllTreeLocations();

        assertNotNull(allTreeLocations);
        assertEquals(1, allTreeLocations.size());
        verify(treeLocationRepository, times(1)).findAll();
    }

    @Test
    void testUpdateTreeLocation() {
        when(treeLocationRepository.existsById(anyLong())).thenReturn(true);
        when(treeLocationRepository.save(any(TreeLocation.class))).thenReturn(treeLocation);

        TreeLocation updatedTreeLocation = treeLocationService.updateTreeLocation(1L, treeLocation);

        assertNotNull(updatedTreeLocation);
        assertEquals(1L, updatedTreeLocation.getId());
        //assertEquals(40.7128, updatedTreeLocation.getLatitude());
       // assertEquals(-74.0060, updatedTreeLocation.getLongitude());
        //assertEquals("Central Park", updatedTreeLocation.getDescription());
        verify(treeLocationRepository, times(1)).existsById(anyLong());
        verify(treeLocationRepository, times(1)).save(any(TreeLocation.class));
    }

    @Test
    void testUpdateTreeLocationNotFound() {
        when(treeLocationRepository.existsById(anyLong())).thenReturn(false);

        TreeLocation updatedTreeLocation = treeLocationService.updateTreeLocation(1L, treeLocation);

        assertNull(updatedTreeLocation);
        verify(treeLocationRepository, times(1)).existsById(anyLong());
        verify(treeLocationRepository, never()).save(any(TreeLocation.class));
    }

    @Test
    void testDeleteTreeLocation() {
        doNothing().when(treeLocationRepository).deleteById(anyLong());

        treeLocationService.deleteTreeLocation(1L);

        verify(treeLocationRepository, times(1)).deleteById(anyLong());
    }
}
