package net.javahaul.springbootforhaulmont.model;

import lombok.*;
import org.hibernate.Hibernate;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
import java.util.List;
import java.util.Objects;
import java.util.UUID;

@AllArgsConstructor
@NoArgsConstructor
@ToString
@Entity

@Table(name = "CLIENT")
public class Client {


    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "CLIENT_ID")
    private UUID id;

    @NotBlank(message = "Имя является обязательным полем")
    @Column(name = "FIRST_NAME")
    private String firstName;

    @NotBlank(message = "Отчество является обязательным полем")
    @Column(name = "MIDDLE_NAME")
    private String middleName;

    @NotBlank(message = "Фамилия является обязательным полем")
    @Column(name = "LAST_NAME")
    private String lastName;

    @NotBlank(message = "Номер телефона является обязательным полем")
    @Pattern(regexp = "\\d{3}-\\d{3}-\\d{2}-\\d{2}",
            message = "Пожалуйста используйте шаблон XXX-XXX-XX-XX for example \"987-964-39-60\"")
    @Column(name = "PHONE_NUMBER")
    private String phoneNumber;

    @Pattern(regexp = "^(?=.{1,64}@)[A-Za-z0-9_-]+(\\.[A-Za-z0-9_-]+)*@[^-][A-Za-z0-9-]+(\\.[A-Za-z0-9-]+)*" +
            "(\\.[A-Za-z]{2,})$", message = "Пожалуйста используйте шаблон \"login@siteAddress.domainName\" " +
            "for example \"top@yandex.com\"")
    @Column(name = "EMAIL")
    private String email;

    @NotBlank(message = "Номер паспорта является обязательным полем")
    @Pattern(regexp = "\\d{2}-\\d{2}-\\d{6}", message = "Пожалуйста используйте шаблон XX-XX-XXXXXX for example \"36-11-502830\"")
    @Column(name = "PASSPORT_NUMBER")
    private String passportNumber;

    @ManyToOne
    @JoinColumn(name = "BANK_ID")
    private Bank bank;

    @OneToMany(mappedBy = "client", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @ToString.Exclude
    private List<OfferCredit> offerCreditList;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        Client client = (Client) o;

        return id != null && id.equals(client.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(firstName, middleName, lastName, phoneNumber, email, passportNumber);
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getMiddleName() {
        return middleName;
    }

    public void setMiddleName(String middleName) {
        this.middleName = middleName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }


    public String getEmail() {
        return email;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getPassportNumber() {
        return passportNumber;
    }

    public void setPassportNumber(String passportNumber) {
        this.passportNumber = passportNumber;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Bank getBank() {
        return bank;
    }

    public void setBank(Bank bank) {
        this.bank = bank;
    }

    public List<OfferCredit> getOfferCreditList() {
        return offerCreditList;
    }

    public void setOfferCreditList(List<OfferCredit> offerCreditList) {
        this.offerCreditList = offerCreditList;
    }
}
