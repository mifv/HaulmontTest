package net.javahaul.springbootforhaulmont.model;

import lombok.*;
import org.hibernate.Hibernate;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import javax.validation.constraints.DecimalMax;
import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.Digits;
import javax.validation.constraints.NotNull;
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

    @NotNull(message = "Дата платежа является обязательным полем")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @Column(name = "DATE_OF_PAYMENT")
    private LocalDate dateOfPayment;

    @NotNull(message = "Ограничение суммы платежа является обязательным полем")
    @DecimalMin(value = "1.00", message = "Должно быть больше 1.00")
    @DecimalMax(value = "200030001.00", message = "Должно быть меньше 200030001.00")
    @Digits(integer = 9, fraction = 2, message = "Числа перед точкой должны быть не более 9 и " +
            "после не более чем 2, например: 200030000.99")
    @Column(name = "AMOUNT_OF_PAYMENT")
    private BigDecimal amountOfPayment;

    @NotNull(message = "Сумма платежа является обязательным полем")
    @DecimalMin(value = "1.00", message = "Должно быть больше 1.00")
    @DecimalMax(value = "200030001.00", message = "Должно быть меньше 200030001.00")
    @Digits(integer = 9, fraction = 2, message = "Числа перед точкой должны быть не более 9 и " +
            "после не более чем 2, например: 200030000.99")
    @Column(name = "AMOUNT_OF_PAYMENT_PER_BODY")
    private BigDecimal amountOfPaymentPerBody;

    @NotNull(message = "Cумма оплаты процентов является обязательным полем")
    @DecimalMin(value = "1.00", message = "Должно быть больше 1.00")
    @DecimalMax(value = "200030001.00", message = "Должно быть меньше 200030001.00")
    @Digits(integer = 9, fraction = 2, message = "Числа перед точкой должны быть не более 9 и " +
            "после не более чем 2, например: 200030000.99")
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


