package com.letsGreen.request;

import lombok.Data;
import java.io.Serializable;
import java.util.Date;

@Data
public class UpcomingPlantsReportRequest implements Serializable {
    private String plantId;
    private String name;
    private String category;
    private Date planningDate;
    private String planningPlace;
    private String planningOwner;
    private int totalPlantsAvailable;
}
