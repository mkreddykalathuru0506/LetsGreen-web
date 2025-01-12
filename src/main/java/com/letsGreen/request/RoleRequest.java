package com.letsGreen.request;

import lombok.Data;
import jakarta.validation.constraints.*;
import java.io.Serializable;
import java.util.List;

@Data
public class RoleRequest implements Serializable {

    @NotBlank(message = "ID cannot be blank")
    private String id;

    @Min(value = 0, message = "Salary range must be at least 0")
    private int salaryRange;

    @NotBlank(message = "Name cannot be blank")
    private String name;

    @NotBlank(message = "Tenure cannot be blank")
    private String tenure;

    @NotBlank(message = "Work timings cannot be blank")
    private String workTimings;

    @NotEmpty(message = "Task list cannot be empty")
    private List<@NotBlank(message = "Task cannot be blank") String> taskList;

    @NotEmpty(message = "Conditions list cannot be empty")
    private List<@NotBlank(message = "Condition cannot be blank") String> conditions;
}
