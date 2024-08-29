package com.letsGreen.request;

import lombok.Data;
import jakarta.validation.constraints.*;
import java.io.Serializable;
import java.util.Date;
import java.util.List;

@Data
public class TreeRequest implements Serializable {

    @NotEmpty(message = "ID must not be empty")
    private String id;

    @NotEmpty(message = "Type must not be empty")
    private String type;

    @NotEmpty(message = "Name must not be empty")
    private String name;

    @Min(value = 0, message = "Cost must be positive")
    private int cost;

    @NotNull(message = "Nursery information must be provided")
    private NurseryRequest nursery;

    @NotNull(message = "Sponsor information must be provided")
    private SponserRequest sponser;

    private boolean isAvailableInNursery;

    private boolean isPlanted;

    private boolean isActive;

    @NotEmpty(message = "Planted by field must not be empty")
    private String plantedBy;

    @PastOrPresent(message = "Planted date must be in the past or present")
    private Date plantedDate;

    @NotEmpty(message = "Sponsor ID must not be empty")
    private String sponsorId;

    @NotEmpty(message = "Sponsored date must not be empty")
    private String sponsoredDate;

    @Min(value = 0, message = "Height must be positive")
    private int height;

    @DecimalMin(value = "0.0", message = "Diameter must be positive")
    private float diameter;

    @Min(value = 0, message = "Age must be positive")
    private int age;

    @NotEmpty(message = "Health history must not be empty")
    private List<HealthStatusRequest> healthHistory;

    @NotEmpty(message = "Watering history must not be empty")
    private List<WateringStatusRequest> wateringHistory;

    @NotNull(message = "QR Code information must be provided")
    private QRCodeRequest qrCode;

    @NotNull(message = "Barcode information must be provided")
    private BarcodeRequest barcode;

    @NotNull(message = "Tree photo must be provided")
    private ImageRequest treePhoto;

    @NotNull(message = "Current image must be provided")
    private ImageRequest currentImage;

    @NotNull(message = "Geo-location information must be provided")
    private GeoLocationRequest geoLocation;

    @NotNull(message = "Today's health status must be provided")
    private HealthStatusRequest todayHealthStatus;

    @NotNull(message = "Today's watering status must be provided")
    private WateringStatusRequest todayWateringStatus;

    @NotNull(message = "Maintenance schedule must be provided")
    private MaintenanceScheduleRequest schedule;

    @NotEmpty(message = "Notes must not be empty")
    private String notes;
}
