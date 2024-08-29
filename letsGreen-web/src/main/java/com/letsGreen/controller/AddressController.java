package com.letsGreen.controller;

import com.letsGreen.entity.Address;
import com.letsGreen.service.AddressService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/addresses")
public class AddressController {

    @Autowired
    private AddressService addressService;

    @PostMapping
    public ResponseEntity<String> createAddress(@RequestBody Address address) {
        Address createdAddress = addressService.createAddress(address);
        return new ResponseEntity<>("Address created with ID: " + createdAddress.getAddress_id(), HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<String> getAddressById(@PathVariable Long id) {
        Address address = addressService.getAddressById(id);
        if (address != null) {
            return new ResponseEntity<>("Address found: " + address.toString(), HttpStatus.OK);
        } else {
            return new ResponseEntity<>("Address not found", HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping
    public ResponseEntity<String> getAllAddresses() {
        List<Address> addresses = addressService.getAllAddresses();
        return new ResponseEntity<>("All Addresses: " + addresses.toString(), HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<String> updateAddress(@PathVariable Long id, @RequestBody Address address) {
        Address updatedAddress = addressService.updateAddress(id, address);
        if (updatedAddress != null) {
            return new ResponseEntity<>("Address updated: " + updatedAddress.toString(), HttpStatus.OK);
        } else {
            return new ResponseEntity<>("Address not found", HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteAddress(@PathVariable Long id) {
        addressService.deleteAddress(id);
        return new ResponseEntity<>("Address deleted", HttpStatus.NO_CONTENT);
    }
}
