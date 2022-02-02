package net.javahaul.springbootforhaulmont.service;

import net.javahaul.springbootforhaulmont.model.Bank;

import java.util.List;
import java.util.UUID;

public interface BankServiceInterface {
    Bank getBank(UUID id);

    List<Bank> getALLBanks();

    void deleteBankById(UUID id);

    void saveBank(Bank bank);

}
