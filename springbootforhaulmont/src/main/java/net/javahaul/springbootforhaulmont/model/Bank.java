package net.javahaul.springbootforhaulmont.model;

import lombok.Data;
import lombok.ToString;

import javax.persistence.*;
import java.util.List;
import java.util.Objects;
import java.util.UUID;

@Data
@Entity
@Table(name = "banks")
public class Bank {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "bank_id")
    private UUID bank_id;

    @Column(name = "bank_name")
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
