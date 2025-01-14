package com.thekleinbottle.glovebox_backend.web;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.GetMapping;

import com.thekleinbottle.glovebox_backend.domain.Asset;
import com.thekleinbottle.glovebox_backend.domain.AssetRepository;

@RestController
public class AssetController {
    private final AssetRepository repository;

    public AssetController(AssetRepository repository) {
        this.repository = repository;
    }

    @GetMapping("/assets")
    public Iterable<Asset> getAssets() {
        return repository.findAll();
    }

}
