package com.pruebatecnica.models;


import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.pruebatecnica.domain.Transaction;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.FieldDefaults;

@Getter
@Setter
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class SearchResult extends GeneralResult{
	public String isban;
	public List<Transaction> lista;

	
	
}
