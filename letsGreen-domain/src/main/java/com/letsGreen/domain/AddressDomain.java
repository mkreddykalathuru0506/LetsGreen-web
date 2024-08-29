package com.letsGreen.domain;

import lombok.Data;

@Data
public class AddressDomain {
    private String street;
    private String city;
    private String state;
    private String country;
    private String postalCode;

}
