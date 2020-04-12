package com.demo.web;

import java.text.ParseException;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.demo.model.RateEntity;
import com.demo.service.ExchangeService;

@RestController
public class ExchangeController {
	
	@Autowired
	private ExchangeService exchangeService;
	
	@GetMapping("/get-exchange-rate")
	public boolean getExchangeRate() throws ParseException 
	{
		boolean list = exchangeService.getExchangeRate();
		
		return list;
	    	
	}
	
	@CrossOrigin(origins = "http://localhost:4200")
	@GetMapping("/get-historical-data")
	public  ResponseEntity<List<RateEntity>> getHistoricalData() {
		
        List<RateEntity> list = exchangeService.getAllRates();
	 
        return new ResponseEntity<List<RateEntity>>(list, new HttpHeaders(), HttpStatus.OK);
	    
	}
}
