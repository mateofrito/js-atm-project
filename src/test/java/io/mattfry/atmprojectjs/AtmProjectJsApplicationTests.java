package io.mattfry.atmprojectjs;

import static org.junit.Assert.assertEquals;
import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

import java.util.Optional;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.junit4.SpringRunner;

import io.mattfry.atmprojectjs.models.Account;
import io.mattfry.atmprojectjs.models.Transaction;
import io.mattfry.atmprojectjs.repositories.AccountRepository;
import io.mattfry.atmprojectjs.repositories.TransactionRepository;

@RunWith(SpringJUnit4ClassRunner.class)
@DataJpaTest
public class AtmProjectJsApplicationTests {
	
	@Resource
	private TestEntityManager entityManager;
	
	@Resource
	private AccountRepository accountRepo;
	
	@Resource
	private TransactionRepository transactionRepo;
	
	@Test
	public void shouldAddNewAccount() {
		Account newAccount = accountRepo.save(new Account("Savings", 1000, 250.00));
		Long accountId = newAccount.getId();
		
		
		
		entityManager.persist(newAccount);
        entityManager.flush();
        entityManager.clear();
 
        Optional<Account> accountToFind = accountRepo.findById(accountId);
        newAccount = accountToFind.get();
        
        assertThat(newAccount.getAccountType(), is("Savings"));
		
	}
	
	@Test
	public void shouldAddTransactionof100() {
		Account newAccount = accountRepo.save(new Account("Savings", 1000, 250.00));
	    Transaction newTransaction = transactionRepo.save(new Transaction("Deposit", 01, 100.00));
	    Long transactionId = newTransaction.getId();
	    
	    entityManager.persist(newTransaction);
        entityManager.flush();
        entityManager.clear();
 
        Optional<Transaction> transactionToFind = transactionRepo.findById(transactionId);
        newTransaction = transactionToFind.get();
        
        assertThat(newTransaction.getTransactionSource(), is("Deposit"));
	}
	
	@Test
	public void add200toSavings() {
		double testDeposit = 200.00;
		
		
		Account newAccount = accountRepo.save(new Account("Savings", 1000, 250.00));
	    Transaction newTransaction = transactionRepo.save(new Transaction("Deposit", 01, testDeposit));
	    Long accountId = newAccount.getId();
	    int accountNumber = newAccount.getAccountNumber();
	    newAccount.makeDeposit(testDeposit);
	    
	    
	    
	    entityManager.persist(newAccount);
        entityManager.flush();
        entityManager.clear();
 
        Optional<Account> accountToFind = accountRepo.findById(accountId);
        newAccount = accountToFind.get();
      
        assertThat(newAccount.getBalance(), is(450.00));
		
		
		
	}
	
	@Test
	public void add200toChecking() {
		Account account = new Account();
		
		//this stuff will probably go in the account or transaction controller
		double testDeposit = 200.00;
		
		Account newChecking = accountRepo.save(new Account("Checking", 2000, 200.00));
		Account newAccount = accountRepo.save(new Account("Savings", 1000, 250.00));
	    Transaction newTransaction = transactionRepo.save(new Transaction("Deposit", 01, testDeposit));
	    int testActChoice = 2000;
	    Account depositActNumber = accountRepo.findAccountByAccountNumber(testActChoice);
	    Long accountId = depositActNumber.getId();
	    depositActNumber.makeDeposit(testDeposit);
	    
	   
	    
	    
	    
	    
	    entityManager.persist(newChecking);
        entityManager.flush();
        entityManager.clear();
 
        Optional<Account> accountToFind = accountRepo.findById(accountId);
        newAccount = accountToFind.get();
      
        assertThat(depositActNumber.getBalance(), is(400.00));
		
		
		
	}
	
	@Test
	public void add200toSavingsWithID() {
		Account account = new Account();
		
		//this stuff will probably go in the account or transaction controller
		double testDeposit = 200.00;
		
		Account newChecking = accountRepo.save(new Account("Checking", 2000, 200.00));
		Account newAccount = accountRepo.save(new Account("Savings", 1000, 250.00));
	    Transaction newTransaction = transactionRepo.save(new Transaction("Deposit", 01, testDeposit));
	    int testActChoice = 1000;
	    Account depositActNumber = accountRepo.findAccountByAccountNumber(testActChoice);
	    Long accountId = depositActNumber.getId();
	    depositActNumber.makeDeposit(testDeposit);
	    
	   
	    
	    
	    
	    
	    entityManager.persist(newAccount);
        entityManager.flush();
        entityManager.clear();
 
        Optional<Account> accountToFind = accountRepo.findById(accountId);
        newAccount = accountToFind.get();
      
        assertThat(depositActNumber.getBalance(), is(450.00));
		
		
		
	}
}
