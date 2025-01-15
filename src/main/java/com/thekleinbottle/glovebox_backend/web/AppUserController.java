package com.thekleinbottle.glovebox_backend.web;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.GetMapping;

import com.thekleinbottle.glovebox_backend.domain.AccountRepository;
import com.thekleinbottle.glovebox_backend.domain.AppUser;
import com.thekleinbottle.glovebox_backend.domain.AppUserRepository;
import com.thekleinbottle.glovebox_backend.domain.Asset;

@RestController
public class AppUserController {
    private AppUserRepository repository;

    public AppUserController(AppUserRepository repository) {
        this.repository = repository;
    }

    @GetMapping("/appusers")
    public Iterable<AppUser> getAppUsers() {
        return repository.findAll();
    }

}
