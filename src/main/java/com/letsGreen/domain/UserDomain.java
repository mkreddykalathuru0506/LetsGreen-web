package com.letsGreen.domain;

import lombok.Data;
import java.util.Date;
import java.util.List;

@Data
public class UserDomain {
    private String userId;
    private String name;
    private int age;
    private String contactNumber;
    private String email;
    private RoleDomain role;
    private boolean isAdminAccess;
    private String employmentType;
    private int experience;
    private String education;
    private List<String> responsibilities;
    private WorkTypeDomain workType;
    private GroupDomain group;
    private boolean isActive;
    private boolean isOnDuty;
    private LocationDomain currentLocation;
    private AddressDomain officeLocation;
    private boolean isJoined;
    private ImageDomain profilePic;
    private String gender;
    private AddressDomain address;
    private int plantedCount;
    private Date joiningDate;
}
