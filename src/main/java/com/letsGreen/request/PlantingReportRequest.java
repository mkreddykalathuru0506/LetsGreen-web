package com.letsGreen.request;

import lombok.Data;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Positive;
import java.io.Serializable;
import java.util.List;

@Data
public class PlantingReportRequest implements Serializable {

    @NotEmpty(message = "Total plant list IDs must not be empty")
    private List<String> totalPlantListIds;

    @Positive(message = "Total plants count must be a positive number")
    private int totalPlantsCount;

    @NotEmpty(message = "Active plants IDs list must not be empty")
    private List<String> activePlantsIds;

    @Positive(message = "Active plants count must be a positive number")
    private int activePlantsCount;

    @NotEmpty(message = "Inactive plants IDs list must not be empty")
    private List<String> inactivePlantsIds;

    @Positive(message = "Inactive plants count must be a positive number")
    private int inactivePlantsCount;

    @Positive(message = "Planting quotient must be a positive number")
    private int plantingQuotient;
}
