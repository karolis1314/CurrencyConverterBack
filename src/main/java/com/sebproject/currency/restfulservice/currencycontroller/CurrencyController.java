package com.sebproject.currency.restfulservice.currencycontroller;

import com.sebproject.currency.restfulservice.dto.LastChance;
import com.sebproject.currency.restfulservice.repo.CurrencyRepo;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.sebproject.currency.restfulservice.model.CcyAmt;
import com.sebproject.currency.restfulservice.model.Root;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;


@RestController
public class CurrencyController {
	
	public LastChance lastChance;

	HashMap<String, String> currencies = new HashMap<String, String>();

	@Autowired
	CurrencyRepo currencyRepo;

	
	@Autowired
	RestTemplate restTemplate  = new RestTemplate();
	
	@GetMapping(path = "/all/{tp}")
	public Root[] getAll(@PathVariable String tp) {
		
    String url = "http://www.lb.lt/webservices/FxRates/FxRates.asmx/getCurrentFxRates?tp="+tp;
    Root[] currency = restTemplate.getForObject(url, Root[].class);
    return currency;
     }
	
	
	
	
	
	@GetMapping(path = "/all/{tp}/{dt}/1")
	public String get(@PathVariable String tp, @PathVariable String dt) {
		
    String url = "http://www.lb.lt//webservices/FxRates/FxRates.asmx/getFxRates?tp="+tp+"+&dt="+dt;
    
    Root currency = restTemplate.getForObject(url, Root.class);
   
    return currency.getCcyAmt().getAmt().toString();
}
	
	
	@GetMapping(path = "/all/{tp}/{dt}/2")
	public String getlet(@PathVariable String tp, @PathVariable String dt) {
	    String url = "http://www.lb.lt//webservices/FxRates/FxRates.asmx/getFxRates?tp="+tp+"+&dt="+dt;
		ResponseEntity<Root[]> responseEntity = 
			    restTemplate.getForEntity(url, Root[].class); 
			  Root[] userArray = responseEntity.getBody();
			  String yes = "";
			 for(Root user : userArray) {
				currencies.put(user.getCcyAmt().getCcy(), user.getCcyAmt().getAmt());
				lastChance = new LastChance(user.getCcyAmt().getCcy(), user.getCcyAmt().getAmt());
				currencyRepo.save(lastChance);
			 }
    return yes;
	
	}

	@GetMapping(path = "/shot")
	public String getterino(){
		return printMap(currencies);
	}

	public static String printMap(Map mp) {
		Iterator it = mp.entrySet().iterator();
		String yes = "";
		while (it.hasNext()) {
			Map.Entry pair = (Map.Entry)it.next();
			yes += (pair.getKey() + " = " + pair.getValue())+"\n";
			it.remove(); // avoids a ConcurrentModificationException
		}
		return yes;
	}
	
}