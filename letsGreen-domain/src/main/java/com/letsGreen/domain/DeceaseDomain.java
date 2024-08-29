package com.letsGreen.domain;

import lombok.Data;

@Data
public class DeceaseDomain {
    private String id;
    private String name;
    private String tenure;
    private String totalTreatmentTenure;
    private String remainingTreatmentTenure;
    private String neededMedicineId;
}
