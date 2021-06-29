package com.birprojedaha.asistan.data.jdbc.repository;

import com.birprojedaha.asistan.data.jdbc.dao.investment.Currency;
import com.birprojedaha.asistan.data.jdbc.dao.investment.CurrencyPair;
import com.birprojedaha.asistan.data.jdbc.rowmapper.CurrencyPairRowMapper;
import org.springframework.data.jdbc.repository.query.Modifying;
import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface CurrencyRepository extends CrudRepository<Currency, Integer> {
    @Modifying
    @Query("UPDATE currency SET name = :name WHERE id =:id")
    boolean updateName(@Param("id") int id, @Param("name") String name);

    @Modifying
    @Query("INSERT INTO currency_pair (id, base_id) VALUES (:id,:baseId)")
    boolean addPair(@Param("id") int id, @Param("baseId") int baseId);

    @Query(rowMapperClass = CurrencyPairRowMapper.class, value = "SELECT c1.id AS 'currency.id' , c1.name AS 'currency.name', c1.abbreviation AS 'currency.abbreviation', c1.type  AS 'currency.type',"
            + " c2.id  AS 'baseCurrency.id', c2.name  AS 'baseCurrency.name', c2.abbreviation  AS 'baseCurrency.abbreviation', c2.type  AS 'baseCurrency.type'"
            + " FROM asistan.currency_pair cp"
            + " LEFT JOIN asistan.currency c1 ON c1.id = cp.id"
            + " LEFT JOIN asistan.currency c2 ON c2.id = cp.base_id")
    List<CurrencyPair> findAllPairs();
}
