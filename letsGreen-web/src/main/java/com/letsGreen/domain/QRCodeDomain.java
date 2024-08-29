package com.letsGreen.domain;

import lombok.Data;

@Data
public class QRCodeDomain {
    private String data;
    private String format;
    private String version;
    private String errorCorrectionLevel;
    private ImageDomain image;
}
