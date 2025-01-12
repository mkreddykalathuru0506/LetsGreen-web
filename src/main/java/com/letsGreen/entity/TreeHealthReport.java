package com.letsGreen.entity;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

import jakarta.persistence.*;

@Data
@NoArgsConstructor
@Entity
@Table(name = "TREE_HEALTH_REPORT")
@SequenceGenerator(name = "tree_health_report_seq_generator", sequenceName = "TREE_HEALTH_REPORT_SEQ", allocationSize = 1)
public class TreeHealthReport {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "tree_health_report_seq_generator")
    @Column(name="HEALTH_REPORT_ID", columnDefinition = "NUMBER(19)")
    private Long reportId;

    @Column(name = "PLANT_ID")
    private Long plantId;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "HEALTH_STATUS_ID") 
    private HealthStatus healthStatus;

    @Column(name = "HEALTH_QUOTIENT")
    private Double healthQuotient;

    @Column(name = "DECEASED_COUNT")
    private Integer deceasedCount;

    // Uncomment and use these collections if needed
    
    @ElementCollection
    @CollectionTable(name = "RECENT_DISEASE_LIST", joinColumns = @JoinColumn(name = "report_id"))
    @Column(name = "DISEASE")
    private List<String> recentDiseaseList;

    @Column(name = "TREATMENT_STATUS")
    private String treatmentStatus;

    @Column(name = "RECOVERED_STATUS")
    private String recoveredStatus;

    @ElementCollection
    @CollectionTable(name = "USED_MEDICINE_IDS", joinColumns = @JoinColumn(name = "report_id"))
    @Column(name = "MEDICINE_ID")
    private List<String> usedMedicineIds;

    @Column(name = "OVERALL_HEALTH_STATUS")
    private String overallHealthStatus;
    
}
