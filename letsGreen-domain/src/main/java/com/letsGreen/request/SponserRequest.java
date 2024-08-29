package com.letsGreen.request;

import lombok.Data;
import java.io.Serializable;

@Data
public class SponserRequest implements Serializable {
    private String id;
    private String name;
    private String phoneNumber;
    private String occupation;
    private AddressRequest address;
    private int sponsoredAmount;
    private int totalTrees;
}
