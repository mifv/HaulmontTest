package net.javahaul.springbootforhaulmont.service;

import net.javahaul.springbootforhaulmont.model.Credit;
import net.javahaul.springbootforhaulmont.repository.CreditRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class CreditServiceImpl implements CreditServiceInterface {


    private CreditRepo creditRepo;

    @Autowired
    public CreditServiceImpl(CreditRepo creditRepo) {
        this.creditRepo = creditRepo;
    }

    @Override
    public Credit findCredit(UUID id) {
        return creditRepo.findById(id).orElse(null);
    }

    @Override
    public List<Credit> findBankId(UUID bankId) {
        return creditRepo.findByBankId(bankId);
    }

    @Override
    public void saveCredit(Credit credit) {
        creditRepo.save(credit);
    }

    @Override
    public void deleteCredit(UUID id) {
        creditRepo.deleteById(id);
    }
}
