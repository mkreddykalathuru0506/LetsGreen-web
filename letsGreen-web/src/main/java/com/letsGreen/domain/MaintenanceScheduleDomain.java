package com.letsGreen.domain;

import lombok.Data;
import java.util.Date;

@Data
public class MaintenanceScheduleDomain {
    private String treeId;
    private Date nextWateringTime;
    private String nextWateringBy;
    private Date nextFertilizationTime;
    private String nextFertilizationBy;
    private Date nextInspectionTime;
    private String nextInspectionBy;
}
