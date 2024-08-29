package com.letsGreen.entity;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.Lob;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;

@Data
@NoArgsConstructor
@Entity
@Table(name = "TREE") // Ensure the table name is correct in Oracle
public class Tree {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "tree_seq")
    @SequenceGenerator(name = "tree_seq", sequenceName = "TREE_SEQ", allocationSize = 1)
    @Column(name = "id", columnDefinition = "NUMBER(19)")
    private Long id;

    @Column(name = "TYPE")
    private String type;

    @Column(name = "NAME")
    private String name;

    @Column(name = "COST")
    private Integer cost;

    @ManyToOne
    @JoinColumn(name = "NURSERY_ID") // Make sure this column exists in the TREE table
    private Nursery nursery;

    @ManyToOne
    @JoinColumn(name = "SPONSER_ID") // Make sure this column exists in the TREE table
    private Sponsor sponser;

    @Column(name = "IS_AVAILABLE_IN_NURSERY")
    private Boolean isAvailableInNursery;

    @Column(name = "IS_PLANTED")
    private Boolean isPlanted;

    @Column(name = "IS_ACTIVE")
    private Boolean isActive;

    @Column(name = "PLANTED_BY")
    private String plantedBy;

    @Temporal(TemporalType.DATE)
    @Column(name = "PLANTED_DATE")
    private Date plantedDate;

   
    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "SPONSOR_ID")
    private Sponsor sponsor;

    @Column(name = "SPONSORED_DATE")
    private String sponsoredDate;

    @Column(name = "HEIGHT")
    private Integer height;

    @Column(name = "DIAMETER")
    private Float diameter;

    @Column(name = "AGE")
    private Integer age;

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "TREE_ID") // Maps the relationship with wateringHistory, ensure TREE_ID exists in WATERING_STATUS table
    private List<WateringStatus> wateringHistory;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "QRCODE_ID") // Maps the relationship with qrCode
    private QRCode qrCode;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "BARCODE_ID") // Maps the relationship with barcode
    private Barcode barcode;

    @Lob
    @Column(name = "TREE_PHOTO")
    private byte[] treePhoto;

	/*
	 * @OneToOne(cascade = CascadeType.ALL)
	 * 
	 * @JoinColumn(name = "GEOLOCATION_ID") // Maps the relationship with
	 * geoLocation private GeoLocation geoLocation;
	 */

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "HEALTH_REPORT_ID") 
    private TreeHealthReport treeHealthReport;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "TODAY_WATERING_STATUS_ID") // Maps the relationship with todayWateringStatus
    private TodayWateringStatus todayWateringStatus;

    @Column(name = "NOTES")
    private String notes;
}
