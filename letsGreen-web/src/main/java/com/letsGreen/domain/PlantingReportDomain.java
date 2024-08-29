package com.letsGreen.domain;

import lombok.Data;
import java.util.List;

@Data
public class PlantingReportDomain {
    private List<String> totalPlantListIds;
    private int totalPlantsCount;
    private List<String> activePlantsIds;
    private int activePlantsCount;
    private List<String> inactivePlantsIds;
    private int inactivePlantsCount;
    private int plantingQuotient;
}
