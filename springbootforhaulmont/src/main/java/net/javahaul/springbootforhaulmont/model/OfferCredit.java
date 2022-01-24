package net.javahaul.springbootforhaulmont.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;
import lombok.ToString;

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
public class OfferCredit {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)

    private UUID id;

    @ToString.Exclude
    @ManyToOne(cascade = CascadeType.MERGE)
    private Client client;


    @ManyToOne(cascade = CascadeType.MERGE)
    private Credit credit;


    private BigDecimal sum;

    @ToString.Exclude
    @OneToMany(mappedBy = "offerCredit", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<ScheduleOfPayment> scheduleOfPayment;

    @Column(name = "NAME_OF_CREDIT")
    private String nameCredit;

    @Column(name = "SUM_OF_PERCENT")
    private BigDecimal sumPercent;

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
        if (o == null || getClass() != o.getClass()) return false;
        OfferCredit that = (OfferCredit) o;
        return Objects.equals(client, that.client) &&
                Objects.equals(credit, that.credit) &&
                Objects.equals(sum, that.sum) &&
                Objects.equals(scheduleOfPayment, that.scheduleOfPayment) &&
                Objects.equals(nameCredit, that.nameCredit) &&
                Objects.equals(sumPercent, that.sumPercent) &&
                Objects.equals(firstPayment, that.firstPayment) &&
                Objects.equals(creditTerm, that.creditTerm) &&
                Objects.equals(bank, that.bank);
    }

    @Override
    public int hashCode() {
        return Objects.hash(sum, scheduleOfPayment, nameCredit, sumPercent, firstPayment, creditTerm, bank);
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

    public String getNameCredit() {
        return nameCredit;
    }

    public void setNameCredit(String nameCredit) {
        this.nameCredit = nameCredit;
    }

    public BigDecimal getSumPercent() {
        return sumPercent;
    }

    public void setSumPercent(BigDecimal sumPercent) {
        this.sumPercent = sumPercent;
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
}

