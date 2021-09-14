package com.sebproject.currency.restfulservice.repo;

import com.sebproject.currency.restfulservice.dto.LastChance;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CurrencyRepo extends JpaRepository<LastChance, String>{
}
