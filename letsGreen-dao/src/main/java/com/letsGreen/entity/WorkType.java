package com.letsGreen.entity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@Entity
@Table(name = "WORK_TYPE")
@SequenceGenerator(name = "work_type_seq_generator", sequenceName = "WORK_TYPE_SEQ", allocationSize = 1)
public class WorkType {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "work_type_seq_generator")
    @Column(name = "id", columnDefinition = "NUMBER(19)")
    private Long workType_id;

    @Column(name = "NAME")
    private String name;
}
