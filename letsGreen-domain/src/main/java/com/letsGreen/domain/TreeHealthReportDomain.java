package com.letsGreen.domain;

import lombok.Data;
import java.util.List;

@Data
public class TreeHealthReportDomain {
    private String reportId;
    private String plantId;
    private String healthStatus;
    private int healthQuotient;
    private int deceasedCount;
    private List<String> recentDiseaseList;
    private String treatmentStatus;
    private String recoveredStatus;
    private List<String> usedMedicineIds;
    private String overallHealthStatus;
}
