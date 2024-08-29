package com.letsGreen.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@Entity
@Table(name = "BARCODE")
public class Barcode {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "barcode_seq")
    @SequenceGenerator(name = "barcode_seq", sequenceName = "BARCODE_SEQ", allocationSize = 1)
    @Column(name="id", columnDefinition = "NUMBER(19)")
    private Long id;

    @Column(name = "CODE")
    private String code;

    @Column(name = "FORMAT")
    private String format;
}
