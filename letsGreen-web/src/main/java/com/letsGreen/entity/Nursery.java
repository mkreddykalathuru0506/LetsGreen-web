package com.letsGreen.entity;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
import jakarta.persistence.*;

@Data
@NoArgsConstructor
@Entity
@Table(name = "NURSERY")
@SequenceGenerator(name = "nursery_seq_generator", sequenceName = "NURSERY_SEQ", allocationSize = 1)
public class Nursery {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "nursery_seq_generator")
    @Column(name="id", columnDefinition = "NUMBER(19)")
    private Long id;

    @ManyToOne
    @JoinColumn(name = "address_id", referencedColumnName = "id")
    private Address address;

    @Column(name = "START_DATE")
    @Temporal(TemporalType.DATE)
    private Date startDate;

    @Lob
    @Column(name = "PHOTO")
    private byte[] photo;

    @Lob
    @Column(name = "OWNER_PHOTO")
    private byte[] ownerPhoto;

    @Column(name = "CAPACITY")
    private Integer capacity;

    // Relationships with other entities, uncomment and map accordingly
    /*
    @ManyToOne
    @JoinColumn(name = "owner_id")
    private User owner;

    @OneToMany(mappedBy = "nursery")
    private List<Tree> availableTrees;

    @OneToMany(mappedBy = "nursery")
    private List<Tree> bookedTrees;

    @OneToMany(mappedBy = "nursery")
    private List<Tree> upcomingTrees;
    */
}
