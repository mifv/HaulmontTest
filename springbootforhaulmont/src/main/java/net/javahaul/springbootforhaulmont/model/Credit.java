package net.javahaul.springbootforhaulmont.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
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
    private UUID id;
    private BigDecimal limitMoney;
    private BigDecimal percentageCredit;
    private String typeCredit;
    private Bank bank;

    List<OfferCredit> offerCreditList;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Credit credit = (Credit) o;
        return Objects.equals(id, credit.id) &&
                Objects.equals(limitMoney, credit.limitMoney) &&
                Objects.equals(percentageCredit, credit.percentageCredit) &&
                Objects.equals(typeCredit, credit.typeCredit) &&
                Objects.equals(bank, credit.bank) &&
                Objects.equals(offerCreditList, credit.offerCreditList);
    }

    @Override
    public int hashCode() {
        return Objects.hash(limitMoney, percentageCredit, typeCredit);
    }
}
