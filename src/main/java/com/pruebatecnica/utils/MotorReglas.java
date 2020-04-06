package com.pruebatecnica.utils;

import java.math.BigInteger;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.pruebatecnica.consta.Constantes;
import com.pruebatecnica.domain.Transaction;
import com.pruebatecnica.enums.TransactionChannel;
import com.pruebatecnica.enums.TransactionStatus;
import com.pruebatecnica.models.GeneralResult;
import com.pruebatecnica.models.RespuestTypeAmountFee;
import com.pruebatecnica.models.RespuestTypesubtract;

public final class MotorReglas extends GeneralResult{
	public enum Time {
		TODAY, PAST, FUTURE;
	}

	class Regla {
		Time time;
		TransactionChannel channel;
		TransactionStatus status;
		int tiporespuesta;
	}
	
	List <Regla> reglas;
	
	public MotorReglas(){
		reglas=new ArrayList<Regla>();
		Regla e=new Regla();
		// Cliente en pasado
		e.channel=TransactionChannel.CLIENT;
		e.status=TransactionStatus.SETTLED;
		e.time=Time.PAST;
		e.tiporespuesta=1;
		reglas.add(e);
		// cliente en futuro
		Regla e1=new Regla();
		e1.channel=TransactionChannel.CLIENT;
		e1.status=TransactionStatus.FUTURE;
		e1.time=Time.FUTURE;
		e1.tiporespuesta=1;
		reglas.add(e1);
		// internal en pasado
		Regla e3=new Regla();
		e3.channel=TransactionChannel.INTERNAL;
		e3.status=TransactionStatus.SETTLED;
		e3.time=Time.PAST;
		e3.tiporespuesta=2;
		reglas.add(e3);
		// internal en hoy
		Regla e4=new Regla();
		e4.channel=TransactionChannel.INTERNAL;
		e4.status=TransactionStatus.PENDING;
		e4.time=Time.TODAY;
		e4.tiporespuesta=2;
		reglas.add(e4);
		// internal en futuo
		Regla e5=new Regla();
		e5.channel=TransactionChannel.INTERNAL;
		e5.status=TransactionStatus.FUTURE;
		e5.time=Time.FUTURE;
		e5.tiporespuesta=2;
		reglas.add(e5);
		// ATM en hoy
		Regla e6=new Regla();
		e6.channel=TransactionChannel.ATM;
		e6.status=TransactionStatus.PENDING;
		e6.time=Time.TODAY;
		e6.tiporespuesta=1;
		reglas.add(e6);
		// ATM en futuro
		Regla e7=new Regla();
		e7.channel=TransactionChannel.ATM;
		e7.status=TransactionStatus.PENDING;
		e7.time=Time.FUTURE;
		e7.tiporespuesta=1;
		reglas.add(e7);
	}
	public Regla reglaOK=null;
	Time actu=Time.TODAY;
	
	@SuppressWarnings("deprecation")
	public final Object RespuestaConReglas(Transaction transaction,TransactionChannel channel) {
	Date today = new Date();    
	String fechaHoy=new SimpleDateFormat("dd-MM-yyyy").format(today);
	String fechaTransancion=new SimpleDateFormat("dd-MM-yyyy").format(transaction.getDate());
	if (fechaHoy.compareTo(fechaTransancion)==0) {
		actu=Time.TODAY;
	} else {
	int d = transaction.getDate().compareTo(today);
	if (d==1) {
		actu=Time.FUTURE;
		} 
	if (d==-1) {
		actu=Time.PAST;
		}
	}	
	reglas.forEach(regla -> {
		if ((regla.channel==channel)&&(actu==regla.time)){
			this.reglaOK=new Regla();	
			this.reglaOK=regla;		
		};
	});
	if(this.reglaOK==null) {
		GeneralResult generalResult=new GeneralResult();	
		generalResult.setReference(transaction.getReference());
		generalResult.setDescription(Constantes.RULE_NOT_EXIT);
		return (Object)generalResult;
	}
	
	
	if (this.reglaOK.tiporespuesta==1) {
	    RespuestTypesubtract result=new RespuestTypesubtract();
	    result.setSubtract(transaction.getAmount().add(transaction.getFee()));
	    result.setStatus(this.reglaOK.status);
	    return (Object)	result;	
	} else {
	    RespuestTypeAmountFee result=new RespuestTypeAmountFee();
	    result.setAmount(transaction.getAmount());;
	    result.setFee(transaction.getFee());
	    result.setStatus(this.reglaOK.status);
	    return (Object)result;	
	}	
	}
}
