package com.pruebatecnica.cotrollers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.pruebatecnica.consta.Constantes;
import com.pruebatecnica.models.GeneralResult;
import com.pruebatecnica.models.SearchRequest;
import com.pruebatecnica.models.StatusRequest;
import com.pruebatecnica.models.TransactionRequest;
import com.pruebatecnica.services.TransactionServiceImpl;


@RestController
public  class TransactionsControllerImpl implements  TransactionsController{

	@Autowired
	TransactionServiceImpl transactionServiceImpl;
	@RequestMapping(value = "/create")
	@Override
	public  ResponseEntity<GeneralResult> createTransaction(@RequestBody TransactionRequest transactionRequest) {
		GeneralResult generalResult=new GeneralResult();
		try {
		return ResponseEntity.ok(transactionServiceImpl.createTransaction(transactionRequest));
		} catch(Exception e) {
			generalResult.setReference(transactionRequest.getReference());
			generalResult.setDescription(e.getMessage());
			return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
		}
	}
	@RequestMapping(value = "/find")
	public ResponseEntity<GeneralResult> findTransactions(@RequestBody SearchRequest searchRequest) {		
		GeneralResult generalResult=new GeneralResult();
		try {
			final Direction direction = searchRequest.getSort() == null ? Direction.ASC : searchRequest.getSort();
			final Sort sort = Sort.by(direction, Constantes.DEFAULT_SORT_PROPERTY);	
			return ResponseEntity.ok(transactionServiceImpl.findTransactions(searchRequest.getIsban(), sort));
		} catch(Exception e) {
			generalResult.setReference(e.getLocalizedMessage());
			generalResult.setDescription(e.getMessage());
			return  new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
		}
	}
	@RequestMapping(value = "/findTransactionStatus")
	public ResponseEntity<Object> findTransactionStatus(@RequestBody StatusRequest statusRequest) {
		try {
	return ResponseEntity.ok(transactionServiceImpl.TransactionsStatus(statusRequest.getReference(), statusRequest.getChannel()));
		} catch(Exception e) {
			GeneralResult generalResult=new GeneralResult();
			generalResult.setReference(e.getLocalizedMessage());
			generalResult.setDescription(e.getMessage());
			return  new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
		}
	
	}
	
}
