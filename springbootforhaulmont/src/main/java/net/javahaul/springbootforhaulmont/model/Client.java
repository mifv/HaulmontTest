package net.javahaul.springbootforhaulmont.model;

import lombok.*;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;
import java.util.List;
import java.util.Objects;
import java.util.UUID;

@AllArgsConstructor
@NoArgsConstructor
@ToString
@Getter
@Setter
@Entity
public class Client {

    private UUID id;

    private String firstName;
    private String middleName;
    private String lastName;
    private String phone;
    private String email;

    private String passport;

    private Bank bank;
    @OneToMany(mappedBy = "client", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @ToString.Exclude
    private List<OfferCredit> offerCreditList;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Client client = (Client) o;
        return Objects.equals(id, client.id) &&
                Objects.equals(firstName, client.firstName) &&
                Objects.equals(middleName, client.middleName) &&
                Objects.equals(lastName, client.lastName) &&
                Objects.equals(phone, client.phone) &&
                Objects.equals(email, client.email) &&
                Objects.equals(passport, client.passport) &&
                Objects.equals(bank, client.bank) &&
                Objects.equals(offerCreditList, client.offerCreditList);
    }

    @Override
    public int hashCode() {
        return Objects.hash(firstName, middleName, lastName, phone, email, passport);
    }
}