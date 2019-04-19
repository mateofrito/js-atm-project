package io.mattfry.atmprojectjs.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import io.mattfry.atmprojectjs.models.Transaction;

@Repository
public interface TransactionRepository extends CrudRepository<Transaction, Long> {
	
	Transaction findTransactionByTransactionSource(String transactionSource); 

}
