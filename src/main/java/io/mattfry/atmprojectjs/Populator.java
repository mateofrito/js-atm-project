package io.mattfry.atmprojectjs;

import javax.annotation.Resource;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Service;

import io.mattfry.atmprojectjs.models.Account;
import io.mattfry.atmprojectjs.models.Transaction;
import io.mattfry.atmprojectjs.repositories.AccountRepository;
import io.mattfry.atmprojectjs.repositories.TransactionRepository;

@Service
public class Populator implements CommandLineRunner {
	
	@Resource
	private AccountRepository accountRepo;
	
	@Resource
	private TransactionRepository transactionRepo;

	@Override
	public void run(String... args) throws Exception {
		Account account1 = accountRepo.save(new Account("Checking", 100, 250.00));
		Account account2 = accountRepo.save(new Account("Savings", 200, 300.00));
		
		Transaction transaction1 = transactionRepo.save(new Transaction("Deposit", 01, 100.00));
	}

}
