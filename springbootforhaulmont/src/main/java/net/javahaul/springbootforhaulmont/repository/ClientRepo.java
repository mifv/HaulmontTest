package net.javahaul.springbootforhaulmont.repository;

import net.javahaul.springbootforhaulmont.model.Client;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface ClientRepo extends JpaRepository<Client, UUID> {
    List<Client> findByBankId(UUID bankId);
}
