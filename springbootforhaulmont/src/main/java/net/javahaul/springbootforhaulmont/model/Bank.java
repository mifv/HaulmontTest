package net.javahaul.springbootforhaulmont.model;

import lombok.Data;

import javax.persistence.*;
import java.util.UUID;

@Data
@Entity
@Table(name = "banks")
public class Bank {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "bank_id")
    private UUID bank_id;

    @Column(name = "bank_name")
    private String Bank_name;
}
