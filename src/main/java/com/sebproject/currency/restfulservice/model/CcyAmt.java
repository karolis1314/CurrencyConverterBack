package com.sebproject.currency.restfulservice.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import com.fasterxml.jackson.annotation.JsonProperty;

public class CcyAmt {

	private String ccy;
	
	private String amt;
	
	
	@JsonProperty("Ccy")
	public String getCcy() {
		return this.ccy;
	}

	public void setCcy(String ccy) {
		this.ccy = ccy;
	}



	@JsonProperty("Amt")
	public String getAmt() {
		return this.amt;
	}

	public void setAmt(String amt) {
		this.amt = amt;
	}



	@Override
	public String toString() {
		return "CcyAmt [ccy=" + ccy + ", amt=" + amt + "]";
	}

}
