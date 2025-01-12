package com.letsGreen.entity;

import lombok.Data;
import lombok.NoArgsConstructor;

import jakarta.persistence.*;

import java.util.Date;

@Data
@NoArgsConstructor
@Entity
@Table(name = "HEALTH_CONDITION") // Ensure this matches the actual table name in Oracle
public class HealthCondition {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "health_condition_seq")
    @SequenceGenerator(name = "health_condition_seq", sequenceName = "HEALTH_CONDITION_SEQ", allocationSize = 1)  
    @Column(name = "HEALTH_CONDITION_ID")
    private Long id;

    @Column(name = "TREE_ID")
    private String treeId;

    @Column(name = "HEALTH_CONDITION")
    private String healthCondition;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "LAST_HEALTH_CHECK_TIMESTAMP")
    private Date lastHealthCheckTimestamp;

    // Uncomment and use if needed
    /*
    @Lob
    @Column(name = "CURRENT_IMG")
    private byte[] currentImg;
    */

    @Column(name = "IS_DISEASED")
    private Boolean isDiseased;

    @Column(name = "DISEASE_ID")
    private String diseaseId;

    @Column(name = "LEAF_CONDITION")
    private String leafCondition;

    @Column(name = "BARK_CONDITION")
    private String barkCondition;

    @Column(name = "ROOT_CONDITION")
    private String rootCondition;

    @Column(name = "PEST_INFESTATION")
    private String pestInfestation;

    @Column(name = "SOIL_MOISTURE")
    private Float soilMoisture;

    @Column(name = "LIGHT_EXPOSURE")
    private Float lightExposure;

    @Column(name = "TEMPERATURE")
    private Float temperature;

    @Column(name = "HUMIDITY")
    private Float humidity;

    @Column(name = "SOIL_PH")
    private Float soilPh;

    @Column(name = "WATER_USAGE")
    private Float waterUsage;
}
