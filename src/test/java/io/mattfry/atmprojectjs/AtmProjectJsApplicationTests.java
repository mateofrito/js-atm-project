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
import io.mattfry.atmprojectjs.repositories.AccountRepository;

@RunWith(SpringJUnit4ClassRunner.class)
@DataJpaTest
public class AtmProjectJsApplicationTests {
	
	@Resource
	private TestEntityManager entityManager;
	
	@Resource
	private AccountRepository accountRepo;
	
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
}
