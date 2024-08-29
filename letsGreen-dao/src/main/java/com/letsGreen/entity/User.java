package com.letsGreen.entity;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.List;

import jakarta.persistence.*;

@Data
@NoArgsConstructor
@Entity
@Table(name = "LETS_GREEN_USER") // Ensure this table name is correctly created in Oracle
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "lets_green_user_seq")
    @SequenceGenerator(name = "lets_green_user_seq", sequenceName = "LETS_GREEN_USER_SEQ", allocationSize = 1)
    @Column(name = "id", columnDefinition = "NUMBER(19)")
    private Long userId;

    @Column(name = "NAME")
    private String name;

    @Column(name = "AGE")
    private Integer age;

    @Column(name = "CONTACT_NUMBER")
    private String contactNumber;

    @Column(name = "EMAIL")
    private String email;

    @ManyToOne
    @JoinColumn(name = "ROLE_ID") // Ensure that this column exists in the `LETS_GREEN_USER` table
    private Role role;

    @Column(name = "IS_ADMIN_ACCESS")
    private Boolean isAdminAccess;

    @Column(name = "EMPLOYMENT_TYPE")
    private String employmentType;

    @Column(name = "EXPERIENCE")
    private Integer experience;

    @Column(name = "EDUCATION")
    private String education;

    @ElementCollection
    @CollectionTable(name = "USER_RESPONSIBILITIES", joinColumns = @JoinColumn(name = "USER_RESP_ID"))
    @Column(name = "RESPONSIBILITY")
    private List<String> responsibilities;

  
    @ManyToOne
    @JoinColumn(name = "WORK_TYPE_ID")
    private WorkType workType;

    @ManyToOne
    @JoinColumn(name = "GROUP_ID")
    private Group group;

	/*
	 * @ManyToOne
	 * 
	 * @JoinColumn(name = "LOCATION_ID") private Location currentLocation;
	 */

    @ManyToOne
    @JoinColumn(name = "ADDRESS_ID")
    private Address address;
    

    @Column(name = "IS_ACTIVE")
    private Boolean isActive;

    @Column(name = "IS_ON_DUTY")
    private Boolean isOnDuty;

    @Column(name = "IS_JOINED")
    private Boolean isJoined;

    @Column(name = "GENDER")
    private String gender;

    @Column(name = "PLANTED_COUNT")
    private Integer plantedCount;

    @Column(name = "JOINING_DATE")
    @Temporal(TemporalType.DATE)
    private Date joiningDate;
}
