package com.letsGreen.entity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@Entity
@Table(name="TODAY_HEALTH_STATUS")
@SequenceGenerator(name = "health_status_seq_generator", sequenceName = "HEALTH_STATUS_SEQ", allocationSize = 1)
public class HealthStatus {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "health_status_seq_generator")
    @Column(name="HEALTH_STATUS_ID", columnDefinition = "NUMBER(19)")
    private Long id;

    @ManyToOne
    @JoinColumn(name = "HEALTH_CONDITION_ID")
    private HealthCondition healthCondition;
    
    @Column(name = "OVER_ALL_HEALTH_STATUS")
    private String healthConditionNumber;


}
