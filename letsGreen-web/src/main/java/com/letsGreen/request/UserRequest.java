package com.letsGreen.request;

import lombok.Data;
import jakarta.validation.constraints.*;
import java.io.Serializable;
import java.util.Date;
import java.util.List;

@Data
public class UserRequest implements Serializable {

    @NotEmpty(message = "User ID must not be empty")
    private String userId;

    @NotEmpty(message = "Name must not be empty")
    private String name;

    @Min(value = 0, message = "Age must be positive")
    private int age;

    @NotEmpty(message = "Contact number must not be empty")
    @Pattern(regexp = "^\\+?[0-9. ()-]{7,25}$", message = "Invalid contact number")
    private String contactNumber;

    @NotEmpty(message = "Email must not be empty")
    @Email(message = "Invalid email address")
    private String email;

    @NotNull(message = "Role must not be null")
    private RoleRequest role;

    private boolean isAdminAccess;

    @NotEmpty(message = "Employment type must not be empty")
    private String employmentType;

    @Min(value = 0, message = "Experience must be positive")
    private int experience;

    @NotEmpty(message = "Education must not be empty")
    private String education;

    @NotEmpty(message = "Responsibilities list must not be empty")
    private List<String> responsibilities;

    @NotNull(message = "Work type must not be null")
    private WorkTypeRequest workType;

    @NotNull(message = "Group must not be null")
    private GroupRequest group;

    private boolean isActive;
    private boolean isOnDuty;

    @NotNull(message = "Current location must not be null")
    private LocationRequest currentLocation;

    @NotNull(message = "Office location must not be null")
    private AddressRequest officeLocation;

    private boolean isJoined;

    @NotNull(message = "Profile picture must not be null")
    private ImageRequest profilePic;

    @NotEmpty(message = "Gender must not be empty")
    private String gender;

    @NotNull(message = "Address must not be null")
    private AddressRequest address;

    @Min(value = 0, message = "Planted count must be positive")
    private int plantedCount;

    @PastOrPresent(message = "Joining date must be in the past or present")
    private Date joiningDate;
}
