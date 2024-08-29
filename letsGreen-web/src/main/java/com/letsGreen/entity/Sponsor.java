package com.letsGreen.entity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@Entity
@Table(name="Sponsor")
public class Sponsor {

	@Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "sponser_seq")
    @SequenceGenerator(name = "sponser_seq", sequenceName = "SPONSER_SEQ", allocationSize = 1)
    @Column(name="SPONSER_ID", columnDefinition = "NUMBER(19)")
    private Long sponser_id;
    private String name;
    private String phoneNumber;
    private String occupation;

	/*
	 * @ManyToOne
	 * 
	 * @JoinColumn(name = "address_id")
	 */
	/* private Address address; */

    private Float sponsoredAmount;
    private Integer totalTrees;
}
