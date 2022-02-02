package net.javahaul.springbootforhaulmont.model;

import lombok.*;
import org.hibernate.Hibernate;

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
@Table(name = "SCHEDULE_OF_PAYMENT")
public class ScheduleOfPayment {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "SCHEDULE_OF_PAYMENT_ID")
    private UUID id;

    @Column(name = "DATE_OF_PAYMENT")
    private LocalDate dateOfPayment;
    @Column(name = "AMOUNT_OF_PAYMENT")
    private BigDecimal amountOfPayment;
    @Column(name = "AMOUNT_OF_PAYMENT_PER_BODY")
    private BigDecimal amountOfPaymentPerBody;

    @Column(name = "AMOUNT_OF_REPAYMENT_PERCENT")
    private BigDecimal amountOfRepaymentPercent;
    @Column(name = "BALANCE")
    private BigDecimal balance;

    @ManyToOne
    @JoinColumn(name = "OFFER_OF_CREDIT_ID")
    private OfferCredit offerOfCredit;


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        ScheduleOfPayment that = (ScheduleOfPayment) o;

        return id != null && id.equals(that.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(dateOfPayment, amountOfPayment, amountOfPaymentPerBody, amountOfRepaymentPercent, balance);
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public LocalDate getDatePayment() {
        return dateOfPayment;
    }

    public void setDatePayment(LocalDate datePayment) {
        this.dateOfPayment = datePayment;
    }

    public BigDecimal getAmountPayment() {
        return amountOfPayment;
    }

    public void setAmountPayment(BigDecimal amountPayment) {
        this.amountOfPayment = amountPayment;
    }

    public BigDecimal getAmountPaymentPerBody() {
        return amountOfPaymentPerBody;
    }

    public void setAmountPaymentPerBody(BigDecimal amountPaymentPerBody) {
        this.amountOfPaymentPerBody = amountPaymentPerBody;
    }

    public LocalDate getDateOfPayment() {
        return dateOfPayment;
    }


    public BigDecimal getAmountOfPayment() {
        return amountOfPayment;
    }



    public BigDecimal getAmountOfPaymentPerBody() {
        return amountOfPaymentPerBody;
    }


    public BigDecimal getAmountOfRepaymentPercent() {
        return amountOfRepaymentPercent;
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


