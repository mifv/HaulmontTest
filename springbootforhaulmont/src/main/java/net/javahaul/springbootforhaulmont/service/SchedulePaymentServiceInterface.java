package net.javahaul.springbootforhaulmont.service;

import net.javahaul.springbootforhaulmont.model.SchedulePayment;

import java.util.List;
import java.util.UUID;

public interface SchedulePaymentServiceInterface {
    SchedulePayment findSchedulePayment(UUID id);

    void deleteSchedulePayment(UUID id);
    void saveAllScheduleOfPayment(List<SchedulePayment> scheduleOfPaymentList);
    void saveSchedulePayment(SchedulePayment schedulePayment);
    void deleteAllByCreditOfferId(UUID offerOfCreditId);
    List<SchedulePayment> findByOfferOfCreditId(UUID offerOfCreditId);

}
