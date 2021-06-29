package com.birprojedaha.asistan;

import com.birprojedaha.asistan.data.jdbc.dao.investment.CryptoCurrency;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class AsistanApplicationTests {

    @Test
    void contextLoads() {
        CryptoCurrency cryptoCurrency = new CryptoCurrency();
        cryptoCurrency.setId(1);
        cryptoCurrency.setName("Bitcoin");
        cryptoCurrency.setAbbreviation("BTC");



    }

}
