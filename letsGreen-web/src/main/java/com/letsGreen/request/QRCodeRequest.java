package com.letsGreen.request;

import lombok.Data;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import java.io.Serializable;

@Data
public class QRCodeRequest implements Serializable {

    @NotEmpty(message = "Data must not be empty")
    private String data;

    @NotEmpty(message = "Format must not be empty")
    private String format;

    @NotEmpty(message = "Version must not be empty")
    private String version;

    @NotEmpty(message = "Error correction level must not be empty")
    private String errorCorrectionLevel;

    @NotNull(message = "Image request must not be null")
    private ImageRequest image;
}
