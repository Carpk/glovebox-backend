package com.thekleinbottle.glovebox_backend;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.thekleinbottle.glovebox_backend.domain.Account;
import com.thekleinbottle.glovebox_backend.domain.AccountRepository;
import com.thekleinbottle.glovebox_backend.domain.AppUser;
import com.thekleinbottle.glovebox_backend.domain.AppUserRepository;
import com.thekleinbottle.glovebox_backend.domain.Asset;
import com.thekleinbottle.glovebox_backend.domain.AssetRepository;

@SpringBootApplication
public class GloveboxBackendApplication implements CommandLineRunner {
	private final AccountRepository acctRepo;
	private final AppUserRepository userRepo;
	private final AssetRepository assetRepo;

	public GloveboxBackendApplication(
			AccountRepository acctRepo, AppUserRepository userRepo, AssetRepository assetRepo) {
		this.acctRepo = acctRepo;
		this.userRepo = userRepo;
		this.assetRepo = assetRepo;
	}
 

	public static void main(String[] args) {
		SpringApplication.run(GloveboxBackendApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		Account acct = new Account();
		acctRepo.save(acct);

		userRepo.save(new AppUser("Martin", "martin@mailg.com", acct));
		userRepo.save(new AppUser("Philip", "phil@mailg.com", acct));
		
		assetRepo.save(new Asset("ford", "bronco", acct));
		assetRepo.save(new Asset("bmw", "e28", acct));
	}
}
