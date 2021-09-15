package com.sebproject.currency.restfulservice.repo;

import com.sebproject.currency.restfulservice.dto.CurrencyPeriod;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PeriodRepo extends JpaRepository<CurrencyPeriod, Integer> {
}
