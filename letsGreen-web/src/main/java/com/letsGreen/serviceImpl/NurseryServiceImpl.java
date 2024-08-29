package com.letsGreen.serviceImpl;

import com.letsGreen.entity.Nursery;
import com.letsGreen.repository.NurseryRepository;
import com.letsGreen.service.NurseryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class NurseryServiceImpl implements NurseryService {

    @Autowired
    private NurseryRepository nurseryRepository;

    @Override
    public Nursery createNursery(Nursery nursery) {
        return nurseryRepository.save(nursery);
    }

    @Override
    public Nursery getNurseryById(Long id) {
        return nurseryRepository.findById(id).orElse(null);
    }

    @Override
    public List<Nursery> getAllNurseries() {
        return nurseryRepository.findAll();
    }

    @Override
    public Nursery updateNursery(Long id, Nursery nursery) {
        if (nurseryRepository.existsById(id)) {
            nursery.setId(id);
            return nurseryRepository.save(nursery);
        }
        return null;
    }

    @Override
    public void deleteNursery(Long id) {
        nurseryRepository.deleteById(id);
    }
}
