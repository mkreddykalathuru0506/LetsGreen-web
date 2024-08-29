package com.letsGreen.controller;

import com.letsGreen.entity.Nursery;
import com.letsGreen.service.NurseryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/nurseries")
public class NurseryController {

    @Autowired
    private NurseryService nurseryService;

    @PostMapping
    public ResponseEntity<String> createNursery(@RequestBody Nursery nursery) {
        Nursery createdNursery = nurseryService.createNursery(nursery);
        return new ResponseEntity<>("Nursery created with ID: " + createdNursery.getId(), HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<String> getNurseryById(@PathVariable Long id) {
        Nursery nursery = nurseryService.getNurseryById(id);
        if (nursery != null) {
            return new ResponseEntity<>("Nursery found: " + nursery.toString(), HttpStatus.OK);
        } else {
            return new ResponseEntity<>("Nursery not found", HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping
    public ResponseEntity<String> getAllNurseries() {
        List<Nursery> nurseries = nurseryService.getAllNurseries();
        return new ResponseEntity<>("All Nurseries: " + nurseries.toString(), HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<String> updateNursery(@PathVariable Long id, @RequestBody Nursery nursery) {
        Nursery updatedNursery = nurseryService.updateNursery(id, nursery);
        if (updatedNursery != null) {
            return new ResponseEntity<>("Nursery updated: " + updatedNursery.toString(), HttpStatus.OK);
        } else {
            return new ResponseEntity<>("Nursery not found", HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteNursery(@PathVariable Long id) {
        nurseryService.deleteNursery(id);
        return new ResponseEntity<>("Nursery deleted", HttpStatus.NO_CONTENT);
    }
}
