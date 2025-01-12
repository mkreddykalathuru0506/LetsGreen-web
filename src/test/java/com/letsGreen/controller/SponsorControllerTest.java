package com.letsGreen.controller;

import com.letsGreen.entity.Sponsor;
import com.letsGreen.service.SponsorService;
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

class SponsorControllerTest {

    @Mock
    private SponsorService sponsorService;

    @InjectMocks
    private SponsorController sponsorController;

    private Sponsor sponsor;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        sponsor = new Sponsor();
        sponsor.setSponser_id(1L);
        sponsor.setName("John Doe");
        sponsor.setPhoneNumber("1234567890");
        sponsor.setOccupation("Philanthropist");
        sponsor.setTotalTrees(10);
    }

    @Test
    void testCreateSponsor() {
        when(sponsorService.createSponsor(any(Sponsor.class))).thenReturn(sponsor);

        ResponseEntity<String> response = sponsorController.createSponsor(sponsor);

        assertEquals(HttpStatus.CREATED, response.getStatusCode());
        assertEquals("Sponsor created with ID: " + sponsor.getSponser_id(), response.getBody());
        verify(sponsorService, times(1)).createSponsor(any(Sponsor.class));
    }

    @Test
    void testGetSponsorById() {
        when(sponsorService.getSponsorById(anyLong())).thenReturn(sponsor);

        ResponseEntity<String> response = sponsorController.getSponsorById(1L);

        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals("Sponsor found: " + sponsor.toString(), response.getBody());
        verify(sponsorService, times(1)).getSponsorById(anyLong());
    }

    @Test
    void testGetSponsorByIdNotFound() {
        when(sponsorService.getSponsorById(anyLong())).thenReturn(null);

        ResponseEntity<String> response = sponsorController.getSponsorById(1L);

        assertEquals(HttpStatus.NOT_FOUND, response.getStatusCode());
        assertEquals("Sponsor not found", response.getBody());
    }

    @Test
    void testGetAllSponsors() {
        List<Sponsor> sponsorList = Arrays.asList(sponsor);
        when(sponsorService.getAllSponsors()).thenReturn(sponsorList);

        ResponseEntity<String> response = sponsorController.getAllSponsors();

        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals("All Sponsors: " + sponsorList.toString(), response.getBody());
        verify(sponsorService, times(1)).getAllSponsors();
    }

    @Test
    void testUpdateSponsor() {
        when(sponsorService.updateSponsor(anyLong(), any(Sponsor.class))).thenReturn(sponsor);

        ResponseEntity<String> response = sponsorController.updateSponsor(1L, sponsor);

        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals("Sponsor updated: " + sponsor.toString(), response.getBody());
        verify(sponsorService, times(1)).updateSponsor(anyLong(), any(Sponsor.class));
    }

    @Test
    void testUpdateSponsorNotFound() {
        when(sponsorService.updateSponsor(anyLong(), any(Sponsor.class))).thenReturn(null);

        ResponseEntity<String> response = sponsorController.updateSponsor(1L, sponsor);

        assertEquals(HttpStatus.NOT_FOUND, response.getStatusCode());
        assertEquals("Sponsor not found", response.getBody());
    }

    @Test
    void testDeleteSponsor() {
        doNothing().when(sponsorService).deleteSponsor(anyLong());

        ResponseEntity<String> response = sponsorController.deleteSponsor(1L);

        assertEquals(HttpStatus.NO_CONTENT, response.getStatusCode());
        assertEquals("Sponsor deleted", response.getBody());
        verify(sponsorService, times(1)).deleteSponsor(anyLong());
    }
}
