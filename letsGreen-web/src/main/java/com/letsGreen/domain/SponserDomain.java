package com.letsGreen.domain;

import lombok.Data;

@Data
public class SponserDomain {
    private String id;
    private String name;
    private String phoneNumber;
    private String occupation;
    private AddressDomain address;
    private int sponsoredAmount;
    private int totalTrees;
}
