package com.letsGreen.controller;

import com.letsGreen.entity.Decease;
import com.letsGreen.service.DeceaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/deceases")
public class DeceaseController {

    @Autowired
    private DeceaseService deceaseService;

    @PostMapping
    public ResponseEntity<String> createDecease(@RequestBody Decease decease) {
        Decease createdDecease = deceaseService.createDecease(decease);
        return new ResponseEntity<>("Decease created with ID: " + createdDecease.getId(), HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<String> getDeceaseById(@PathVariable Long id) {
        Decease decease = deceaseService.getDeceaseById(id);
        if (decease != null) {
            return new ResponseEntity<>("Decease found: " + decease.toString(), HttpStatus.OK);
        } else {
            return new ResponseEntity<>("Decease not found", HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping
    public ResponseEntity<String> getAllDeceases() {
        List<Decease> deceases = deceaseService.getAllDeceases();
        return new ResponseEntity<>("All Deceases: " + deceases.toString(), HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<String> updateDecease(@PathVariable Long id, @RequestBody Decease decease) {
        Decease updatedDecease = deceaseService.updateDecease(id, decease);
        if (updatedDecease != null) {
            return new ResponseEntity<>("Decease updated: " + updatedDecease.toString(), HttpStatus.OK);
        } else {
            return new ResponseEntity<>("Decease not found", HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteDecease(@PathVariable Long id) {
        deceaseService.deleteDecease(id);
        return new ResponseEntity<>("Decease deleted", HttpStatus.NO_CONTENT);
    }
}
