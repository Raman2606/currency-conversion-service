package com.in28minutes.microsevices.currencyconversionservice.beans;

import java.math.BigDecimal;

import javax.persistence.Id;

public class CurrencyConversion {

	@Id
//	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
//	@Column(name = "\"from\"")
	private String from;
	private String to;
	private BigDecimal conversionMultiplpe;
	private String environment;
	private BigDecimal quantity;
	private BigDecimal calculatedAmount;
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getFrom() {
		return from;
	}
	public void setFrom(String from) {
		this.from = from;
	}
	public String getTo() {
		return to;
	}
	public void setTo(String to) {
		this.to = to;
	}
	public BigDecimal getConversionMultiplpe() {
		return conversionMultiplpe;
	}
	public void setConversionMultiplpe(BigDecimal conversionMultiplpe) {
		this.conversionMultiplpe = conversionMultiplpe;
	}
	public String getEnvironment() {
		return environment;
	}
	public void setEnvironment(String environment) {
		this.environment = environment;
	}
	public BigDecimal getQuantity() {
		return quantity;
	}
	public void setQuantity(BigDecimal quantity) {
		this.quantity = quantity;
	}

	public BigDecimal getCalculatedAmount() {
		return calculatedAmount;
	}
	public void setCalculatedAmount(BigDecimal calculatedAmount) {
		this.calculatedAmount = calculatedAmount;
	}
	
	public CurrencyConversion(Long id, String from, String to, BigDecimal conversionMultiplpe, String environment,
			BigDecimal quantity, BigDecimal calculatedAmount) {
		super();
		this.id = id;
		this.from = from;
		this.to = to;
		this.conversionMultiplpe = conversionMultiplpe;
		this.environment = environment;
		this.quantity = quantity;
		this.calculatedAmount = calculatedAmount;
	}
	@Override
	public String toString() {
		return "CurrencyConversion [id=" + id + ", from=" + from + ", to=" + to + ", conversionMultiplpe="
				+ conversionMultiplpe + ", environment=" + environment + ", quantity=" + quantity + "]";
	}
	
	public CurrencyConversion() {
		// TODO Auto-generated constructor stub
	}
}
