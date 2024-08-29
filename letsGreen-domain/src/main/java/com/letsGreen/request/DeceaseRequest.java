package com.letsGreen.request;

import lombok.Data;
import java.io.Serializable;

@Data
public class DeceaseRequest implements Serializable {
    private String id;
    private String name;
    private String tenure;
    private String totalTreatmentTenure;
    private String remainingTreatmentTenure;
    private String neededMedicineId;
}
