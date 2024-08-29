package com.letsGreen.request;

import lombok.Data;
import java.io.Serializable;

@Data
public class AddressRequest implements Serializable {
    private String street;
    private String city;
    private String state;
    private String country;
    private String postalCode;
}
