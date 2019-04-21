package io.mattfry.atmprojectjs.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import io.mattfry.atmprojectjs.models.Account;

@Repository
public interface AccountRepository extends CrudRepository<Account, Long> {
	
	Account findAccountByAccountType(String accountType);
	
	Account findAccountByAccountNumber(int accountNumber);
	

}
