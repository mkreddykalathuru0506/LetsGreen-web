package com.letsGreen.entity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@Entity
@Table(name = "DECEASE")
public class Decease {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "decease_seq")
    @SequenceGenerator(name = "decease_seq", sequenceName = "DECEASE_SEQ", allocationSize = 1)
    @Column(name="id", columnDefinition = "NUMBER(19)")
    private Long id;

    @Column(name = "NAME")
    private String name;

    @Column(name = "TENURE")
    private String tenure;

    @Column(name = "TOTAL_TREATMENT_TENURE")
    private Integer totalTreatmentTenure;

    @Column(name = "REMAINING_TREATMENT_TENURE")
    private Integer remainingTreatmentTenure;

    @Column(name = "NEEDED_MEDICINE_ID")
    private String neededMedicineId;
}
