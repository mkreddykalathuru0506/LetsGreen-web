package com.letsGreen.request;

import lombok.Data;
import java.io.Serializable;
import java.util.Date;
import java.util.List;

@Data
public class UserRequest implements Serializable {
    private String userId;
    private String name;
    private int age;
    private String contactNumber;
    private String email;
    private RoleRequest role;
    private boolean isAdminAccess;
    private String employmentType;
    private int experience;
    private String education;
    private List<String> responsibilities;
    private WorkTypeRequest workType;
    private GroupRequest group;
    private boolean isActive;
    private boolean isOnDuty;
    private LocationRequest currentLocation;
    private AddressRequest officeLocation;
    private boolean isJoined;
    private ImageRequest profilePic;
    private String gender;
    private AddressRequest address;
    private int plantedCount;
    private Date joiningDate;
}
