package com.pruebatecnica.models;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.time.ZonedDateTime;
import java.util.Date;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.FieldDefaults;

@Getter
@Setter
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PUBLIC)
public class TransactionRequest {
	@JsonProperty("reference")
	String reference;
	@JsonProperty("account_iban")
	String iban;
	@JsonProperty("date")
	Date date;
	@JsonProperty("amount")
	BigInteger amount;
	@JsonProperty("fee")
	BigInteger fee;
	@JsonProperty("description")
	String description;
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
	public String getReference() {
		return reference;
	}
	public void setReference(String reference) {
		this.reference = reference;
	}

	public String getIban() {
		return iban;
	}
	public void setIban(String iban) {
		this.iban = iban;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	
	
	
}
