package com.letsGreen.entity;

import lombok.Data;
import lombok.NoArgsConstructor;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import jakarta.persistence.Lob;
import java.util.Date;

@Data
@NoArgsConstructor
@Entity
@Table(name = "TREE")
public class Tree {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "TREE_SEQ")
    @SequenceGenerator(name = "TREE_SEQ", sequenceName = "SYSTEM.TREE_SEQ", allocationSize = 1)
    @Column(name = "id", columnDefinition = "NUMBER(19)")
    private Long id;

    @Column(name = "TYPE")
    private String type;

    @Column(name = "NAME")
    private String name;

    @Column(name = "COST")
    private Integer cost;

    // Use simple Long types for ID columns instead of @ManyToOne
    @Column(name = "NURSERY_ID")
    private Long nurseryId;  // Only ID for Nursery, not the entity

    @Column(name = "SPONSER_ID")
    private Long sponserId;  // Only ID for Sponsor, not the entity

    @Column(name = "IS_AVAILABLE_IN_NURSERY")
    private Boolean isAvailableInNursery;

    @Column(name = "IS_PLANTED")
    private Boolean isPlanted;

    @Column(name = "IS_ACTIVE")
    private Boolean isActive;

    @Column(name = "PLANTED_BY")
    private String plantedBy;

    @Temporal(TemporalType.DATE)
    @Column(name = "PLANTED_DATE")
    private Date plantedDate;

    @Column(name = "SPONSORED_DATE")
    private String sponsoredDate;

    @Column(name = "HEIGHT")
    private Integer height;

    @Column(name = "DIAMETER")
    private Float diameter;

    @Column(name = "AGE")
    private Integer age;

    @Column(name = "TODAY_WATERING_STATUS_ID")
    private Long todayWateringStatusId;  // Only ID for TodayWateringStatus, not the entity

    @Column(name = "HEALTH_REPORT_ID")
    private Long treeHealthReportId;  // Only ID for TreeHealthReport, not the entity

    @Column(name = "NOTES")
    private String notes;

    @Lob
    @Column(name = "TREE_PHOTO")
    private byte[] treePhoto;  // Store photo as byte array

}
