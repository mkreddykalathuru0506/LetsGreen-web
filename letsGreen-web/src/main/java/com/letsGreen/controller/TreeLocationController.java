package com.letsGreen.controller;

import com.letsGreen.entity.TreeLocation;
import com.letsGreen.service.TreeLocationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/treeLocations")
public class TreeLocationController {

    @Autowired
    private TreeLocationService treeLocationService;

    @PostMapping
    public ResponseEntity<String> createTreeLocation(@RequestBody TreeLocation treeLocation) {
        TreeLocation createdTreeLocation = treeLocationService.createTreeLocation(treeLocation);
        return new ResponseEntity<>("TreeLocation created with ID: " + createdTreeLocation.getId(), HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<String> getTreeLocationById(@PathVariable Long id) {
        TreeLocation treeLocation = treeLocationService.getTreeLocationById(id);
        if (treeLocation != null) {
            return new ResponseEntity<>("TreeLocation found: " + treeLocation.toString(), HttpStatus.OK);
        } else {
            return new ResponseEntity<>("TreeLocation not found", HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping
    public ResponseEntity<String> getAllTreeLocations() {
        List<TreeLocation> treeLocations = treeLocationService.getAllTreeLocations();
        return new ResponseEntity<>("All TreeLocations: " + treeLocations.toString(), HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<String> updateTreeLocation(@PathVariable Long id, @RequestBody TreeLocation treeLocation) {
        TreeLocation updatedTreeLocation = treeLocationService.updateTreeLocation(id, treeLocation);
        if (updatedTreeLocation != null) {
            return new ResponseEntity<>("TreeLocation updated: " + updatedTreeLocation.toString(), HttpStatus.OK);
        } else {
            return new ResponseEntity<>("TreeLocation not found", HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteTreeLocation(@PathVariable Long id) {
        treeLocationService.deleteTreeLocation(id);
        return new ResponseEntity<>("TreeLocation deleted", HttpStatus.NO_CONTENT);
    }
}
