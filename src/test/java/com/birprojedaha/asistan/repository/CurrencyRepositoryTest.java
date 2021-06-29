package com.birprojedaha.asistan.repository;

import com.birprojedaha.asistan.data.jdbc.dao.investment.CryptoCurrency;
import com.birprojedaha.asistan.data.jdbc.dao.investment.Currency;
import com.birprojedaha.asistan.data.jdbc.dao.investment.CurrencyPair;
import com.birprojedaha.asistan.data.jdbc.dao.investment.FiatCurrency;
import com.birprojedaha.asistan.data.jdbc.repository.CurrencyRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;


//@DataJdbcTest
//@AutoConfigureTestDatabase(replace= AutoConfigureTestDatabase.Replace.NONE)
@SpringBootTest
public class CurrencyRepositoryTest {

    @Autowired
    CurrencyRepository cryptoCurrencyRepository;

//    @Test
    public void saveCurrencyWithAPI() {
        RestTemplate restTemplate = new RestTemplate();
        String url = "https://openexchangerates.org/api/currencies.json?app_id=6c1011fd7a4c4bdcbcf85e34b1041b4d";
        ResponseEntity<Map> response
                = restTemplate.getForEntity(url, Map.class);

        response.getBody().forEach((k,v) -> { saveCurrency(v.toString(),k.toString()); });
    }

    private void saveCurrency(String name, String abbreviation) {
        Currency cryptoCurrency = new FiatCurrency();
        cryptoCurrency.setName(name);
        cryptoCurrency.setAbbreviation(abbreviation);
       cryptoCurrencyRepository.save(cryptoCurrency);
    }
    @Test
    public void save() {
        Currency cryptoCurrency = new CryptoCurrency();
        cryptoCurrency.setId(12);
        cryptoCurrency.setName("Litecoin");
        cryptoCurrency.setAbbreviation("LTC");
        cryptoCurrency.addPair(Currency.of(1));
        CryptoCurrency cryptoCurrencyNew = (CryptoCurrency) cryptoCurrencyRepository.save(cryptoCurrency);
        assertEquals(cryptoCurrencyNew.getName(), "Litecoin");
    }

    @Test
    public void addCurrencyPair() {
        Currency cryptoCurrency = new CryptoCurrency();
        cryptoCurrency.setId(12);
        cryptoCurrency.addPair(Currency.of(11));
        for (int pairId : cryptoCurrency.getPairIds()) {
            boolean status = cryptoCurrencyRepository.addPair(cryptoCurrency.getId(), pairId);
            assertEquals(true, status);
        }
    }

    @Test
    public void listCurrencyPair() {
        List<CurrencyPair> pairs = cryptoCurrencyRepository.findAllPairs();
        assertEquals(pairs.size(), 2);

    }

    @Test
    public void findById() {
        Currency cryptoCurrency = new CryptoCurrency();
        cryptoCurrency.setName("Bitcoin");
        cryptoCurrency.setAbbreviation("BTC");

        Optional<Currency> cryptoCurrencyNew = cryptoCurrencyRepository.findById(1);
        assertEquals(cryptoCurrencyNew.get().getName(), "Bitcoin");
    }

    @Test
    public void update() {
        CryptoCurrency cryptoCurrency = new CryptoCurrency();
        cryptoCurrency.setId(1);
        cryptoCurrency.setName("Bitcoin2");
        cryptoCurrency.setAbbreviation("BTC");

        cryptoCurrencyRepository.updateName(cryptoCurrency.getId(), cryptoCurrency.getName());
        Optional<Currency> cryptoCurrencyNew = cryptoCurrencyRepository.findById(1);

        assertEquals(cryptoCurrencyNew.get().getName(), "Bitcoin2");
    }

}
