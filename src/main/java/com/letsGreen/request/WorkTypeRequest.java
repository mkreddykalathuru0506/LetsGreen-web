package com.letsGreen.request;

import lombok.Data;
import java.io.Serializable;

@Data
public class WorkTypeRequest implements Serializable {
    private String typeName;
}
