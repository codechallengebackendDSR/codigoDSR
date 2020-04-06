package com.pruebatecnica.services;

import java.math.BigDecimal;
import java.util.List;

import org.springframework.stereotype.Service;
import com.pruebatecnica.domain.Transaction;
import com.pruebatecnica.models.GeneralResult;
import com.pruebatecnica.models.TransactionRequest;


@Service
public interface TransactionService {


	public  GeneralResult createTransaction(final TransactionRequest transactionRequest); 
	public  boolean balanceTransactionIsZero(final TransactionRequest transactionRequest);
//	public List<Transaction> findTransactions(final SearchRequest searchRequest) ;
//	public StatusResponse findTransactionStatus(final StatusRequest statusRequest) ;
	

	
}
