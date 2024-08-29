package com.letsGreen.service;

import com.letsGreen.entity.Address;
import java.util.List;

public interface AddressService {
    Address createAddress(Address address);
    Address getAddressById(Long id);
    List<Address> getAllAddresses();
    Address updateAddress(Long id, Address address);
    void deleteAddress(Long id);
}
