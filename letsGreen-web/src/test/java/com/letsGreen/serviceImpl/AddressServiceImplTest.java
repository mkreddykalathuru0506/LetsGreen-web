package com.letsGreen.serviceImpl;

import com.letsGreen.entity.Address;
import com.letsGreen.repository.AddressRepository;
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

class AddressServiceImplTest {

    @Mock
    private AddressRepository addressRepository;

    @InjectMocks
    private AddressServiceImpl addressService;

    private Address address;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        address = new Address();
        address.setAddress_id(1L);
        address.setStreet("123 Green St");
        address.setCity("Green City");
       // address.setZipCode("12345");
        // Initialize other fields if necessary
    }

    @Test
    void testCreateAddress() {
        when(addressRepository.save(any(Address.class))).thenReturn(address);

        Address createdAddress = addressService.createAddress(address);

        assertNotNull(createdAddress);
        assertEquals(1L, createdAddress.getAddress_id());
        assertEquals("123 Green St", createdAddress.getStreet());
        verify(addressRepository, times(1)).save(any(Address.class));
    }

    @Test
    void testGetAddressById() {
        when(addressRepository.findById(anyLong())).thenReturn(Optional.of(address));

        Address foundAddress = addressService.getAddressById(1L);

        assertNotNull(foundAddress);
        assertEquals(1L, foundAddress.getAddress_id());
        verify(addressRepository, times(1)).findById(anyLong());
    }

    @Test
    void testGetAddressByIdNotFound() {
        when(addressRepository.findById(anyLong())).thenReturn(Optional.empty());

        Address foundAddress = addressService.getAddressById(1L);

        assertNull(foundAddress);
        verify(addressRepository, times(1)).findById(anyLong());
    }

    @Test
    void testGetAllAddresses() {
        List<Address> addresses = Arrays.asList(address);
        when(addressRepository.findAll()).thenReturn(addresses);

        List<Address> allAddresses = addressService.getAllAddresses();

        assertNotNull(allAddresses);
        assertEquals(1, allAddresses.size());
        verify(addressRepository, times(1)).findAll();
    }

    @Test
    void testUpdateAddress() {
        when(addressRepository.existsById(anyLong())).thenReturn(true);
        when(addressRepository.save(any(Address.class))).thenReturn(address);

        Address updatedAddress = addressService.updateAddress(1L, address);

        assertNotNull(updatedAddress);
        assertEquals(1L, updatedAddress.getAddress_id());
        assertEquals("123 Green St", updatedAddress.getStreet());
        verify(addressRepository, times(1)).existsById(anyLong());
        verify(addressRepository, times(1)).save(any(Address.class));
    }

    @Test
    void testUpdateAddressNotFound() {
        when(addressRepository.existsById(anyLong())).thenReturn(false);

        Address updatedAddress = addressService.updateAddress(1L, address);

        assertNull(updatedAddress);
        verify(addressRepository, times(1)).existsById(anyLong());
        verify(addressRepository, never()).save(any(Address.class));
    }

    @Test
    void testDeleteAddress() {
        doNothing().when(addressRepository).deleteById(anyLong());

        addressService.deleteAddress(1L);

        verify(addressRepository, times(1)).deleteById(anyLong());
    }
}
