package com.pruebatecnica.models;


import java.math.BigInteger;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.pruebatecnica.enums.TransactionStatus;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.FieldDefaults;

@Getter
@Setter
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class RespuestTypeAmountFee {


		TransactionStatus status;
		BigInteger amount;
		BigInteger fee;
		public TransactionStatus getStatus() {
			return status;
		}
		public void setStatus(TransactionStatus status) {
			this.status = status;
		}
		public BigInteger getAmount() {
			return amount;
		}
		public void setAmount(BigInteger amount) {
			this.amount = amount;
		}
		public BigInteger getFee() {
			return fee;
		}
		public void setFee(BigInteger fee) {
			this.fee = fee;
		}
		


	
}
