package com.thekleinbottle.glovebox_backend.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
public class Asset {
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Long id;

    private String make, model;

    @ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="account")
    private Account account;

    public Asset() {}

    public Asset(String make, String model, Account account) {
        super();
        this.make = make;
        this.model = model;
        this.account = account;
    }

    public Long getId() {
        return id;
    }

    public String getMake() {
        return make;
    }

    public String getModel() {
        return model;
    }

    @JsonIgnore
    public Account getAccount() {
        return account;
    }

    public void setAccount(Account acct) {
        this.account = acct;
    }
}
