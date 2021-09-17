package com.sebproject.currency.restfulservice.jobs;
import com.sebproject.currency.restfulservice.dto.CurrencyPair;
import com.sebproject.currency.restfulservice.info.TimerInfo;
import com.sebproject.currency.restfulservice.model.Root;
import com.sebproject.currency.restfulservice.repo.CurrencyRepo;
import org.quartz.Job;
import org.quartz.JobDataMap;
import org.quartz.JobExecutionContext;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
public class RunFetchAllCurrencyTodayJob implements Job {
    private static final Logger LOG = LoggerFactory.getLogger(RunFetchAllCurrencyTodayJob.class);

    @Autowired
    CurrencyRepo currencyRepo;

    @Override
    public void execute(JobExecutionContext context) {
        JobDataMap jobDataMap = context.getJobDetail().getJobDataMap();
        TimerInfo info = (TimerInfo) jobDataMap.get(RunFetchAllCurrencyTodayJob.class.getSimpleName());
        LOG.info("Remaining fire count is '{}'", info.getRemainingFireCount());
        RestTemplate restTemplate = new RestTemplate();
        String url = "http://www.lb.lt/webservices/FxRates/FxRates.asmx/getCurrentFxRates?tp=LT";
        ResponseEntity<Root[]> responseEntity =
                restTemplate.getForEntity(url, Root[].class);
        Root[] userArray = responseEntity.getBody();
        CurrencyPair currencyPair;
        for (Root user : userArray) {
            currencyPair = new CurrencyPair(user.getCcyAmt().getCcy(), user.getCcyAmt().getAmt());
            currencyRepo.save(currencyPair);
        }
    }
}