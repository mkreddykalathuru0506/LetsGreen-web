package com.letsGreen.entity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@Entity
@Table(name = "TREE_LOCATION")
@SequenceGenerator(name = "tree_location_seq_generator", sequenceName = "TREE_LOCATION_SEQ", allocationSize = 1)
public class TreeLocation {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "tree_location_seq_generator")
    @Column(name = "id", columnDefinition = "NUMBER(19)")
    private Long id;

    @Column(name = "LATITUDE")
    private Float latitude;

    @Column(name = "LONGITUDE")
    private Float longitude;

    @Column(name = "ALTITUDE")
    private Float altitude;

    // Uncomment and use this relationship if needed
    /*
    @ManyToOne
    @JoinColumn(name = "ADDRESS_ID")
    private Address address;
    */
}
