package com.thekleinbottle.glovebox_backend.domain;

import java.util.List;

import org.springframework.data.repository.CrudRepository;



public interface AccountRepository extends CrudRepository<Account,Long> {

    List<Account> findByCompanyName(String companyName);
}
