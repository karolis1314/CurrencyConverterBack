package com.sebproject.currency.restfulservice.repo;

import com.sebproject.currency.restfulservice.dto.CurrencyPair;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CurrencyRepo extends JpaRepository<CurrencyPair, String>{
}
