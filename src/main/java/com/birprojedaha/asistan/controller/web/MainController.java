package com.birprojedaha.asistan.controller.web;

import com.birprojedaha.asistan.partner.btcturk.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class MainController {
    @Autowired
    BtcTurkApi btcTurkApi;

    @GetMapping("/")
    public String homepage(ModelAndView model) {
        TickerResponse tickerResponse = btcTurkApi.connect().watchTickers("BTCUSDT");
        model.addObject("tickers", tickerResponse.getTickers());

        return "index";
    }

    @GetMapping("/plans")
    public String plans(ModelAndView model) {


        return "plans";
    }
    @GetMapping("/tickers")
    public String tickers(ModelMap model) {
        TickerResponse tickerResponse = btcTurkApi.connect().watchTickers(null);
        model.addAttribute("tickers", tickerResponse.getTickers());
        return "tickers";
    }

    @GetMapping("/open-orders")
    public String openOrders(ModelMap model) {
        OpenOrdersResponse openOrdersResponse = btcTurkApi.connect().listOpenOrders("BTC_USDT");
        model.addAttribute("asks", openOrdersResponse.getAsks());
        model.addAttribute("bids", openOrdersResponse.getBids());
        return "openOrders";
    }

    @GetMapping("/all-orders")
    public String allOrders(ModelMap model) {
        OrderFilterRequest orderFilterRequest = new OrderFilterRequest("BTC_USDT");
        AllOrdersResponse allOrdersResponse = btcTurkApi.connect().listAllOrders(orderFilterRequest);
        model.addAttribute("orders", allOrdersResponse.getOrders());
        return "allOrders";
    }



}
