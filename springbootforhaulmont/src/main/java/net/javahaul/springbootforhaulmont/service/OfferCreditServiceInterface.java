package net.javahaul.springbootforhaulmont.service;

import net.javahaul.springbootforhaulmont.model.OfferCredit;

import java.util.List;
import java.util.UUID;

public interface OfferCreditServiceInterface {
    OfferCredit findOfferOfCreditById(UUID id);
    List<OfferCredit> findByClientId(UUID clientId);

    void saveOfferCredit(OfferCredit offerCredit);

    void deleteOfferCreditById(UUID id);
}
