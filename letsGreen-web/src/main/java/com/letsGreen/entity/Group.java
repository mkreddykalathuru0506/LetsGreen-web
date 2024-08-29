package com.letsGreen.entity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@Entity
@Table(name = "\"GROUP\"")
public class Group {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "group_seq")
    @SequenceGenerator(name = "group_seq", sequenceName = "GROUP_SEQ", allocationSize = 1)
    @Column(name="id", columnDefinition = "NUMBER(19)")
    private Long groupid;

    @Column(name = "GROUP_NAME")
    private String groupName;

    @Column(name = "GROUP_DESCRIPTION")
    private String groupDescription;
}
