package com.letsGreen.entity;

import lombok.Data;
import lombok.NoArgsConstructor;
import java.util.List;
import jakarta.persistence.*;

@Data
@NoArgsConstructor
@Entity
@Table(name = "PLANTING_REPORT")
public class PlantingReport {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "planting_report_seq")
    @SequenceGenerator(name = "planting_report_seq", sequenceName = "PLANTING_REPORT_SEQ", allocationSize = 1)
    @Column(name = "ID", columnDefinition = "NUMBER(19)")
    private Long id;

    @ElementCollection
    @CollectionTable(name = "PLANTING_LIST_IDS", joinColumns = @JoinColumn(name = "PLANTING_REPORT_ID"))
    @Column(name = "PLANTING_LIST")
    private List<Long> totalPlantListIds;

    @Column(name = "TOTAL_PLANTS_COUNT", columnDefinition = "NUMBER(10)")
    private Integer totalPlantsCount;

    @ElementCollection
    @CollectionTable(name = "ACTIVE_TREE_IDS", joinColumns = @JoinColumn(name = "PLANTING_REPORT_ID"))
    @Column(name = "ACTIVE_TREE_LIST")
    private List<Long> activePlantsIds;

    @Column(name = "ACTIVE_PLANTS_COUNT", columnDefinition = "NUMBER(10)")
    private Integer activePlantsCount;

    @ElementCollection
    @CollectionTable(name = "INACTIVE_TREE_IDS", joinColumns = @JoinColumn(name = "PLANTING_REPORT_ID"))
    @Column(name = "INACTIVE_TREE_LIST")
    private List<Long> inactivePlantsIds;

    @Column(name = "INACTIVE_PLANTS_COUNT", columnDefinition = "NUMBER(10)")
    private Integer inactivePlantsCount;

    @Column(name = "PLANTING_QUOTIENT", columnDefinition = "NUMBER(10,2)")
    private Double plantingQuotient;
}
