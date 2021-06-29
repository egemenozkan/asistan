package com.birprojedaha.asistan.partner.btcturk;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class BtcTurkApiTest {

    @Autowired
    BtcTurkApi api;

    @Test
    public void watchTickersTest(){

        /**
         *
         * watchTicker
         * https://api.btcturk.com/api/v2/ticker
         */
        String pairSymbol = "BTC_TRY";
        TickerResponse tickerResponse = api.watchTickers(pairSymbol);
        System.out.println(tickerResponse);

        /** TODO: watchTickerCurrency
         * https://api.btcturk.com/api/v2/ticker/currency
         *
         * **/
        /**
         *
         * TODO: orderBook
         * https://api.btcturk.com/api/v2/orderbook
         * **/

        /**
         * TODO: trades
         * https://api.btcturk.com/api/v2/trades
         */
/**
 * TODO: ohcl data
 * https://graph-api.btcturk.com/v1/ohlcs
 *
 *
 */
        /**
         *
         * checkBalance
         * https://docs.btcturk.com/private-endpoints/account-balance
         *
         *  */
//        BalanceResponse balanceResponse = api.checkBalance();
//        System.out.println(balanceResponse);
        /**
         *
         * listTransactions
         * https://api.btcturk.com/api/v1/users/transactions/trade
         *
         */
//        TransactionRequest transactionRequest = new TransactionRequest();
//        transactionRequest.addSymbol("ltc").addType("sell").addType("buy");
//        TransactionResponse transactionResponse = api.listTransactions(transactionRequest);
//        System.out.println(transactionResponse);
        /**
         *
         * listOpenOrders
         * ->asks eklendi, ->bids eklenecek
         * https://api.btcturk.com/api/v1/openOrders
         */

//        OrderResponse orderResponse = api.listOpenOrders("BTC_USDT");
//        System.out.println(orderResponse);
        /**
         *  listAllOrders
         *  https://api.btcturk.com/api/v1/allOrders
         */
//        OrderResponse orderResponse = api.listAllOrders(new OrderFilterRequest("BTC_USDT"));
//        System.out.println(orderResponse);


        /***
         *  submitOrder
         * https://api.btcturk.com/api/v1/order
         */
/*
        OrderTradeRequest orderTradeRequest = new OrderTradeRequest();
        orderTradeRequest.setOrderType("sell");
        orderTradeRequest.setOrderMethod("limit");
        orderTradeRequest.setPairSymbol("BTCUSDT");
        orderTradeRequest.setQuantity(BigDecimal.valueOf(0.01841325));
        orderTradeRequest.setPrice(BigDecimal.valueOf(59876));
        //orderTradeRequest.setStopPrice(null);
        //orderTradeRequest.setNewOrderClientId(null);
        BaseResponse submitOrderResponse = api.submitOrder(orderTradeRequest);
        System.out.println(submitOrderResponse);
  */

        /**
         * cancelOrder
         * https://api.btcturk.com/api/v1/order
         * */


//        BaseResponse cancelOrderResponse = api.cancelOrder("3579551853");
//        System.out.println(cancelOrderResponse);

    }


}
