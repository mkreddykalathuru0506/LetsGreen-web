package com.letsGreen.entity;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.List;

import jakarta.persistence.*;

@Data
@NoArgsConstructor
@Entity
@Table(name = "WATERING_STATUS")
@SequenceGenerator(name = "watering_status_seq_generator", sequenceName = "WATERING_STATUS_SEQ", allocationSize = 1)
public class WateringStatus {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "watering_status_seq_generator")
    @Column(name = "id", columnDefinition = "NUMBER(19)")
    private Long id;

    @Column(name = "PLANT_ID")
    private Long plantId;

    @Column(name = "LAST_WATERED")
    @Temporal(TemporalType.TIMESTAMP)
    private Date lastWatered;

    @Column(name = "LAST_WATERED_BY")
    private String lastWateredBy;

    @Column(name = "WATERED_HOURS_BACK")
    private Integer wateredHoursBack;

    @Column(name = "WATERING_STATUS")
    private String wateringStatus;

    // Uncomment and use this collection if needed
    
    @ElementCollection
    @CollectionTable(name = "PENDING_DATES", joinColumns = @JoinColumn(name = "watering_status_id"))
    @Column(name = "PENDING_DATE")
    private List<Date> pendingDates;
    

    @Column(name = "MISSED_COUNT")
    private Integer missedCount;

    @Column(name = "TOTAL_COUNT")
    private Integer totalCount;

    @Column(name = "TOTAL_WATERING_TENURE")
    private Integer totalWateringTenure;

    @Column(name = "REMAINING_WATERING_TENURE")
    private Integer remainingWateringTenure;
}
