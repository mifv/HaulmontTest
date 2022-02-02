package net.javahaul.springbootforhaulmont.repository;

import net.javahaul.springbootforhaulmont.model.OfferCredit;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface OfferCreditRepo extends JpaRepository<OfferCredit, UUID> {
    List<OfferCredit> findByClientId(UUID clientId);

}
