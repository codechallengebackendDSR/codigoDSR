package com.pruebatecnica.models;


import com.fasterxml.jackson.annotation.JsonProperty;
import com.pruebatecnica.enums.TransactionChannel;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.FieldDefaults;

@Getter
@Setter
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class StatusRequest {
	@JsonProperty("reference")
	String reference;
	@JsonProperty("channel")
	TransactionChannel channel;
	public String getReference() {
		return reference;
	}
	public void setReference(String reference) {
		this.reference = reference;
	}
	public TransactionChannel getChannel() {
		return channel;
	}
	public void setChannel(TransactionChannel channel) {
		this.channel = channel;
	}
	
}
