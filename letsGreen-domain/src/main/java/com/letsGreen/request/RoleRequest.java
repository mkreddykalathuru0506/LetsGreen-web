package com.letsGreen.request;

import lombok.Data;
import java.io.Serializable;
import java.util.List;

@Data
public class RoleRequest implements Serializable {
    private String id;
    private int salaryRange;
    private String name;
    private String tenure;
    private String workTimings;
    private List<String> taskList;
    private List<String> conditions;
}
