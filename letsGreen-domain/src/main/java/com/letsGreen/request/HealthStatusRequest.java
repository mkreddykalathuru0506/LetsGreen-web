package com.letsGreen.request;

import lombok.Data;
import java.io.Serializable;
import java.util.Date;

@Data
public class HealthStatusRequest implements Serializable {
    private String treeId;
    private String healthCondition;
    private Date lastHealthCheckTimestamp;
    private ImageRequest currentImg;
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
