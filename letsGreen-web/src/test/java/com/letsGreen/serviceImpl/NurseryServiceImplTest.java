package com.letsGreen.serviceImpl;

import com.letsGreen.entity.Nursery;
import com.letsGreen.repository.NurseryRepository;
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

class NurseryServiceImplTest {

    @Mock
    private NurseryRepository nurseryRepository;

    @InjectMocks
    private NurseryServiceImpl nurseryService;

    private Nursery nursery;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        nursery = new Nursery();
        nursery.setId(1L);
      //  nursery.setName("Green Nursery");
      //  nursery.setLocation("Green City");
        // Initialize other fields if necessary
    }

    @Test
    void testCreateNursery() {
        when(nurseryRepository.save(any(Nursery.class))).thenReturn(nursery);

        Nursery createdNursery = nurseryService.createNursery(nursery);

        assertNotNull(createdNursery);
        assertEquals(1L, createdNursery.getId());
      //  assertEquals("Green Nursery", createdNursery.getName());
        verify(nurseryRepository, times(1)).save(any(Nursery.class));
    }

    @Test
    void testGetNurseryById() {
        when(nurseryRepository.findById(anyLong())).thenReturn(Optional.of(nursery));

        Nursery foundNursery = nurseryService.getNurseryById(1L);

        assertNotNull(foundNursery);
        assertEquals(1L, foundNursery.getId());
        verify(nurseryRepository, times(1)).findById(anyLong());
    }

    @Test
    void testGetNurseryByIdNotFound() {
        when(nurseryRepository.findById(anyLong())).thenReturn(Optional.empty());

        Nursery foundNursery = nurseryService.getNurseryById(1L);

        assertNull(foundNursery);
        verify(nurseryRepository, times(1)).findById(anyLong());
    }

    @Test
    void testGetAllNurseries() {
        List<Nursery> nurseries = Arrays.asList(nursery);
        when(nurseryRepository.findAll()).thenReturn(nurseries);

        List<Nursery> allNurseries = nurseryService.getAllNurseries();

        assertNotNull(allNurseries);
        assertEquals(1, allNurseries.size());
        verify(nurseryRepository, times(1)).findAll();
    }

    @Test
    void testUpdateNursery() {
        when(nurseryRepository.existsById(anyLong())).thenReturn(true);
        when(nurseryRepository.save(any(Nursery.class))).thenReturn(nursery);

        Nursery updatedNursery = nurseryService.updateNursery(1L, nursery);

        assertNotNull(updatedNursery);
        assertEquals(1L, updatedNursery.getId());
      //  assertEquals("Green Nursery", updatedNursery.getName());
        verify(nurseryRepository, times(1)).existsById(anyLong());
        verify(nurseryRepository, times(1)).save(any(Nursery.class));
    }

    @Test
    void testUpdateNurseryNotFound() {
        when(nurseryRepository.existsById(anyLong())).thenReturn(false);

        Nursery updatedNursery = nurseryService.updateNursery(1L, nursery);

        assertNull(updatedNursery);
        verify(nurseryRepository, times(1)).existsById(anyLong());
        verify(nurseryRepository, never()).save(any(Nursery.class));
    }

    @Test
    void testDeleteNursery() {
        doNothing().when(nurseryRepository).deleteById(anyLong());

        nurseryService.deleteNursery(1L);

        verify(nurseryRepository, times(1)).deleteById(anyLong());
    }
}
