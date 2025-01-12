package com.letsGreen.service;

import com.letsGreen.entity.TreeLocation;
import java.util.List;

public interface TreeLocationService {
    TreeLocation createTreeLocation(TreeLocation treeLocation);
    TreeLocation getTreeLocationById(Long id);
    List<TreeLocation> getAllTreeLocations();
    TreeLocation updateTreeLocation(Long id, TreeLocation treeLocation);
    void deleteTreeLocation(Long id);
}
