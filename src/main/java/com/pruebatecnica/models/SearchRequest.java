package com.pruebatecnica.models;

import org.springframework.data.domain.Sort.Direction;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.FieldDefaults;

@Getter
@Setter
@NoArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class SearchRequest {
	@JsonProperty("iban")
	String isban;
	@JsonProperty("sort")
	Direction sort;
	

	public String getIsban() {
		return isban;
	}
	public void setIsban(String isban) {
		this.isban = isban;
	}
	public Direction getSort() {
		return sort;
	}
	public void setSort(Direction sort) {
		this.sort = sort;
	}
	
}
