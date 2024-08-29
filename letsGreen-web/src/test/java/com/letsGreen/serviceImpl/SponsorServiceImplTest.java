package com.letsGreen.serviceImpl;

import com.letsGreen.entity.Sponsor;
import com.letsGreen.repository.SponsorRepository;
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

class SponsorServiceImplTest {

    @Mock
    private SponsorRepository sponsorRepository;

    @InjectMocks
    private SponsorServiceImpl sponsorService;

    private Sponsor sponsor;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        sponsor = new Sponsor();
        sponsor.setSponser_id(1L);
        sponsor.setName("Test Sponsor");
    }

    @Test
    void testCreateSponsor() {
        when(sponsorRepository.save(any(Sponsor.class))).thenReturn(sponsor);

        Sponsor createdSponsor = sponsorService.createSponsor(sponsor);

        assertNotNull(createdSponsor);
        assertEquals(1L, createdSponsor.getSponser_id());
        assertEquals("Test Sponsor", createdSponsor.getName());
        verify(sponsorRepository, times(1)).save(any(Sponsor.class));
    }

    @Test
    void testGetSponsorById() {
        when(sponsorRepository.findById(anyLong())).thenReturn(Optional.of(sponsor));

        Sponsor foundSponsor = sponsorService.getSponsorById(1L);

        assertNotNull(foundSponsor);
        assertEquals(1L, foundSponsor.getSponser_id());
        assertEquals("Test Sponsor", foundSponsor.getName());
        verify(sponsorRepository, times(1)).findById(anyLong());
    }

    @Test
    void testGetSponsorByIdNotFound() {
        when(sponsorRepository.findById(anyLong())).thenReturn(Optional.empty());

        Sponsor foundSponsor = sponsorService.getSponsorById(1L);

        assertNull(foundSponsor);
        verify(sponsorRepository, times(1)).findById(anyLong());
    }

    @Test
    void testGetAllSponsors() {
        List<Sponsor> sponsors = Arrays.asList(sponsor);
        when(sponsorRepository.findAll()).thenReturn(sponsors);

        List<Sponsor> allSponsors = sponsorService.getAllSponsors();

        assertNotNull(allSponsors);
        assertEquals(1, allSponsors.size());
        verify(sponsorRepository, times(1)).findAll();
    }

    @Test
    void testUpdateSponsor() {
        when(sponsorRepository.existsById(anyLong())).thenReturn(true);
        when(sponsorRepository.save(any(Sponsor.class))).thenReturn(sponsor);

        Sponsor updatedSponsor = sponsorService.updateSponsor(1L, sponsor);

        assertNotNull(updatedSponsor);
        assertEquals(1L, updatedSponsor.getSponser_id());
        assertEquals("Test Sponsor", updatedSponsor.getName());
        verify(sponsorRepository, times(1)).existsById(anyLong());
        verify(sponsorRepository, times(1)).save(any(Sponsor.class));
    }

    @Test
    void testUpdateSponsorNotFound() {
        when(sponsorRepository.existsById(anyLong())).thenReturn(false);

        Sponsor updatedSponsor = sponsorService.updateSponsor(1L, sponsor);

        assertNull(updatedSponsor);
        verify(sponsorRepository, times(1)).existsById(anyLong());
        verify(sponsorRepository, never()).save(any(Sponsor.class));
    }

    @Test
    void testDeleteSponsor() {
        doNothing().when(sponsorRepository).deleteById(anyLong());

        sponsorService.deleteSponsor(1L);

        verify(sponsorRepository, times(1)).deleteById(anyLong());
    }
}
