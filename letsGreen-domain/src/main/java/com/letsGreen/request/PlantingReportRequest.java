package com.letsGreen.request;

import lombok.Data;
import java.io.Serializable;
import java.util.List;

@Data
public class PlantingReportRequest implements Serializable {
    private List<String> totalPlantListIds;
    private int totalPlantsCount;
    private List<String> activePlantsIds;
    private int activePlantsCount;
    private List<String> inactivePlantsIds;
    private int inactivePlantsCount;
    private int plantingQuotient;
}
