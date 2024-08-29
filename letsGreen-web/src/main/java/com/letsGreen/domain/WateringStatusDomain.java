package com.letsGreen.domain;

import lombok.Data;
import java.util.Date;
import java.util.List;

@Data
public class WateringStatusDomain {
    private String plantId;
    private Date lastWatered;
    private String lastWateredBy;
    private int wateredHoursBack;
    private String wateringStatus;
    private List<Date> pendingDates;
    private int missedCount;
    private int totalCount;
    private int totalWateringTenure;
    private int remainingWateringTenure;
}
