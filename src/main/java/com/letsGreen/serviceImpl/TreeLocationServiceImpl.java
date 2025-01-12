package com.letsGreen.serviceImpl;

import com.letsGreen.entity.TreeLocation;
import com.letsGreen.repository.TreeLocationRepository;
import com.letsGreen.service.TreeLocationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TreeLocationServiceImpl implements TreeLocationService {

    @Autowired
    private TreeLocationRepository treeLocationRepository;

    @Override
    public TreeLocation createTreeLocation(TreeLocation treeLocation) {
        return treeLocationRepository.save(treeLocation);
    }

    @Override
    public TreeLocation getTreeLocationById(Long id) {
        return treeLocationRepository.findById(id).orElse(null);
    }

    @Override
    public List<TreeLocation> getAllTreeLocations() {
        return treeLocationRepository.findAll();
    }

    @Override
    public TreeLocation updateTreeLocation(Long id, TreeLocation treeLocation) {
        if (treeLocationRepository.existsById(id)) {
            treeLocation.setId(id);
            return treeLocationRepository.save(treeLocation);
        }
        return null;
    }

    @Override
    public void deleteTreeLocation(Long id) {
        treeLocationRepository.deleteById(id);
    }
}
