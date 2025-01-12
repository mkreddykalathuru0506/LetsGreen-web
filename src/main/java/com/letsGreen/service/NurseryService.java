package com.letsGreen.service;

import com.letsGreen.entity.Nursery;
import java.util.List;

public interface NurseryService {
    Nursery createNursery(Nursery nursery);
    Nursery getNurseryById(Long id);
    List<Nursery> getAllNurseries();
    Nursery updateNursery(Long id, Nursery nursery);
    void deleteNursery(Long id);
}
