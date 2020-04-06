package com.pruebatecnica.models;


import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.pruebatecnica.domain.Transaction;
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
public class StatusResult {
	public String reference;
	public TransactionStatus status;
	public String getReference() {
		return reference;
	}
	public void setReference(String reference) {
		this.reference = reference;
	}
	public void setStatus(TransactionStatus invalid) {
		this.status = invalid;
	}
	public TransactionStatus getStatus() {
		return status;
	}	
}
