package com.letsGreen.domain;

import lombok.Data;
import java.util.Date;
import java.util.List;

@Data
public class TreeDomain {
    private String id;
    private String type;
    private String name;
    private int cost;
    private NurseryDomain nursery;
    private SponserDomain sponser;
    private boolean isAvailableInNursery;
    private boolean isPlanted;
    private boolean isActive;
    private String plantedBy;
    private Date plantedDate;
    private String sponsorId;
    private String sponsoredDate;
    private int height;
    private float diameter;
    private int age;
    private List<HealthStatusDomain> healthHistory;
    private List<WateringStatusDomain> wateringHistory;
    private QRCodeDomain qrCode;
    private BarcodeDomain barcode;
    private ImageDomain treePhoto;
    private ImageDomain currentImage;  // Assuming HealthStatus.currentImage is an ImageDomain
    private GeoLocationDomain geoLocation;
    private HealthStatusDomain todayHealthStatus;
    private WateringStatusDomain todayWateringStatus;
    private MaintenanceScheduleDomain schedule;
    private String notes;
}
