package com.birprojedaha.asistan.data.jdbc.repository;

import com.birprojedaha.asistan.data.jdbc.dao.investment.CurrencyPair;
import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.Optional;

public interface ExchangeRepository extends CrudRepository<CurrencyPair, Integer> {
    @Query("SELECT ep.id, ep.from_id, 'AA' as 'from', ep.to_id, 'BB' as 'to' FROM exchange_pair ep WHERE ep.id=:id")
    Optional<CurrencyPair> findById(@Param("id") int id);
}
