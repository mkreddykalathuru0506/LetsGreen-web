package com.letsGreen.domain;

import lombok.Data;
import java.util.List;

@Data
public class RoleDomain {
    private String id;
    private int salaryRange;
    private String name;
    private String tenure;
    private String workTimings;
    private List<String> taskList;
    private List<String> conditions;
}
