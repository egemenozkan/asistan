package com.birprojedaha.asistan.data.jdbc.dao.investment;

public class CurrencyPair {

   private Currency currency;
   private Currency baseCurrency;

   public Currency getCurrency() {
      return currency;
   }

   public void setCurrency(Currency currency) {
      this.currency = currency;
   }

   public Currency getBaseCurrency() {
      return baseCurrency;
   }

   public void setBaseCurrency(Currency baseCurrency) {
      this.baseCurrency = baseCurrency;
   }
}
