package com.sebproject.currency.restfulservice.model;


import com.fasterxml.jackson.annotation.JsonProperty;

public class Root {

	@JsonProperty("Tp")
	public String getTp() {
		return this.tp;
	}

	public void setTp(String tp) {
		this.tp = tp;
	}

	String tp;

	@JsonProperty("Dt")
	public String getDt() {
		return this.dt;
	}

	public void setDt(String dt) {
		this.dt = dt;
	}

	String dt;

	@JsonProperty("CcyAmt")
	public CcyAmt getCcyAmt() {
		return this.ccyAmt;
	}

	public void setCcyAmt(CcyAmt ccyAmt) {
		this.ccyAmt = ccyAmt;
	}

	CcyAmt ccyAmt;

	@Override
	public String toString() {
		return "Root [tp=" + tp + ", dt=" + dt + ", ccyAmt=" + ccyAmt + "]";
	}

}
