package net.javahaul.springbootforhaulmont.model;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.List;
import java.util.Objects;
import java.util.UUID;

@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Credit {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)

    private UUID id;


    private BigDecimal limitOfMoney;

    private BigDecimal creditPercentage;


    public String typeOfCredit;

    @ManyToOne
    private Bank bank;

    @OneToMany(mappedBy = "credit", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List <OfferCredit> offerOfCreditList;

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public BigDecimal getLimitOfMoney() {
        return limitOfMoney;
    }

    public void setLimitOfMoney(BigDecimal limitOfMoney) {
        this.limitOfMoney = limitOfMoney;
    }

    public BigDecimal getCreditPercentage() {
        return creditPercentage;
    }

    public void setCreditPercentage(BigDecimal creditPercentage) {
        this.creditPercentage = creditPercentage;
    }

    public String getTypeOfCredit() {
        return typeOfCredit;
    }

    public void setTypeOfCredit(String typeOfCredit) {
        this.typeOfCredit = typeOfCredit;
    }

    public Bank getBank() {
        return bank;
    }

    public void setBank(Bank bank) {
        this.bank = bank;
    }

    public List<OfferCredit> getOfferOfCreditList() {
        return offerOfCreditList;
    }

    public void setOfferOfCreditList(List<OfferCredit> offerOfCreditList) {
        this.offerOfCreditList = offerOfCreditList;
    }

    @Override
    public String toString() {
        return String.format("Type: %s, %nLimit: %.2f, %nInterest rate (%%): %.2f",
                typeOfCredit, limitOfMoney, creditPercentage);


    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Credit credit = (Credit) o;
        return Objects.equals(id, credit.id) &&
                Objects.equals(limitOfMoney, credit.limitOfMoney) &&
                Objects.equals(creditPercentage, credit.creditPercentage) &&
                Objects.equals(typeOfCredit, credit.typeOfCredit) &&
                Objects.equals(bank, credit.bank) &&
                Objects.equals(offerOfCreditList, credit.offerOfCreditList);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, limitOfMoney, creditPercentage, typeOfCredit, bank, offerOfCreditList);
    }
}

