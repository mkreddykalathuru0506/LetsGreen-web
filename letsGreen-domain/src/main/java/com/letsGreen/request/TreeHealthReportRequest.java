package com.letsGreen.request;

import lombok.Data;
import java.io.Serializable;
import java.util.List;

@Data
public class TreeHealthReportRequest implements Serializable {
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
