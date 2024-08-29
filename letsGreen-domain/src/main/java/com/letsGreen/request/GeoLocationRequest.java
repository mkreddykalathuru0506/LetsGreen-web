package com.letsGreen.request;

import lombok.Data;
import java.io.Serializable;

@Data
public class GeoLocationRequest implements Serializable {
    private double latitude;
    private double longitude;
}
