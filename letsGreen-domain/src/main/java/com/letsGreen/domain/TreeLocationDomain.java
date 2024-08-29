package com.letsGreen.domain;

import lombok.Data;

@Data
public class TreeLocationDomain {
    private double latitude;
    private double longitude;
    private double altitude;
    private String address;
}
