package com.letsGreen.request;

import lombok.Data;
import java.io.Serializable;

@Data
public class GroupRequest implements Serializable {
    private String groupName;
}
