package com.letsGreen.domain;

import lombok.Data;
import java.util.Date;

@Data
public class UpcomingPlantsReportDomain {
    private String plantId;
    private String name;
    private String category;
    private Date planningDate;
    private String planningPlace;
    private String planningOwner;
    private int totalPlantsAvailable;
}
