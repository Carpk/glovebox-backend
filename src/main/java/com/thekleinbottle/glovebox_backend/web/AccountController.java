package com.thekleinbottle.glovebox_backend.web;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.thekleinbottle.glovebox_backend.domain.Account;
import com.thekleinbottle.glovebox_backend.domain.AccountRepository;
import com.thekleinbottle.glovebox_backend.domain.Asset;

@RestController
public class AccountController {
    private AccountRepository repository;

    public AccountController(AccountRepository repository) {
        this.repository = repository;
    }

    @GetMapping("/accounts")
    public Iterable<Account> getAcount() {
        return repository.findAll();
    }
}
