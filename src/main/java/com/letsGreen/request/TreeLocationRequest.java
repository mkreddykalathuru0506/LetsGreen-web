package com.letsGreen.request;

import lombok.Data;
import jakarta.validation.constraints.DecimalMax;
import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.NotEmpty;
import java.io.Serializable;

@Data
public class TreeLocationRequest implements Serializable {

    @DecimalMin(value = "-90.0", message = "Latitude must be between -90 and 90")
    @DecimalMax(value = "90.0", message = "Latitude must be between -90 and 90")
    private double latitude;

    @DecimalMin(value = "-180.0", message = "Longitude must be between -180 and 180")
    @DecimalMax(value = "180.0", message = "Longitude must be between -180 and 180")
    private double longitude;

    @DecimalMin(value = "-500.0", message = "Altitude must be greater than or equal to -500 meters")
    private double altitude;

    @NotEmpty(message = "Address must not be empty")
    private String address;
}
