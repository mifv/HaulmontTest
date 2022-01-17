package net.javahaul.springbootforhaulmont.repository;

import net.javahaul.springbootforhaulmont.model.Credit;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface CreditRepo extends JpaRepository<Credit, UUID> {
}
