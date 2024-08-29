package com.letsGreen.request;

import lombok.Data;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import java.io.Serializable;
import java.util.Date;

@Data
public class HealthStatusRequest implements Serializable {

    @NotEmpty(message = "Tree ID must not be empty")
    @Size(max = 50, message = "Tree ID must be less than 50 characters")
    private String treeId;

    @NotEmpty(message = "Health condition must not be empty")
    @Size(max = 100, message = "Health condition must be less than 100 characters")
    private String healthCondition;

    @NotNull(message = "Last health check timestamp must not be null")
    private Date lastHealthCheckTimestamp;

    private ImageRequest currentImg;

    private boolean isDiseased;

    @Size(max = 50, message = "Disease ID must be less than 50 characters")
    private String diseaseId;

    @Size(max = 100, message = "Leaf condition must be less than 100 characters")
    private String leafCondition;

    @Size(max = 100, message = "Bark condition must be less than 100 characters")
    private String barkCondition;

    @Size(max = 100, message = "Root condition must be less than 100 characters")
    private String rootCondition;

    @Size(max = 100, message = "Pest infestation must be less than 100 characters")
    private String pestInfestation;

    @Size(max = 100, message = "Soil moisture must be less than 100 characters")
    private String soilMoisture;

    @Size(max = 100, message = "Light exposure must be less than 100 characters")
    private String lightExposure;

    @Size(max = 50, message = "Temperature must be less than 50 characters")
    private String temperature;

    @Size(max = 50, message = "Humidity must be less than 50 characters")
    private String humidity;

    @Size(max = 50, message = "Soil pH must be less than 50 characters")
    private String soilPh;

    @Size(max = 100, message = "Water usage must be less than 100 characters")
    private String waterUsage;
}
