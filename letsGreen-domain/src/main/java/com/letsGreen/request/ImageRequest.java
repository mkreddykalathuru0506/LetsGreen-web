package com.letsGreen.request;

import lombok.Data;
import java.io.Serializable;

@Data
public class ImageRequest implements Serializable {
    private String imageUrl;
    private String altText;
}
