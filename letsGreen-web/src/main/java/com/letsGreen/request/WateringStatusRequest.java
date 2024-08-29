package com.letsGreen.request;

import lombok.Data;
import jakarta.validation.constraints.*;
import java.io.Serializable;
import java.util.Date;
import java.util.List;

@Data
public class WateringStatusRequest implements Serializable {

    @NotEmpty(message = "Plant ID must not be empty")
    private String plantId;

    @PastOrPresent(message = "Last watered date must be in the past or present")
    private Date lastWatered;

    @NotEmpty(message = "Last watered by must not be empty")
    private String lastWateredBy;

    @Min(value = 0, message = "Watered hours back must be positive")
    private int wateredHoursBack;

    @NotEmpty(message = "Watering status must not be empty")
    private String wateringStatus;

    @NotEmpty(message = "Pending dates list must not be empty")
    private List<@PastOrPresent(message = "Pending dates must be in the past or present") Date> pendingDates;

    @Min(value = 0, message = "Missed count must be positive")
    private int missedCount;

    @Min(value = 0, message = "Total count must be positive")
    private int totalCount;

    @Min(value = 0, message = "Total watering tenure must be positive")
    private int totalWateringTenure;

    @Min(value = 0, message = "Remaining watering tenure must be positive")
    private int remainingWateringTenure;
}
