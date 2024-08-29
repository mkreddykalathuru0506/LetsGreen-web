package com.letsGreen.controller;

import com.letsGreen.entity.TreeLocation;
import com.letsGreen.service.TreeLocationService;
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

class TreeLocationControllerTest {

    @Mock
    private TreeLocationService treeLocationService;

    @InjectMocks
    private TreeLocationController treeLocationController;

    private TreeLocation treeLocation;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        treeLocation = new TreeLocation();
        treeLocation.setId(1L);
		/*
		 * treeLocation.setLatitude(12.34); treeLocation.setLongitude(56.78);
		 * treeLocation.setAltitude(100.0);
		 * treeLocation.setAddress("123 Tree St, Forest City");
		 */
        // Initialize other fields if necessary
    }

    @Test
    void testCreateTreeLocation() {
        when(treeLocationService.createTreeLocation(any(TreeLocation.class))).thenReturn(treeLocation);

        ResponseEntity<String> response = treeLocationController.createTreeLocation(treeLocation);

        assertEquals(HttpStatus.CREATED, response.getStatusCode());
        assertEquals("TreeLocation created with ID: " + treeLocation.getId(), response.getBody());
        verify(treeLocationService, times(1)).createTreeLocation(any(TreeLocation.class));
    }

    @Test
    void testGetTreeLocationById() {
        when(treeLocationService.getTreeLocationById(anyLong())).thenReturn(treeLocation);

        ResponseEntity<String> response = treeLocationController.getTreeLocationById(1L);

        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals("TreeLocation found: " + treeLocation.toString(), response.getBody());
        verify(treeLocationService, times(1)).getTreeLocationById(anyLong());
    }

    @Test
    void testGetTreeLocationByIdNotFound() {
        when(treeLocationService.getTreeLocationById(anyLong())).thenReturn(null);

        ResponseEntity<String> response = treeLocationController.getTreeLocationById(1L);

        assertEquals(HttpStatus.NOT_FOUND, response.getStatusCode());
        assertEquals("TreeLocation not found", response.getBody());
    }

    @Test
    void testGetAllTreeLocations() {
        List<TreeLocation> treeLocationList = Arrays.asList(treeLocation);
        when(treeLocationService.getAllTreeLocations()).thenReturn(treeLocationList);

        ResponseEntity<String> response = treeLocationController.getAllTreeLocations();

        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals("All TreeLocations: " + treeLocationList.toString(), response.getBody());
        verify(treeLocationService, times(1)).getAllTreeLocations();
    }

    @Test
    void testUpdateTreeLocation() {
        when(treeLocationService.updateTreeLocation(anyLong(), any(TreeLocation.class))).thenReturn(treeLocation);

        ResponseEntity<String> response = treeLocationController.updateTreeLocation(1L, treeLocation);

        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals("TreeLocation updated: " + treeLocation.toString(), response.getBody());
        verify(treeLocationService, times(1)).updateTreeLocation(anyLong(), any(TreeLocation.class));
    }

    @Test
    void testUpdateTreeLocationNotFound() {
        when(treeLocationService.updateTreeLocation(anyLong(), any(TreeLocation.class))).thenReturn(null);

        ResponseEntity<String> response = treeLocationController.updateTreeLocation(1L, treeLocation);

        assertEquals(HttpStatus.NOT_FOUND, response.getStatusCode());
        assertEquals("TreeLocation not found", response.getBody());
    }

    @Test
    void testDeleteTreeLocation() {
        doNothing().when(treeLocationService).deleteTreeLocation(anyLong());

        ResponseEntity<String> response = treeLocationController.deleteTreeLocation(1L);

        assertEquals(HttpStatus.NO_CONTENT, response.getStatusCode());
        assertEquals("TreeLocation deleted", response.getBody());
        verify(treeLocationService, times(1)).deleteTreeLocation(anyLong());
    }
}
