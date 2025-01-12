package com.letsGreen.domain;

import lombok.Data;
import java.util.Date;
import java.util.List;

@Data
public class NurseryDomain {
    private String id;
    private AddressDomain address;
    private Date startDate;
    private UserDomain owner;
    private ImageDomain photo;
    private ImageDomain ownerPhoto;
    private List<TreeDomain> availableTrees;
    private List<TreeDomain> bookedTrees;
    private List<TreeDomain> upcomingTrees;
    private int capacity;
}
