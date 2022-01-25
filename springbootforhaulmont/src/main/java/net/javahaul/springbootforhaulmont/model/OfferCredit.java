package net.javahaul.springbootforhaulmont.model;

import lombok.*;

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
@Getter
@Setter
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
    @OneToMany(mappedBy = "offerOfCredit", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
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
}



