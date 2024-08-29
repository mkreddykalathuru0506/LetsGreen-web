package com.letsGreen.request;

import lombok.Data;
import java.io.Serializable;
import java.util.Date;

@Data
public class MaintenanceScheduleRequest implements Serializable {
    private String treeId;
    private Date nextWateringTime;
    private String nextWateringBy;
    private Date nextFertilizationTime;
    private String nextFertilizationBy;
    private Date nextInspectionTime;
    private String nextInspectionBy;
}
