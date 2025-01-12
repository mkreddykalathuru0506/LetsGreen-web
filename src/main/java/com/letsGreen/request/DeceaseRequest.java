package com.letsGreen.request;

import lombok.Data;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import java.io.Serializable;

@Data
public class DeceaseRequest implements Serializable {

    @NotBlank(message = "ID cannot be blank")
    private String id;

    @NotBlank(message = "Name cannot be blank")
    private String name;

    @NotBlank(message = "Tenure cannot be blank")
    @Size(max = 50, message = "Tenure cannot exceed 50 characters")
    private String tenure;

    @NotBlank(message = "Total Treatment Tenure cannot be blank")
    @Size(max = 50, message = "Total Treatment Tenure cannot exceed 50 characters")
    private String totalTreatmentTenure;

    @NotBlank(message = "Remaining Treatment Tenure cannot be blank")
    @Size(max = 50, message = "Remaining Treatment Tenure cannot exceed 50 characters")
    private String remainingTreatmentTenure;

    @NotBlank(message = "Needed Medicine ID cannot be blank")
    @Size(max = 50, message = "Needed Medicine ID cannot exceed 50 characters")
    private String neededMedicineId;
}
