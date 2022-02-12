package net.javahaul.springbootforhaulmont.model;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.hibernate.Hibernate;

import javax.persistence.*;
import javax.validation.constraints.*;
import java.math.BigDecimal;
import java.util.List;
import java.util.Objects;
import java.util.UUID;

@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "CREDIT")
public class Credit  {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "CREDIT_ID")
    private UUID id;

    @ManyToOne
    @JoinColumn(name = "BANK_ID")
    private Bank bank;

    @NotNull(message = "Кредитный лимит является обязательным полем")
    @DecimalMin(value = "1,00", message = "Должно быть больше 1,00")
    @DecimalMax(value = "200030001,00", message = "Должно быть меньше 200030001,00")
    @Digits(integer = 9, fraction = 2, message = "Числа перед точкой должны быть не более 9 и " +
            "после не более чем 2, например: 200030000.99")
    @Column(name = "LIMIT_OF_MONEY")
    private BigDecimal limitOfMoney;

    @NotNull(message = "Обязательное поле Процентная ставка по кредиту в год")
    @DecimalMin(value = "5.00", message = "Должно быть больше 5,00")
    @DecimalMax(value = "360.00", message = "Должно быть меньше 360,00")
    @Digits(integer = 3, fraction = 2, message = "Числа перед точкой должны быть не более 3 и " +
            "после не более чем 2, например: 359,99")
    @Column(name = "CREDIT_PERCENTAGE")
    private BigDecimal creditPercentage;

    @NotBlank(message = "Название является обязательным полем")
    @Size(min = 2, message = "Название должно быть не менее 2 символов")
    @Column(name = "TYPE_OF_CREDIT")
    public String typeOfCredit;



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
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        Credit credit = (Credit) o;

        return id != null && id.equals(credit.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(limitOfMoney, creditPercentage, typeOfCredit);
    }

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

}


