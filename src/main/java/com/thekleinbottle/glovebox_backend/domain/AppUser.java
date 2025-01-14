package com.thekleinbottle.glovebox_backend.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
public class AppUser {
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Long id;

    private String name, email;

    @ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="account")
    private Account account;

    public AppUser() {}

    public AppUser(String name, String email, Account account) {
        super();
        this.name = name;
        this.email = email;
        this.account = account;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public Account getAccount() {
        return account;
    }

    public void setAccount(Account acct) {
        this.account = acct;
    }
}
