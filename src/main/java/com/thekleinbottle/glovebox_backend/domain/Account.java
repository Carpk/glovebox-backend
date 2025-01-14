package com.thekleinbottle.glovebox_backend.domain;

import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.CascadeType;

@Entity
public class Account {
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Long id;

    String companyName;

    @OneToMany(cascade=CascadeType.ALL, mappedBy="account")
    private List<AppUser> appusers;

    @OneToMany(cascade=CascadeType.ALL, mappedBy="account")
    private List<Asset> assets;

    public Account() {}

    public Account(String companyName) {
        super();
        this.companyName = companyName;
    }

    public Long getId() {
        return id;
    }

    public String getCompanyName() {
        return companyName;
    }

    public List<AppUser> getAppUsers() {
        return appusers;
    }

    public List<Asset> getAssets() {
        return assets;
    }
}
