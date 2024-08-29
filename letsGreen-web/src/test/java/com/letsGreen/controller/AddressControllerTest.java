package com.letsGreen.controller;

import com.letsGreen.entity.Address;
import com.letsGreen.service.AddressService;
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

class AddressControllerTest {

    @Mock
    private AddressService addressService;

    @InjectMocks
    private AddressController addressController;

    private Address address;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        address = new Address();
        address.setAddress_id(1L);
        address.setStreet("123 Elm Street");
        address.setCity("Springfield");
        address.setState("IL");
        address.setCountry("USA");
        address.setPostalCode("62701");
    }

    @Test
    void testCreateAddress() {
        when(addressService.createAddress(any(Address.class))).thenReturn(address);

        ResponseEntity<String> response = addressController.createAddress(address);

        assertEquals(HttpStatus.CREATED, response.getStatusCode());
        assertEquals("Address created with ID: 1", response.getBody());
        verify(addressService, times(1)).createAddress(any(Address.class));
    }

    @Test
    void testGetAddressById() {
        when(addressService.getAddressById(anyLong())).thenReturn(address);

        ResponseEntity<String> response = addressController.getAddressById(1L);

        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals("Address found: Address{id=1, street='123 Elm Street', city='Springfield', state='IL', country='USA', postalCode='62701'}", response.getBody());
        verify(addressService, times(1)).getAddressById(anyLong());
    }

    @Test
    void testGetAddressByIdNotFound() {
        when(addressService.getAddressById(anyLong())).thenReturn(null);

        ResponseEntity<String> response = addressController.getAddressById(1L);

        assertEquals(HttpStatus.NOT_FOUND, response.getStatusCode());
        assertEquals("Address not found", response.getBody());
    }

    @Test
    void testGetAllAddresses() {
        List<Address> addressList = Arrays.asList(address);
        when(addressService.getAllAddresses()).thenReturn(addressList);

        ResponseEntity<String> response = addressController.getAllAddresses();

        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals("All Addresses: [Address{id=1, street='123 Elm Street', city='Springfield', state='IL', country='USA', postalCode='62701'}]", response.getBody());
        verify(addressService, times(1)).getAllAddresses();
    }

    @Test
    void testUpdateAddress() {
        when(addressService.updateAddress(anyLong(), any(Address.class))).thenReturn(address);

        ResponseEntity<String> response = addressController.updateAddress(1L, address);

        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals("Address updated: Address{id=1, street='123 Elm Street', city='Springfield', state='IL', country='USA', postalCode='62701'}", response.getBody());
        verify(addressService, times(1)).updateAddress(anyLong(), any(Address.class));
    }

    @Test
    void testUpdateAddressNotFound() {
        when(addressService.updateAddress(anyLong(), any(Address.class))).thenReturn(null);

        ResponseEntity<String> response = addressController.updateAddress(1L, address);

        assertEquals(HttpStatus.NOT_FOUND, response.getStatusCode());
        assertEquals("Address not found", response.getBody());
    }

    @Test
    void testDeleteAddress() {
        doNothing().when(addressService).deleteAddress(anyLong());

        ResponseEntity<String> response = addressController.deleteAddress(1L);

        assertEquals(HttpStatus.NO_CONTENT, response.getStatusCode());
        assertEquals("Address deleted", response.getBody());
        verify(addressService, times(1)).deleteAddress(anyLong());
    }
}
