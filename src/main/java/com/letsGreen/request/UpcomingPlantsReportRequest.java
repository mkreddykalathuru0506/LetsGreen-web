package com.letsGreen.request;

import lombok.Data;
import jakarta.validation.constraints.*;
import java.io.Serializable;
import java.util.Date;

@Data
public class UpcomingPlantsReportRequest implements Serializable {

    @NotEmpty(message = "Plant ID must not be empty")
    private String plantId;

    @NotEmpty(message = "Name must not be empty")
    private String name;

    @NotEmpty(message = "Category must not be empty")
    private String category;

    @FutureOrPresent(message = "Planning date must be in the present or future")
    private Date planningDate;

    @NotEmpty(message = "Planning place must not be empty")
    private String planningPlace;

    @NotEmpty(message = "Planning owner must not be empty")
    private String planningOwner;

    @Min(value = 0, message = "Total plants available must be positive")
    private int totalPlantsAvailable;
}
