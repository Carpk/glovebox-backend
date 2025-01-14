package com.thekleinbottle.glovebox_backend.domain;

import java.util.List;
// import java.util.UUID;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.CascadeType;

@Entity
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
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

    @JsonIgnore
    public List<AppUser> getAppUsers() {
        return appusers;
    }

    @JsonIgnore
    public List<Asset> getAssets() {
        return assets;
    }
}
