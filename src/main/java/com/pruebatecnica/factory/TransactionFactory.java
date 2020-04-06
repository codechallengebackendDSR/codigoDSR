package com.pruebatecnica.factory;

import java.math.BigInteger;
import java.util.Date;

import com.pruebatecnica.domain.Transaction;

public class TransactionFactory {

public static Transaction Create(
		String reference,
		String description,
		BigInteger amount,
		BigInteger fee,
		Date date,String accountIban
		) {
	try {
		Transaction transaction = new Transaction();
		transaction.setAmount(amount);
		transaction.setFee(fee);
		transaction.setDate(date);
		transaction.setDescription(description);
		transaction.setReference(reference);
		transaction.setIban(accountIban);
		return transaction;
	} catch (Exception e) {
		return null;
	}
}	
}
