package com.letsGreen.request;

import lombok.Data;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.Date;

@Data
public class MaintenanceScheduleRequest implements Serializable {

    @NotEmpty(message = "Tree ID must not be empty")
    private String treeId;

    @NotNull(message = "Next watering time must not be null")
    private Date nextWateringTime;

    @NotEmpty(message = "Next watering by must not be empty")
    private String nextWateringBy;

    @NotNull(message = "Next fertilization time must not be null")
    private Date nextFertilizationTime;

    @NotEmpty(message = "Next fertilization by must not be empty")
    private String nextFertilizationBy;

    @NotNull(message = "Next inspection time must not be null")
    private Date nextInspectionTime;

    @NotEmpty(message = "Next inspection by must not be empty")
    private String nextInspectionBy;
}
