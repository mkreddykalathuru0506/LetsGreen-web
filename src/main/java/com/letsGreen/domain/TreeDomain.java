package com.letsGreen.domain;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Data;

@Data
public class TreeDomain {
	@JsonIgnore
    private Long id;
    private String type;
    private String name;
    private Integer cost;
    private Long nurseryId;  // ID for Nursery
    private Long sponserId;  // ID for Sponsor
    private Boolean isAvailableInNursery;
    private Boolean isPlanted;
    private Boolean isActive;
    private String plantedBy;
    private Date plantedDate;
    private String sponsoredDate;
    private Integer height;
    private Float diameter;
    private Integer age;
    private Long todayWateringStatusId;  // ID for TodayWateringStatus
    private Long treeHealthReportId;  // ID for TreeHealthReport
    private String notes;
   

}