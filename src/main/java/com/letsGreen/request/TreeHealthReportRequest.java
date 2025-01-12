package com.letsGreen.request;

import lombok.Data;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import java.io.Serializable;
import java.util.List;

@Data
public class TreeHealthReportRequest implements Serializable {

    @NotEmpty(message = "Report ID must not be empty")
    private String reportId;

    @NotEmpty(message = "Plant ID must not be empty")
    private String plantId;

    @NotEmpty(message = "Health Status must not be empty")
    private String healthStatus;

    @Positive(message = "Health Quotient must be positive")
    private int healthQuotient;

    @Positive(message = "Deceased Count must be positive")
    private int deceasedCount;

    private List<String> recentDiseaseList;

    @NotEmpty(message = "Treatment Status must not be empty")
    private String treatmentStatus;

    @NotEmpty(message = "Recovered Status must not be empty")
    private String recoveredStatus;

    private List<String> usedMedicineIds;

    @NotEmpty(message = "Overall Health Status must not be empty")
    private String overallHealthStatus;
}
