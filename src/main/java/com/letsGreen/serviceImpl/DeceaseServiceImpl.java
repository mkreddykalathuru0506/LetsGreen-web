package com.letsGreen.serviceImpl;

import com.letsGreen.entity.Decease;
import com.letsGreen.repository.DeceaseRepository;
import com.letsGreen.service.DeceaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DeceaseServiceImpl implements DeceaseService {

    @Autowired
    private DeceaseRepository deceaseRepository;

    @Override
    public Decease createDecease(Decease decease) {
        return deceaseRepository.save(decease);
    }

    @Override
    public Decease getDeceaseById(Long id) {
        return deceaseRepository.findById(id).orElse(null);
    }

    @Override
    public List<Decease> getAllDeceases() {
        return deceaseRepository.findAll();
    }

    @Override
    public Decease updateDecease(Long id, Decease decease) {
        if (deceaseRepository.existsById(id)) {
            decease.setId(id);
            return deceaseRepository.save(decease);
        }
        return null;
    }

    @Override
    public void deleteDecease(Long id) {
        deceaseRepository.deleteById(id);
    }
}
