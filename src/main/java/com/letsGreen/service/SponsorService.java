package com.letsGreen.service;

import com.letsGreen.entity.Sponsor;
import java.util.List;

public interface SponsorService {
    Sponsor createSponsor(Sponsor sponsor);
    Sponsor getSponsorById(Long id);
    List<Sponsor> getAllSponsors();
    Sponsor updateSponsor(Long id, Sponsor sponsor);
    void deleteSponsor(Long id);
}
