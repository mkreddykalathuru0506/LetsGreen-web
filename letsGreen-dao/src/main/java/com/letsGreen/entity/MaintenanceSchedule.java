package com.letsGreen.entity;

import lombok.Data;
import lombok.NoArgsConstructor;
import jakarta.persistence.*;
import java.util.Date;

@Data
@NoArgsConstructor
@Entity
@Table(name = "MAINTENANCE_SCHEDULE")
public class MaintenanceSchedule {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "maintenance_schedule_seq")
    @SequenceGenerator(name = "maintenance_schedule_seq", sequenceName = "MAINTENANCE_SCHEDULE_SEQ", allocationSize = 1)
    @Column(name = "ID")
    private Long id;

    @Column(name = "TREE_ID")
    private String treeId;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "NEXT_WATERING_TIME")
    private Date nextWateringTime;

    @Column(name = "NEXT_WATERING_BY")
    private String nextWateringBy;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "NEXT_FERTILIZATION_TIME")
    private Date nextFertilizationTime;

    @Column(name = "NEXT_FERTILIZATION_BY")
    private String nextFertilizationBy;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "NEXT_INSPECTION_TIME")
    private Date nextInspectionTime;

    @Column(name = "NEXT_INSPECTION_BY")
    private String nextInspectionBy;
}
