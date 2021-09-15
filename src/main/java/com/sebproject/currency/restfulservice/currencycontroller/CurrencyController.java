package com.sebproject.currency.restfulservice.currencycontroller;

import com.sebproject.currency.restfulservice.dto.CurrencyPair;
import com.sebproject.currency.restfulservice.dto.CurrencyPeriod;
import com.sebproject.currency.restfulservice.repo.CurrencyRepo;
import com.sebproject.currency.restfulservice.repo.PeriodRepo;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import org.springframework.web.client.RestTemplate;

import com.sebproject.currency.restfulservice.model.Root;

@RestController
@RequestMapping("/currency")
public class CurrencyController {

    @Autowired
    CurrencyRepo currencyRepo;

    @Autowired
    PeriodRepo periodRepo;

    @Autowired
    RestTemplate restTemplate = new RestTemplate();

	//Getting all the current currency rates for euro.
    @GetMapping(path = "/current")
    public String getCurrent() {
        String url = "http://www.lb.lt/webservices/FxRates/FxRates.asmx/getCurrentFxRates?tp=LT";
        ResponseEntity<Root[]> responseEntity =
                restTemplate.getForEntity(url, Root[].class);
        Root[] userArray = responseEntity.getBody();
        CurrencyPair currencyPair;
        for (Root user : userArray) {
            currencyPair = new CurrencyPair(user.getCcyAmt().getCcy(), user.getCcyAmt().getAmt());
            currencyRepo.save(currencyPair);
        }
        return "Successfully populated H2 with current.";
    }

    //Getting currency rate in between dates.
    @GetMapping(path = "/range/{ccy}/{from}/{to}")
    public String getPeriod(@PathVariable String ccy,@PathVariable String from,@PathVariable String to) {
        String url = "http://www.lb.lt/webservices/FxRates/FxRates.asmx/getFxRatesForCurrency?tp=LT&ccy="+ccy+"&dtFrom="+from+"&dtTo="+to;
        periodRepo.deleteAll();
        ResponseEntity<Root[]> responseEntity =
                restTemplate.getForEntity(url, Root[].class);
        Root[] userArray = responseEntity.getBody();
        CurrencyPeriod currencyPeriod;
        for (Root user : userArray) {
            currencyPeriod = new CurrencyPeriod(user.getCcyAmt().getCcy(), user.getCcyAmt().getAmt());
            periodRepo.save(currencyPeriod);
        }
        return "Successfully populated H2 with ranges.";
    }
}