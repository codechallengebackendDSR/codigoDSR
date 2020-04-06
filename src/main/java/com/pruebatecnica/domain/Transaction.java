package com.pruebatecnica.domain;

import java.io.Serializable;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.time.ZonedDateTime;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;


import lombok.AccessLevel;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;


@Data
@Entity
@Table(name="TB_TRANSACTION ")
public class Transaction implements Serializable {
	private static final long serialVersionUID = 7075931734841441869L;

	@Id
	@NonNull
	@Column(name = "REFERENCE ")
	String reference;

	@NonNull
	@Column(name = "ACCOUNT_IBAN")
	String iban;
	@Column(name = "DATE")
	Date date;

	@NonNull
	@Column(name = "AMOUNT")
	BigInteger amount;

	@Column(name = "FEE")
	BigInteger fee;
	@Column(name = "DESCRIPTION")
	String description;

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

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}
	
	
	
}
