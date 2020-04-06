package com.pruebatecnica.services;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.List;
import org.apache.commons.lang3.RandomStringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Service;
import com.pruebatecnica.consta.Constantes;
import com.pruebatecnica.domain.Transaction;
import com.pruebatecnica.enums.TransactionChannel;
import com.pruebatecnica.enums.TransactionStatus;
import com.pruebatecnica.factory.TransactionFactory;
import com.pruebatecnica.models.GeneralResult;
import com.pruebatecnica.models.SearchRequest;
import com.pruebatecnica.models.SearchResult;
import com.pruebatecnica.models.StatusResult;
import com.pruebatecnica.models.TransactionRequest;
import com.pruebatecnica.respository.TransactionRepository;
import org.apache.commons.lang3.RandomStringUtils;
import com.pruebatecnica.utils.MotorReglas;

@Service
public class TransactionServiceImpl implements  TransactionService{
	
	@Autowired
	TransactionRepository transactionRepository;
	
	public  GeneralResult createTransaction(final TransactionRequest transactionRequest) {
		GeneralResult generalResult=new GeneralResult();
		try {
			if (this.balanceTransactionIsZero(transactionRequest)){
				final Transaction transaction = TransactionFactory.Create(
						transactionRequest.getReference(),
						transactionRequest.getDescription(),
						transactionRequest.getAmount(),
						transactionRequest.getFee(),
						transactionRequest.getDate(),
						transactionRequest.getIban());
						Transaction transanctionTemp = this.transactionRepository.findByReference(transaction.getReference());					
						if (transanctionTemp==null) {
							transaction.setReference(RandomStringUtils.randomAlphanumeric(10));	
						}						
						Transaction temp = this.transactionRepository.save(transaction);
						if (temp!=null) {
							generalResult.setReference(transactionRequest.getReference());
							generalResult.setDescription(Constantes.OK_TRANS_CREATE);
							return(generalResult);
						}
						generalResult.setReference(transactionRequest.getReference());
						generalResult.setDescription(Constantes.ERROR_TRANS_REFER_EXIS_CREATE_ERROR);
						return(generalResult);			
			
			} else {
				generalResult.setReference(transactionRequest.getReference());
				generalResult.setDescription(Constantes.ERROR_TRANS_VALUE_ZERO_OR_LESS);
				return(generalResult);
			}
		} catch(Exception e) {
			generalResult.setReference(transactionRequest.getReference());
			generalResult.setDescription(e.getMessage());
			return(generalResult);
		}
	}
		
	public  boolean balanceTransactionIsZero(final TransactionRequest transactionRequest) {
		BigInteger totalAmount= new BigInteger("0");
		BigInteger totalFee= new BigInteger("0");		
		final Direction direction =  Direction.ASC;
		final Sort sort = Sort.by(direction, Constantes.DEFAULT_SORT_PROPERTY);	
	    List<Transaction> lista = this.transactionRepository.findByIban(transactionRequest.getIban(),sort);
	    for (Transaction transacion: lista) {
	    	totalAmount=totalAmount.add(transacion.getAmount());
	    	totalFee=totalFee.add(transacion.getFee());
	    }	    
	    totalAmount=totalAmount.add(transactionRequest.getAmount());
	    totalFee=totalFee.add(transactionRequest.getFee());	    
	    BigInteger balance = totalAmount.add(totalFee);	    
	    int resultado=balance.compareTo(BigInteger.ZERO);
		return resultado>0?true:false;
	}
	public SearchResult findTransactions(final String iban, Sort sort) {
		SearchResult searchResult=new SearchResult();	
			try {
		    searchResult.setDescription(Constantes.OK_TRANS_SEARCH);	
		    searchResult.setReference(Constantes.SEVERAL);
		    searchResult.lista=this.transactionRepository.findByIban(iban, sort);
			return searchResult;		
			} catch(Exception e) {
				searchResult.setDescription(e.getMessage());
				return searchResult;
			}
			
	}
	public Object TransactionsStatus(final String reference, TransactionChannel channel ) {
			try {
				if (reference.isEmpty() || reference==null) {
					GeneralResult generalResult=new GeneralResult();	
					generalResult.setReference(reference);
					generalResult.setDescription(Constantes.ERROR_STATUS_REFERENCE_EMPLY);
					return (Object)generalResult;	
				}
				Transaction transaction = this.transactionRepository.findByReference(reference);
				if (transaction==null) {
					StatusResult statusResult=new StatusResult();	
					statusResult.setReference(reference);
					statusResult.setStatus(TransactionStatus.INVALID);
					return (Object)statusResult;
				
				} else {
					MotorReglas reglas= new MotorReglas();
					return (Object)reglas.RespuestaConReglas(transaction, channel);
				}
					
			} catch(Exception e) {
				GeneralResult generalResult=new GeneralResult();	
				generalResult.setReference(reference);
				generalResult.setDescription(Constantes.ERROR_EXCEPTION+ e.getMessage());
				return (Object)generalResult;
			}
					
	}
	
}
