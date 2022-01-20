package net.javahaul.springbootforhaulmont.service;

import com.sun.istack.Nullable;
import net.javahaul.springbootforhaulmont.model.OfferCredit;
import net.javahaul.springbootforhaulmont.repository.OfferCreditRepo;
import org.springframework.beans.factory.annotation.Autowired;
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
    public List<OfferCredit> findClientId(UUID clientId) {
        return offerCreditRepo.findClientId(clientId);
    }

    @Override
    @Nullable
    public OfferCredit findOfferCredit(UUID id) {
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



