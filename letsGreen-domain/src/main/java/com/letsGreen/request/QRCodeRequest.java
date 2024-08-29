package com.letsGreen.request;

import lombok.Data;
import java.io.Serializable;

@Data
public class QRCodeRequest implements Serializable {
    private String data;
    private String format;
    private String version;
    private String errorCorrectionLevel;
    private ImageRequest image;
}
