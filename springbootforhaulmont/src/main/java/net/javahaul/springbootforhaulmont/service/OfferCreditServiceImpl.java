package net.javahaul.springbootforhaulmont.service;


import net.javahaul.springbootforhaulmont.model.OfferCredit;
import net.javahaul.springbootforhaulmont.repository.OfferCreditRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class OfferCreditServiceImpl implements OfferCreditServiceInterface {
    private OfferCreditRepo offerCreditRepo;

    @Autowired
    public OfferCreditServiceImpl(OfferCreditRepo offerCreditRepo) {
        this.offerCreditRepo = offerCreditRepo;
    }

    @Override
    public List<OfferCredit> findByClientId(UUID clientId) {
        return offerCreditRepo.findClientId(clientId);
    }

    @Nullable
    @Override
    public OfferCredit findOfferOfCreditById(UUID id) {
        return offerCreditRepo.findById(id).orElse(null);
    }


    @Override
    public void deleteOfferCreditById(UUID id) {
        offerCreditRepo.deleteById(id);
    }

    @Override
    public void saveOfferCredit(OfferCredit offerCredit) {
        offerCreditRepo.save(offerCredit);
    }
}



