package com.letsGreen.request;

import lombok.Data;
import java.io.Serializable;
import java.util.Date;
import java.util.List;

@Data
public class NurseryRequest implements Serializable {
    private String id;
    private AddressRequest address;
    private Date startDate;
    private UserRequest owner;
    private ImageRequest photo;
    private ImageRequest ownerPhoto;
    private List<TreeRequest> availableTrees;
    private List<TreeRequest> bookedTrees;
    private List<TreeRequest> upcomingTrees;
    private int capacity;
}
