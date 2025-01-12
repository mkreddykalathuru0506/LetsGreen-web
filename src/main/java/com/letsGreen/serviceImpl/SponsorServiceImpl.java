package com.letsGreen.serviceImpl;

import com.letsGreen.entity.Sponsor;
import com.letsGreen.repository.SponsorRepository;
import com.letsGreen.service.SponsorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SponsorServiceImpl implements SponsorService {

    @Autowired
    private SponsorRepository sponsorRepository;

    @Override
    public Sponsor createSponsor(Sponsor sponsor) {
        return sponsorRepository.save(sponsor);
    }

    @Override
    public Sponsor getSponsorById(Long id) {
        return sponsorRepository.findById(id).orElse(null);
    }

    @Override
    public List<Sponsor> getAllSponsors() {
        return sponsorRepository.findAll();
    }

    @Override
    public Sponsor updateSponsor(Long id, Sponsor sponsor) {
        if (sponsorRepository.existsById(id)) {
            sponsor.setSponser_id(id);
            return sponsorRepository.save(sponsor);
        }
        return null;
    }

    @Override
    public void deleteSponsor(Long id) {
        sponsorRepository.deleteById(id);
    }
}
