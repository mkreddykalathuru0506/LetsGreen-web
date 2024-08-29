package com.letsGreen.request;

import lombok.Data;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;
import java.io.Serializable;

@Data
public class ImageRequest implements Serializable {

    @NotEmpty(message = "Image URL must not be empty")
    @Size(max = 255, message = "Image URL must be less than 255 characters")
    private String imageUrl;

    @Size(max = 100, message = "Alt text must be less than 100 characters")
    private String altText;
}
