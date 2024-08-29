package com.letsGreen.request;

import lombok.Data;
import java.io.Serializable;

@Data
public class TreeLocationRequest implements Serializable {
    private double latitude;
    private double longitude;
    private double altitude;
    private String address;
}
