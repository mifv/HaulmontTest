package net.javahaul.springbootforhaulmont.model;

import lombok.*;

import javax.persistence.*;
import java.util.List;
import java.util.Objects;
import java.util.UUID;

@AllArgsConstructor
@NoArgsConstructor
@Entity
@ToString
@Table(name = "banks")
public class Bank {
    public UUID getBank_id() {
        return bank_id;
    }

    public void setBank_id(UUID bank_id) {
        this.bank_id = bank_id;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID bank_id;


    private String Bank_name;

    @ToString.Exclude
    @OneToMany(mappedBy = "bank", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<Credit> listOfCredits;

    @ToString.Exclude
    @OneToMany(mappedBy = "bank", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<Client> listOfClients;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Bank bank = (Bank) o;
        return Objects.equals(bank_id, bank.bank_id) &&
                Objects.equals(Bank_name, bank.Bank_name) &&
                Objects.equals(listOfCredits, bank.listOfCredits) &&
                Objects.equals(listOfClients, bank.listOfClients);
    }

    @Override
    public int hashCode() {
        return Objects.hash(Bank_name);
    }
}
