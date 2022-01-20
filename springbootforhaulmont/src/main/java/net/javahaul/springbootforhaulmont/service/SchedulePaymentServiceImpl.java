package net.javahaul.springbootforhaulmont.service;

import net.javahaul.springbootforhaulmont.model.SchedulePayment;
import net.javahaul.springbootforhaulmont.repository.SchedulePaymentRepo;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.UUID;

public class SchedulePaymentServiceImpl implements SchedulePaymentServiceInterface {
    private SchedulePaymentRepo schedulePaymentRepo;

    @Autowired
    public SchedulePaymentServiceImpl(SchedulePaymentRepo schedulePaymentRepo) {
        this.schedulePaymentRepo = schedulePaymentRepo;
    }

    @Override
    public List<SchedulePayment> findByOfferOfCreditId(UUID offerOfCreditId) {
        return schedulePaymentRepo.findByOfferOfCreditId(offerOfCreditId);
    }

    @Override
    public void saveAllScheduleOfPayment(List<SchedulePayment> scheduleOfPaymentList) {
        schedulePaymentRepo.saveAll(scheduleOfPaymentList);
    }

    @Override
    public void saveSchedulePayment(SchedulePayment schedulePayment) {
        schedulePaymentRepo.save(schedulePayment);
    }

    @Override
    public SchedulePayment findSchedulePayment(UUID id) {
        return schedulePaymentRepo.findById(id).orElse(null);
    }

    @Override
    public void deleteAllByCreditOfferId(UUID offerOfCreditId) {
        schedulePaymentRepo.deleteAllByOfferOfCreditId(offerOfCreditId);
    }

    @Override
    public void deleteSchedulePayment(UUID id) {
        schedulePaymentRepo.deleteById(id);
    }
}


