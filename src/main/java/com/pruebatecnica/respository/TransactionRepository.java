package com.pruebatecnica.respository;

import java.util.List;

import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.data.jpa.repository.JpaRepository;

import com.pruebatecnica.domain.Transaction;



public interface TransactionRepository extends JpaRepository<Transaction, String> {

	List<Transaction>  findByIban(String iban, Sort sort);
	Transaction findByReference(String reference);
}
