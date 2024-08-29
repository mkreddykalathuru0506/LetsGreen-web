package com.letsGreen.controller;

import com.letsGreen.entity.Sponsor;
import com.letsGreen.service.SponsorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/sponsors")
public class SponsorController {

    @Autowired
    private SponsorService sponsorService;

    @PostMapping
    public ResponseEntity<String> createSponsor(@RequestBody Sponsor sponsor) {
        Sponsor createdSponsor = sponsorService.createSponsor(sponsor);
        return new ResponseEntity<>("Sponsor created with ID: " + createdSponsor.getSponser_id(), HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<String> getSponsorById(@PathVariable Long id) {
        Sponsor sponsor = sponsorService.getSponsorById(id);
        if (sponsor != null) {
            return new ResponseEntity<>("Sponsor found: " + sponsor.toString(), HttpStatus.OK);
        } else {
            return new ResponseEntity<>("Sponsor not found", HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping
    public ResponseEntity<String> getAllSponsors() {
        List<Sponsor> sponsors = sponsorService.getAllSponsors();
        return new ResponseEntity<>("All Sponsors: " + sponsors.toString(), HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<String> updateSponsor(@PathVariable Long id, @RequestBody Sponsor sponsor) {
        Sponsor updatedSponsor = sponsorService.updateSponsor(id, sponsor);
        if (updatedSponsor != null) {
            return new ResponseEntity<>("Sponsor updated: " + updatedSponsor.toString(), HttpStatus.OK);
        } else {
            return new ResponseEntity<>("Sponsor not found", HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteSponsor(@PathVariable Long id) {
        sponsorService.deleteSponsor(id);
        return new ResponseEntity<>("Sponsor deleted", HttpStatus.NO_CONTENT);
    }
}
