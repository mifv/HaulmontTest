package net.javahaul.springbootforhaulmont.repository;

import net.javahaul.springbootforhaulmont.model.SchedulePayment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface SchedulePaymentRepo extends JpaRepository<SchedulePayment, UUID> {
    List<SchedulePayment> findByOfferOfCreditId(UUID OfferOfCreditId);

    void deleteAllByOfferOfCreditId(UUID id);


}
