package com.letsGreen.request;

import lombok.Data;
import java.io.Serializable;
import java.util.Date;
import java.util.List;

@Data
public class TreeRequest implements Serializable {
    private String id;
    private String type;
    private String name;
    private int cost;
    private NurseryRequest nursery;
    private SponserRequest sponser;
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
    private List<HealthStatusRequest> healthHistory;
    private List<WateringStatusRequest> wateringHistory;
    private QRCodeRequest qrCode;
    private BarcodeRequest barcode;
    private ImageRequest treePhoto;
    private ImageRequest currentImage;  // Assuming HealthStatus.currentImage is an ImageRequest
    private GeoLocationRequest geoLocation;
    private HealthStatusRequest todayHealthStatus;
    private WateringStatusRequest todayWateringStatus;
    private MaintenanceScheduleRequest schedule;
    private String notes;
}
