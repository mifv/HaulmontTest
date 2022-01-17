package net.javahaul.springbootforhaulmont.service;

import net.javahaul.springbootforhaulmont.model.Bank;

import java.util.List;
import java.util.UUID;

public interface BankServiceInterface {
    Bank findBankByID(UUID id);

    List<Bank> findAll();

    void deleteBankById(UUID id);

    void saveBank(Bank bank);

}
