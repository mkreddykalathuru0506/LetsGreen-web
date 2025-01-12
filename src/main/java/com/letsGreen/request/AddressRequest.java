package com.letsGreen.request;

import lombok.Data;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import java.io.Serializable;

@Data
public class AddressRequest implements Serializable {

    @NotBlank(message = "Street cannot be blank")
    private String street;

    @NotBlank(message = "City cannot be blank")
    private String city;

    @NotBlank(message = "State cannot be blank")
    private String state;

    @NotBlank(message = "Country cannot be blank")
    private String country;

    @NotBlank(message = "Postal code cannot be blank")
    @Pattern(regexp = "\\d{5}(-\\d{4})?", message = "Postal code must be a valid format (e.g., 12345 or 12345-6789)")
    private String postalCode;
}
