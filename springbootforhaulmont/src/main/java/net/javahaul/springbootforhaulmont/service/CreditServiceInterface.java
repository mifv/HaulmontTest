package net.javahaul.springbootforhaulmont.service;

import net.javahaul.springbootforhaulmont.model.Credit;

import java.util.List;
import java.util.UUID;

public interface CreditServiceInterface {
    Credit findCredit(UUID id);

    List<Credit> findBankId(UUID bankId);

    void saveCredit(Credit credit);

    void deleteCredit(UUID id);

}
