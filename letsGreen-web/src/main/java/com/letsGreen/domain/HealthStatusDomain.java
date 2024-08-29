package com.letsGreen.domain;

import lombok.Data;
import java.util.Date;

@Data
public class HealthStatusDomain {
    private String treeId;
    private String healthCondition;
    private Date lastHealthCheckTimestamp;
    private ImageDomain currentImg;
    private boolean isDiseased;
    private String diseaseId;
    private String leafCondition;
    private String barkCondition;
    private String rootCondition;
    private String pestInfestation;
    private String soilMoisture;
    private String lightExposure;
    private String temperature;
    private String humidity;
    private String soilPh;
    private String waterUsage;
}
