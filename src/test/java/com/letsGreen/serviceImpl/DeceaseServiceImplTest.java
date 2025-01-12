package com.letsGreen.serviceImpl;

import com.letsGreen.entity.Decease;
import com.letsGreen.repository.DeceaseRepository;
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

class DeceaseServiceImplTest {

    @Mock
    private DeceaseRepository deceaseRepository;

    @InjectMocks
    private DeceaseServiceImpl deceaseService;

    private Decease decease;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        decease = new Decease();
        decease.setId(1L);
        decease.setName("Leaf Rust");
       // decease.setDescription("A fungal disease that affects the leaves of plants.");
        // Initialize other fields if necessary
    }

    @Test
    void testCreateDecease() {
        when(deceaseRepository.save(any(Decease.class))).thenReturn(decease);

        Decease createdDecease = deceaseService.createDecease(decease);

        assertNotNull(createdDecease);
        assertEquals(1L, createdDecease.getId());
        assertEquals("Leaf Rust", createdDecease.getName());
        verify(deceaseRepository, times(1)).save(any(Decease.class));
    }

    @Test
    void testGetDeceaseById() {
        when(deceaseRepository.findById(anyLong())).thenReturn(Optional.of(decease));

        Decease foundDecease = deceaseService.getDeceaseById(1L);

        assertNotNull(foundDecease);
        assertEquals(1L, foundDecease.getId());
        verify(deceaseRepository, times(1)).findById(anyLong());
    }

    @Test
    void testGetDeceaseByIdNotFound() {
        when(deceaseRepository.findById(anyLong())).thenReturn(Optional.empty());

        Decease foundDecease = deceaseService.getDeceaseById(1L);

        assertNull(foundDecease);
        verify(deceaseRepository, times(1)).findById(anyLong());
    }

    @Test
    void testGetAllDeceases() {
        List<Decease> deceases = Arrays.asList(decease);
        when(deceaseRepository.findAll()).thenReturn(deceases);

        List<Decease> allDeceases = deceaseService.getAllDeceases();

        assertNotNull(allDeceases);
        assertEquals(1, allDeceases.size());
        verify(deceaseRepository, times(1)).findAll();
    }

    @Test
    void testUpdateDecease() {
        when(deceaseRepository.existsById(anyLong())).thenReturn(true);
        when(deceaseRepository.save(any(Decease.class))).thenReturn(decease);

        Decease updatedDecease = deceaseService.updateDecease(1L, decease);

        assertNotNull(updatedDecease);
        assertEquals(1L, updatedDecease.getId());
        assertEquals("Leaf Rust", updatedDecease.getName());
        verify(deceaseRepository, times(1)).existsById(anyLong());
        verify(deceaseRepository, times(1)).save(any(Decease.class));
    }

    @Test
    void testUpdateDeceaseNotFound() {
        when(deceaseRepository.existsById(anyLong())).thenReturn(false);

        Decease updatedDecease = deceaseService.updateDecease(1L, decease);

        assertNull(updatedDecease);
        verify(deceaseRepository, times(1)).existsById(anyLong());
        verify(deceaseRepository, never()).save(any(Decease.class));
    }

    @Test
    void testDeleteDecease() {
        doNothing().when(deceaseRepository).deleteById(anyLong());

        deceaseService.deleteDecease(1L);

        verify(deceaseRepository, times(1)).deleteById(anyLong());
    }
}
