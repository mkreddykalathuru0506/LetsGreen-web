package com.letsGreen.entity;

import lombok.Data;
import lombok.NoArgsConstructor;

import jakarta.persistence.*;
import java.util.List;

@Data
@NoArgsConstructor
@Entity
@Table(name = "ROLE")
@SequenceGenerator(name = "role_seq_generator", sequenceName = "ROLE_SEQ", allocationSize = 1)
public class Role {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "role_seq_generator")
    @Column(name="ROLE_ID", columnDefinition = "NUMBER(19)")
    private Long id;

    @Column(name = "SALARY_RANGE")
    private Integer salaryRange;

    @Column(name = "NAME")
    private String name;

    @Column(name = "TENURE")
    private String tenure;

    @Column(name = "WORK_TIMINGS")
    private String workTimings;

    // Uncomment and use these collections as needed
    /*
    @ElementCollection
    @CollectionTable(name = "ROLE_TASKS", joinColumns = @JoinColumn(name = "role_id"))
    @Column(name = "TASK")
    private List<String> taskList;

    @ElementCollection
    @CollectionTable(name = "ROLE_CONDITIONS", joinColumns = @JoinColumn(name = "role_id"))
    @Column(name = "CONDITION")
    private List<String> conditions;
    */
}
