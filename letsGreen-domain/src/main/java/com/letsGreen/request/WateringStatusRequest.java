package com.letsGreen.request;

import lombok.Data;
import java.io.Serializable;
import java.util.Date;
import java.util.List;

@Data
public class WateringStatusRequest implements Serializable {
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
