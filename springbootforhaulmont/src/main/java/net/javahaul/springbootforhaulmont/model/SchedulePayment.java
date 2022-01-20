package net.javahaul.springbootforhaulmont.model;

import lombok.*;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Objects;
import java.util.UUID;

@AllArgsConstructor
@NoArgsConstructor
@Entity
@Builder
@Getter
@Setter
@ToString
public class SchedulePayment {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)

    private UUID id;


    private LocalDate datePayment;

    private BigDecimal amountPayment;

    private BigDecimal amountPaymentPerBody;


    private BigDecimal amountRepaymentPercent;


    private BigDecimal balance;

    @ManyToOne
    @JoinColumn(name = "OFFER_OF_CREDIT_ID")
    private OfferCredit offerOfCredit;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        SchedulePayment that = (SchedulePayment) o;
        return Objects.equals(datePayment, that.datePayment) &&
                Objects.equals(amountPayment, that.amountPayment) &&
                Objects.equals(amountPaymentPerBody, that.amountPaymentPerBody) &&
                Objects.equals(amountRepaymentPercent, that.amountRepaymentPercent) &&
                Objects.equals(balance, that.balance);
    }

    @Override
    public int hashCode() {
        return Objects.hash(datePayment, amountPayment, amountPaymentPerBody, amountRepaymentPercent, balance);
    }
}
