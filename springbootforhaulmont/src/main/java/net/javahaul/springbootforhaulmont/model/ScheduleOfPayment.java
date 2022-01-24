package net.javahaul.springbootforhaulmont.model;

import lombok.*;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Objects;
import java.util.UUID;

@AllArgsConstructor
@Builder
@NoArgsConstructor
@Entity

@ToString
public class ScheduleOfPayment {
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
        ScheduleOfPayment that = (ScheduleOfPayment) o;
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

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public LocalDate getDatePayment() {
        return datePayment;
    }

    public void setDatePayment(LocalDate datePayment) {
        this.datePayment = datePayment;
    }

    public BigDecimal getAmountPayment() {
        return amountPayment;
    }

    public void setAmountPayment(BigDecimal amountPayment) {
        this.amountPayment = amountPayment;
    }

    public BigDecimal getAmountPaymentPerBody() {
        return amountPaymentPerBody;
    }

    public void setAmountPaymentPerBody(BigDecimal amountPaymentPerBody) {
        this.amountPaymentPerBody = amountPaymentPerBody;
    }

    public BigDecimal getAmountRepaymentPercent() {
        return amountRepaymentPercent;
    }

    public void setAmountRepaymentPercent(BigDecimal amountRepaymentPercent) {
        this.amountRepaymentPercent = amountRepaymentPercent;
    }

    public BigDecimal getBalance() {
        return balance;
    }

    public void setBalance(BigDecimal balance) {
        this.balance = balance;
    }

    public OfferCredit getOfferOfCredit() {
        return offerOfCredit;
    }

    public void setOfferOfCredit(OfferCredit offerOfCredit) {
        this.offerOfCredit = offerOfCredit;
    }


}

