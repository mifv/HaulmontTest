package net.javahaul.springbootforhaulmont.model;

import lombok.*;
import org.hibernate.Hibernate;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.List;
import java.util.Objects;
import java.util.UUID;


@AllArgsConstructor
@Builder
@NoArgsConstructor
@ToString
@Entity

@Table(name = "OFFER_OF_CREDIT")
public class OfferCredit {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "OFFER_OF_CREDIT_ID")
    private UUID id;

    @ToString.Exclude
    @JoinColumn(name = "CLIENT_ID")
    @ManyToOne(cascade = CascadeType.MERGE)
    private Client client;

    @JoinColumn(name = "CREDIT_ID")
    @ManyToOne(cascade = CascadeType.MERGE)
    private Credit credit;

    @Column(name = "SUM_OF_CREDIT")
    private BigDecimal sum;

    @ToString.Exclude
    @OneToMany(mappedBy = "offerOfCredit", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<ScheduleOfPayment> scheduleOfPayment;

    @Column(name = "NAME_OF_CREDIT")
    private String nameOfCredit;

    @Column(name = "SUM_OF_PERCENT")
    private BigDecimal sumOfPercent;

    @Column(name = "FIRST_PAYMENT")
    private BigDecimal firstPayment;

    @Column(name = "CREDIT_TERM")
    private Integer creditTerm;

    @ToString.Exclude
    @ManyToOne(cascade = CascadeType.MERGE)
    @JoinColumn(name = "BANK_ID")
    private Bank bank;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        OfferCredit that = (OfferCredit) o;

        return id != null && id.equals(that.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(sum, nameOfCredit, sumOfPercent, firstPayment, creditTerm);
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public Credit getCredit() {
        return credit;
    }

    public void setCredit(Credit credit) {
        this.credit = credit;
    }

    public BigDecimal getSum() {
        return sum;
    }

    public void setSum(BigDecimal sum) {
        this.sum = sum;
    }

    public List<ScheduleOfPayment> getScheduleOfPayment() {
        return scheduleOfPayment;
    }

    public void setScheduleOfPayment(List<ScheduleOfPayment> scheduleOfPayment) {
        this.scheduleOfPayment = scheduleOfPayment;
    }



    public void setSumPercent(BigDecimal sumPercent) {
        this.sumOfPercent = sumPercent;
    }

    public BigDecimal getFirstPayment() {
        return firstPayment;
    }

    public void setFirstPayment(BigDecimal firstPayment) {
        this.firstPayment = firstPayment;
    }

    public Integer getCreditTerm() {
        return creditTerm;
    }

    public void setCreditTerm(Integer creditTerm) {
        this.creditTerm = creditTerm;
    }

    public Bank getBank() {
        return bank;
    }

    public void setBank(Bank bank) {
        this.bank = bank;
    }

    public String getNameOfCredit() {
        return nameOfCredit;
    }

    public void setNameOfCredit(String nameOfCredit) {
        this.nameOfCredit = nameOfCredit;
    }

    public BigDecimal getSumOfPercent() {
        return sumOfPercent;
    }

    public void setSumOfPercent(BigDecimal sumOfPercent) {
        this.sumOfPercent = sumOfPercent;
    }
}

