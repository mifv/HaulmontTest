package net.javahaul.springbootforhaulmont.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.List;
import java.util.Objects;
import java.util.UUID;

@AllArgsConstructor
@NoArgsConstructor
@Entity
@Getter
@Setter
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
    private List<OfferCredit> offerOfCreditList;


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

