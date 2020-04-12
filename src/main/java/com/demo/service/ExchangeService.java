package com.demo.service;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.demo.model.RateEntity;
import com.demo.repository.RateRepository;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
 
@Service
public class ExchangeService {
    
	@Autowired
    private RateRepository repository;
     
    public List<RateEntity> getAllRates()
    {
        List<RateEntity> rateList = repository.findAll();
         
        if(rateList.size() > 0) {
            return rateList;
        } else {
            return new ArrayList<RateEntity>();
        }
    }
    
    public List<RateEntity> getExchangeRate( ) throws ParseException {
    	final String uri = "https://api.ratesapi.io/api/latest";
	    
    	List <RateEntity> list = new ArrayList<RateEntity>();
	    RestTemplate restTemplate = new RestTemplate();
	    String jsonString = restTemplate.getForObject(uri, String.class);
	    
	    ObjectMapper mapper = new ObjectMapper();
	    try {
			JsonNode jnode = mapper.readTree(jsonString);
			JsonNode jnodeRates = mapper.readTree(jnode.get("rates").toString());
			
			SimpleDateFormat df = new SimpleDateFormat("yyyy-mm-dd");
			Date date = df.parse(jnode.get("date").asText());
		    
			Iterator<String> fieldNames = jnodeRates.fieldNames();

	        while(fieldNames.hasNext()) {
	            String fieldName = fieldNames.next();
	            float fieldValue = jnodeRates.get(fieldName).floatValue();
	            RateEntity re = new RateEntity();
	            re.setCurrency(fieldName);
	            re.setPrice(fieldValue);
	            re.setDate(date);
	            //repository.save(re);
	            list.add(re);
	        }
		} catch (IOException e1) {
			e1.printStackTrace();
		}
	    return list;
    }
}