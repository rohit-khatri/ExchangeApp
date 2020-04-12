package com.demo.model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@Entity
@Table(name="exchange")
@JsonIgnoreProperties(ignoreUnknown = true)
public class ExchangeEntity {

    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Long id;
    
   
    private String base;
    
    @JsonProperty("rates")
    private String rates;
    
    
    private Date date;
    
    public Long getId() {
		return id;
	}

	public String getBase() {
		return base;
	}

	public void setBase(String Base) {
		this.base = Base;
	}

	public String getRates() {
		return rates;
	}

	public void setRate(String rates) {
		this.rates = rates;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	@Override
	public String toString() {
		return "ExchanceEntity [id=" + id + ", base=" + base + ", date=" + date + "]";
	}    
}