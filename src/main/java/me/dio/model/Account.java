package me.dio.model;

import jakarta.persistence.*;

@Entity(name = "tb_account")
public class Account {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(unique = true)
    private String number;
    private String agency;
    @Column(precision = 13, scale = 2)
    private Number balance;

    @Column(precision = 13, scale = 2, name = "tb_limit")
    private Number limit;

    public Account(Integer id, String number, String agency, Number balance, Number limit) {
        this.number = number;
        this.agency = agency;
        this.balance = balance;
        this.limit = limit;
        this.id = id;
    }

    public Account() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String getAgency() {
        return agency;
    }

    public void setAgency(String agency) {
        this.agency = agency;
    }

    public Number getBalance() {
        return balance;
    }

    public void setBalance(Float balance) {
        this.balance = balance;
    }

    public Number getLimit() {
        return limit;
    }

    public void setLimit(Float limit) {
        this.limit = limit;
    }
}
