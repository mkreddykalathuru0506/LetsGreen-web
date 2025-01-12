package com.letsGreen.service;

import com.letsGreen.entity.Decease;
import java.util.List;

public interface DeceaseService {
    Decease createDecease(Decease decease);
    Decease getDeceaseById(Long id);
    List<Decease> getAllDeceases();
    Decease updateDecease(Long id, Decease decease);
    void deleteDecease(Long id);
}
