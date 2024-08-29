package com.letsGreen.request;

import lombok.Data;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;
import java.io.Serializable;

@Data
public class GroupRequest implements Serializable {

    @NotEmpty(message = "Group name must not be empty")
    @Size(max = 100, message = "Group name must be less than 100 characters")
    private String groupName;
}
