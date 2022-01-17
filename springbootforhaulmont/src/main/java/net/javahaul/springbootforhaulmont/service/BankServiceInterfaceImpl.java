package net.javahaul.springbootforhaulmont.service;

import com.sun.istack.Nullable;
import net.javahaul.springbootforhaulmont.model.Bank;
import net.javahaul.springbootforhaulmont.repository.BankRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;


@Service
public class BankServiceInterfaceImpl implements BankServiceInterface {
    private final BankRepo bankRepository;

    @Autowired
    public BankServiceInterfaceImpl(BankRepo bankRepository) {
        this.bankRepository = bankRepository;
    }

    @Override
    public List<Bank> findAll() {
        return bankRepository.findAll();

    }

    @Nullable
    @Override
    public Bank findBankByID(UUID id) {
        return bankRepository.findById(id).orElse(null);
    }

    @Override
    public void deleteBankById(UUID id) {
        bankRepository.deleteById(id);
    }

    @Override
    public void saveBank(Bank bank) {
        bankRepository.save(bank);
    }
}
