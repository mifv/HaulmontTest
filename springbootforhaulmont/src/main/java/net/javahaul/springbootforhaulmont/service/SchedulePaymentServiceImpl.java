package net.javahaul.springbootforhaulmont.service;


import net.javahaul.springbootforhaulmont.model.ScheduleOfPayment;
import net.javahaul.springbootforhaulmont.repository.SchedulePaymentRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class SchedulePaymentServiceImpl implements SchedulePaymentServiceInterface {
    private SchedulePaymentRepo schedulePaymentRepo;

    @Autowired
    public SchedulePaymentServiceImpl(SchedulePaymentRepo schedulePaymentRepo) {
        this.schedulePaymentRepo = schedulePaymentRepo;
    }

    @Override
    public List<ScheduleOfPayment> findByOfferOfCreditId(UUID offerOfCreditId) {
        return schedulePaymentRepo.findByOfferOfCreditId(offerOfCreditId);
    }

    @Override
    public void saveAllScheduleOfPayment(List<ScheduleOfPayment> scheduleOfPaymentList) {
        schedulePaymentRepo.saveAll(scheduleOfPaymentList);
    }

    @Override
    public void saveScheduleOfPayment(ScheduleOfPayment scheduleOfPayment) {
        schedulePaymentRepo.save(scheduleOfPayment);
    }
@Nullable
    @Override
    public ScheduleOfPayment findScheduleOfPaymentById(UUID id) {
        return schedulePaymentRepo.findById(id).orElse(null);
    }

    @Override
    public void deleteAllByCreditOfferId(UUID offerOfCreditId) {
        schedulePaymentRepo.deleteAllByOfferOfCreditId(offerOfCreditId);
    }

    @Override
    public void deleteScheduleOfPaymentById(UUID id) {
        schedulePaymentRepo.deleteById(id);
    }
}


