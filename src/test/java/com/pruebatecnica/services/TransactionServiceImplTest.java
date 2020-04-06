package com.pruebatecnica.services;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

import java.math.BigInteger;
import java.util.Date;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.stereotype.Component;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

import com.pruebatecnica.PruebatecnicaApplication;
import com.pruebatecnica.consta.Constantes;
import com.pruebatecnica.models.GeneralResult;
import com.pruebatecnica.models.TransactionRequest;

@RunWith(SpringRunner.class)
@ContextConfiguration
@Component
@SpringBootTest(classes = PruebatecnicaApplication.class)  
public class TransactionServiceImplTest {
	@Autowired
	TransactionServiceImpl transactionServiceImpl;
	@Test
	public void balanceTransactionIsZero_OK() {	
		TransactionRequest transactionRequest=new TransactionRequest();
		transactionRequest.setIban("ES0000000000000000000000");
		transactionRequest.setFee(new BigInteger("0"));
		transactionRequest.setAmount(new BigInteger("0"));
		transactionRequest.setDate(new Date());
		boolean result=transactionServiceImpl.balanceTransactionIsZero(transactionRequest);		
		assertNotEquals(result,false);
	}
	@Test
	public void balanceTransactionIsZero_ERROR() {	
		TransactionRequest transactionRequest=new TransactionRequest();
		transactionRequest.setIban("ES0000000000000000000000");
		transactionRequest.setFee(new BigInteger("0"));
		transactionRequest.setAmount(new BigInteger("0"));
		transactionRequest.setDate(new Date());
		boolean result=transactionServiceImpl.balanceTransactionIsZero(transactionRequest);
		assertEquals(result,true);
	}
	@Test
	public void createTransaction_OK() {	
		TransactionRequest transactionRequest=new TransactionRequest();
		transactionRequest.setIban("ES0000000000000000000000");
		transactionRequest.setFee(new BigInteger("0"));
		transactionRequest.setAmount(new BigInteger("0"));
		transactionRequest.setDate(new Date());
		GeneralResult result = transactionServiceImpl.createTransaction(transactionRequest);		
		assertEquals(result.getDescription(),Constantes.OK_TRANS_CREATE);
	}
	@Test
	public void createTransaction_ERROR() {	
		TransactionRequest transactionRequest=new TransactionRequest();
		transactionRequest.setIban("");
		transactionRequest.setFee(new BigInteger("0"));
		transactionRequest.setAmount(new BigInteger("0"));
		transactionRequest.setDate(new Date());
		GeneralResult result = transactionServiceImpl.createTransaction(transactionRequest);		
		assertNotEquals(result.getDescription(),Constantes.OK_TRANS_CREATE);
	}
}
