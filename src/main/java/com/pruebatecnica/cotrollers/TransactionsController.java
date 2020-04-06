package com.pruebatecnica.cotrollers;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import com.pruebatecnica.models.GeneralResult;
import com.pruebatecnica.models.SearchRequest;
import com.pruebatecnica.models.StatusRequest;
import com.pruebatecnica.models.TransactionRequest;

@RestController
public interface TransactionsController {

	
	public ResponseEntity<GeneralResult> createTransaction(@RequestBody TransactionRequest transactionRequest) ;	
	public ResponseEntity<GeneralResult> findTransactions(@RequestBody  SearchRequest searchRequest);
	public ResponseEntity<Object> findTransactionStatus(@RequestBody StatusRequest StatusRequest) ;
	

}
