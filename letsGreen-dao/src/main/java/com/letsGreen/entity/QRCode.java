package com.letsGreen.entity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@Entity
@Table(name="QR_CODE")
@SequenceGenerator(name = "qrcode_seq_generator", sequenceName = "QR_CODE_SEQ", allocationSize = 1)
public class QRCode {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "qrcode_seq_generator")
    @Column(name="id", columnDefinition = "NUMBER(19)")
    private Long id;

    @Column(name = "DATA")
    private String data;

    @Column(name = "FORMAT")
    private String format;

    @Column(name = "VERSION")
    private Integer version;

    @Column(name = "ERROR_CORRECTION_LEVEL")
    private String errorCorrectionLevel;

    @Lob
    @Column(name = "IMAGE")
    private byte[] image;
}
