package com.birprojedaha.asistan.data.jdbc.dao;

import com.birprojedaha.asistan.data.common.CompanyType;
import org.springframework.data.relational.core.mapping.Table;

@Table("company")
public class ExchangeCompany extends Company {
    public ExchangeCompany() {
        super.setType(CompanyType.EXCHANGE.getId());
    }
}
