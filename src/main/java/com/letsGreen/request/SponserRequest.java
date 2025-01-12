package com.letsGreen.request;

import lombok.Data;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.Size;
import java.io.Serializable;

@Data
public class SponserRequest implements Serializable {

    @NotEmpty(message = "ID must not be empty")
    private String id;

    @NotEmpty(message = "Name must not be empty")
    @Size(max = 100, message = "Name should not exceed 100 characters")
    private String name;

    @NotEmpty(message = "Phone number must not be empty")
    @Size(max = 15, message = "Phone number should not exceed 15 characters")
    private String phoneNumber;

    @NotEmpty(message = "Occupation must not be empty")
    @Size(max = 50, message = "Occupation should not exceed 50 characters")
    private String occupation;

    @NotNull(message = "Address must not be null")
    private AddressRequest address;

    @Positive(message = "Sponsored amount must be positive")
    private int sponsoredAmount;

    @Positive(message = "Total trees must be positive")
    private int totalTrees;
}
