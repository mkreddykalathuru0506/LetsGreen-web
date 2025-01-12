package com.letsGreen.request;

import lombok.Data;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import java.io.Serializable;
import java.util.Date;
import java.util.List;

@Data
public class NurseryRequest implements Serializable {

    @NotEmpty(message = "ID must not be empty")
    private String id;

    @NotNull(message = "Address must not be null")
    private AddressRequest address;

    @NotNull(message = "Start date must not be null")
    private Date startDate;

    @NotNull(message = "Owner must not be null")
    private UserRequest owner;

    @NotNull(message = "Photo must not be null")
    private ImageRequest photo;

    @NotNull(message = "Owner photo must not be null")
    private ImageRequest ownerPhoto;

    @NotNull(message = "Available trees list must not be null")
    private List<TreeRequest> availableTrees;

    @NotNull(message = "Booked trees list must not be null")
    private List<TreeRequest> bookedTrees;

    @NotNull(message = "Upcoming trees list must not be null")
    private List<TreeRequest> upcomingTrees;

    @Positive(message = "Capacity must be a positive number")
    private int capacity;
}
