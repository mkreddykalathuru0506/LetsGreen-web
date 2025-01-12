package com.letsGreen.entity;

import lombok.Data;
import lombok.NoArgsConstructor;
import java.util.Date;
import jakarta.persistence.*;

@Data
@NoArgsConstructor
@Entity
@Table(name = "UPCOMING_PLANTS_REPORT")
public class UpcomingPlantsReport {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "upcoming_plants_report_seq")
    @SequenceGenerator(name = "upcoming_plants_report_seq", sequenceName = "UPCOMING_PLANTS_REPORT_SEQ", allocationSize = 1)
    @Column(name = "PLANT_ID", columnDefinition = "NUMBER(19)")
    private Long plantId;

    @Column(name = "NAME", nullable = false)
    private String name;

    @Column(name = "CATEGORY", nullable = false)
    private String category;

    @Column(name = "PLANNING_DATE")
    @Temporal(TemporalType.DATE)
    private Date planningDate;

    @Column(name = "PLANNING_PLACE", nullable = false)
    private String planningPlace;

    @Column(name = "PLANNING_OWNER", nullable = false)
    private String planningOwner;

    @Column(name = "TOTAL_PLANTS_AVAILABLE", columnDefinition = "NUMBER(10)")
    private Integer totalPlantsAvailable;
}
