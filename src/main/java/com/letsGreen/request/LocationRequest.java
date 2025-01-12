package com.letsGreen.request;

import lombok.Data;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;
import java.io.Serializable;

@Data
public class LocationRequest implements Serializable {

    @NotEmpty(message = "Location name must not be empty")
    @Size(max = 100, message = "Location name must be less than 100 characters")
    private String locationName;
}
