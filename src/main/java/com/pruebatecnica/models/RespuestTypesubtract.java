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
public class RespuestTypesubtract {

		TransactionStatus status;
		BigInteger subtract;
		public TransactionStatus getStatus() {
			return status;
		}
		public void setStatus(TransactionStatus status) {
			this.status = status;
		}
		public BigInteger getSubtract() {
			return subtract;
		}
		public void setSubtract(BigInteger subtract) {
			this.subtract = subtract;
		}
		


	
}
