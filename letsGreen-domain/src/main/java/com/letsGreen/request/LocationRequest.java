package com.letsGreen.request;

import lombok.Data;
import java.io.Serializable;

@Data
public class LocationRequest implements Serializable {
    private String locationName;
}
