package com.letsGreen.entity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@Entity
@Table(name="TODAY_WATERING_STATUS")
@SequenceGenerator(name = "watering_status_seq_generator", sequenceName = "WATERING_STATUS_SEQ", allocationSize = 1)
public class TodayWateringStatus {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "watering_status_seq_generator")
    @Column(name="id", columnDefinition = "NUMBER(19)")
    private Long id;

    @Column(name = "IS_WATERED_TODAY")
    private Boolean isWateredToday;

    @Column(name = "HOURS_SINCE_LAST_WATERED")
    private Integer hoursSinceLastWatered;
}
