package net.javahaul.springbootforhaulmont.service;


import net.javahaul.springbootforhaulmont.model.ScheduleOfPayment;

import java.util.List;
import java.util.UUID;

public interface SchedulePaymentServiceInterface {
    ScheduleOfPayment findScheduleOfPaymentById(UUID id);

    void deleteScheduleOfPaymentById(UUID id);

    void saveAllScheduleOfPayment(List<ScheduleOfPayment> scheduleOfPaymentList);

    void saveScheduleOfPayment(ScheduleOfPayment scheduleOfPayment);

    void deleteAllByCreditOfferId(UUID offerOfCreditId);

    List<ScheduleOfPayment> findByOfferOfCreditId(UUID offerOfCreditId);

}
