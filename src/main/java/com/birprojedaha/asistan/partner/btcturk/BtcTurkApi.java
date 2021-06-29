package com.birprojedaha.asistan.partner.btcturk;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.MapperFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.commons.codec.binary.Base64;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.*;
import org.springframework.http.client.HttpComponentsClientHttpRequestFactory;
import org.springframework.stereotype.Component;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;
import java.time.Instant;
import java.util.*;

/**
 * https://docs.btcturk.com/
 */
@Component
public class BtcTurkApi {

    @Value("${btcturk.api-key}")
    private String API_KEY;
    @Value("${btcturk.api-secret}")
    private String API_SECRET;
    private String xSignature;
    private String nonce;
    private static final String API_URL = "https://api.btcturk.com/api";
    private static final String TICKER_PATH = "/v2/ticker";
    private static final String TICKER_CURRENCY_PATH = "/v2/ticker";
    private static final String BALANCE_PATH = "/v1/users/balances";
    private static final String USER_TRANSACTIONS_PATH = "/v1/users/transactions/trade";
    private static final String OPEN_ORDERS_PATH = "/v1/openOrders";
    private static final String ALL_ORDERS_PATH = "/v1/allOrders";
    private static final String SUBMIT_ORDER_PATH = "/v1/order";
    private static final String CANCEL_ORDER_PATH = "/v1/order";

    RestTemplate restTemplate;
    ObjectMapper objectMapper;

    public BtcTurkApi connect() {
        this.nonce = String.valueOf(Instant.now().toEpochMilli());
        String message = String.join("", API_KEY, nonce);
        try {
            Mac sha256_HMAC = Mac.getInstance("HmacSHA256");
            SecretKeySpec secret_key = new SecretKeySpec(Base64.decodeBase64(API_SECRET), "HmacSHA256");
            sha256_HMAC.init(secret_key);
            byte[] signatureBytes = sha256_HMAC.doFinal(message.getBytes());
            this.xSignature = Base64.encodeBase64String(signatureBytes);
        } catch (Exception e) {
            System.out.println("Error");
        }

        /* TODO: MakeBean */
        objectMapper = new ObjectMapper();
        objectMapper.configure(JsonParser.Feature.ALLOW_UNQUOTED_FIELD_NAMES, true);
        objectMapper.configure(MapperFeature.ACCEPT_CASE_INSENSITIVE_PROPERTIES, true);

        /** TODO: MakeBean */
        restTemplate = new RestTemplate(new HttpComponentsClientHttpRequestFactory());

        return this;
    }

    public TickerResponse watchTickers(String pairSymbol) {
        HttpEntity<Object> httpEntity = new HttpEntity<Object>(getHttpHeaders());
        TickerResponse tickerResponse = new TickerResponse();
        try {
            UriComponentsBuilder uriComponentsBuilder = UriComponentsBuilder.fromHttpUrl(getTickerPathUrl());
            if (pairSymbol != null) {
                uriComponentsBuilder.queryParam("pairSymbol", pairSymbol);
            }
            ResponseEntity<Map> result = restTemplate.exchange(uriComponentsBuilder.toUriString(), HttpMethod.GET, httpEntity, Map.class);
            if (result.getStatusCode() == HttpStatus.OK) {
                tickerResponse.setSuccess(Boolean.TRUE);
                String json = objectMapper.writeValueAsString(result.getBody().get("data"));
                List<Ticker> tickers = objectMapper.readValue(json, new TypeReference<List<Ticker>>() {
                });
                tickerResponse.setTickers(tickers);
            } else {
                tickerResponse.setMessage(result.getBody().getOrDefault("message", "").toString());
                tickerResponse.setCode(result.getBody().getOrDefault("code", "").toString());
            }
        } catch (Exception ex) {
            tickerResponse.setMessage(ex.getMessage());
            tickerResponse.setCode("500");
        }

        return tickerResponse;
    }


    public BalanceResponse checkBalance() {
        HttpEntity<Object> httpEntity = new HttpEntity<Object>(getHttpHeaders());
        BalanceResponse balanceResponse = new BalanceResponse();
        try {
            ResponseEntity<Map> result = restTemplate.exchange(getBalanceUrl(), HttpMethod.GET, httpEntity, Map.class);
            if (result.getStatusCode() == HttpStatus.OK) {
                balanceResponse.setSuccess(Boolean.TRUE);
                String json = objectMapper.writeValueAsString(result.getBody().get("data"));
                List<Asset> assets = objectMapper.readValue(json, new TypeReference<List<Asset>>() {
                });
                balanceResponse.setAssets(assets);
            } else {
                balanceResponse.setMessage(result.getBody().getOrDefault("message", "").toString());
                balanceResponse.setCode(result.getBody().getOrDefault("code", "").toString());
            }
        } catch (Exception ex) {
            balanceResponse.setMessage(ex.getMessage());
            balanceResponse.setCode("500");
        }

        return balanceResponse;
    }

    public TransactionResponse listTransactions(TransactionRequest transactionRequest) {
        Map<String, String> body = new HashMap<>();

        UriComponentsBuilder uriComponentsBuilder = UriComponentsBuilder.fromHttpUrl(getUserTransactionsUrl());
        for (String type : transactionRequest.getTypes()) {
            uriComponentsBuilder.queryParam("type", type);
        }
        for (String symbol : transactionRequest.getSymbols()) {
            uriComponentsBuilder.queryParam("symbol", symbol);
        }

        if (transactionRequest.getStartDate() != null) {
            uriComponentsBuilder.queryParam("startDate", transactionRequest.getStartDate());
        }
        if (transactionRequest.getEndDate() != null) {
            uriComponentsBuilder.queryParam("endDate", transactionRequest.getEndDate());
        }

        HttpEntity<Object> httpEntity = new HttpEntity<Object>(body, getHttpHeaders());
        TransactionResponse transactionResponse = new TransactionResponse();
        try {

            ResponseEntity<Map> result = restTemplate.exchange(uriComponentsBuilder.toUriString(), HttpMethod.GET, httpEntity, Map.class);
            Map resultBody = result.getBody();
            if (resultBody == null) {
                throw new Exception("Body is null");
            }
            if (result.getStatusCode() == HttpStatus.OK) {
                transactionResponse.setSuccess(Boolean.TRUE);
                String json = objectMapper.writeValueAsString(resultBody.get("data"));
                List<Transaction> transactions = objectMapper.readValue(json, new TypeReference<List<Transaction>>() {
                });
                transactionResponse.setTransactions(transactions);
            } else {
                transactionResponse.setMessage(resultBody.getOrDefault("message", "").toString());
                transactionResponse.setCode(resultBody.getOrDefault("code", "").toString());
            }
        } catch (Exception ex) {
            transactionResponse.setMessage(ex.getMessage());
            transactionResponse.setCode("500");
        }
        return transactionResponse;
    }

    public OpenOrdersResponse listOpenOrders(String pairSymbol) {
        UriComponentsBuilder uriComponentsBuilder = UriComponentsBuilder.fromHttpUrl(getOpenOrdersUrl())
                .queryParam("pairSymbol", pairSymbol);

        OpenOrdersResponse openOrdersResponse = new OpenOrdersResponse();
        HttpEntity<Object> httpEntity = new HttpEntity<Object>(getHttpHeaders());

        try {
            ResponseEntity<Map> result = restTemplate.exchange(uriComponentsBuilder.toUriString(), HttpMethod.GET, httpEntity, Map.class);
            Map resultBody = result.getBody();
            if (resultBody == null) {
                throw new Exception("Body is null");
            }
            if (result.getStatusCode() == HttpStatus.OK) {
                openOrdersResponse.setSuccess(Boolean.TRUE);
                String json = objectMapper.writeValueAsString(resultBody.get("data"));
                Map<String, Object> data = objectMapper.readValue(json, Map.class);
                System.out.println(json);
                List<Order> asks = objectMapper.readValue(objectMapper.writeValueAsString(data.get("asks")), new TypeReference<List<Order>>() {
                });
                List<Order> bids = objectMapper.readValue(objectMapper.writeValueAsString(data.get("bids")), new TypeReference<List<Order>>() {
                });

                openOrdersResponse.setAsks(asks);
                openOrdersResponse.setBids(bids);
            } else {
                openOrdersResponse.setMessage(resultBody.getOrDefault("message", "").toString());
                openOrdersResponse.setCode(resultBody.getOrDefault("code", "").toString());
            }
        } catch (Exception ex) {
            openOrdersResponse.setMessage(ex.getMessage());
            openOrdersResponse.setCode("500");
        }

        return openOrdersResponse;
    }


    public AllOrdersResponse listAllOrders(OrderFilterRequest orderFilterRequest) {
        UriComponentsBuilder uriComponentsBuilder = UriComponentsBuilder.fromHttpUrl(getAllOrdersUrl())
                .queryParam("pairSymbol", orderFilterRequest.getPairSymbol());
        if (orderFilterRequest.getOrderId() != null) {
            uriComponentsBuilder.queryParam("orderId", orderFilterRequest.getOrderId());
        }
//                .queryParam("startTime",null);
//                .queryParam("endTime", null);
//                .queryParam("page","1");
//                .queryParam("limit","100");


        AllOrdersResponse allOrdersResponse = new AllOrdersResponse();
        HttpEntity<Object> httpEntity = new HttpEntity<Object>(getHttpHeaders());

        try {
            ResponseEntity<Map> result = restTemplate.exchange(uriComponentsBuilder.toUriString(), HttpMethod.GET, httpEntity, Map.class);
            Map resultBody = result.getBody();
            if (resultBody == null) {
                throw new Exception("Body is null");
            }
            if (result.getStatusCode() == HttpStatus.OK) {
                allOrdersResponse.setSuccess(Boolean.TRUE);
                String json = objectMapper.writeValueAsString(resultBody.get("data"));
                List<Order> orders = objectMapper.readValue(json, new TypeReference<List<Order>>() {
                });
                allOrdersResponse.setOrders(orders);
            } else {
                allOrdersResponse.setMessage(resultBody.getOrDefault("message", "").toString());
                allOrdersResponse.setCode(resultBody.getOrDefault("code", "").toString());
            }
        } catch (Exception ex) {
            allOrdersResponse.setMessage(ex.getMessage());
            allOrdersResponse.setCode("500");
        }

        return allOrdersResponse;
    }

    public BaseResponse submitOrder(OrderTradeRequest orderTradeRequest) {
        Map<String, Object> body = new HashMap<>();
        body.put("quantity", orderTradeRequest.getQuantity());
        body.put("orderMethod", orderTradeRequest.getOrderMethod());
        body.put("orderType", orderTradeRequest.getOrderType());
        body.put("pairSymbol", orderTradeRequest.getPairSymbol());
        /** Optionals */
        if (orderTradeRequest.getPrice() != null) {
            body.put("price", orderTradeRequest.getPrice());
        }
        if (orderTradeRequest.getStopPrice() == null) {
            body.put("stopPrice", orderTradeRequest.getStopPrice());
        }
        if (orderTradeRequest.getNewOrderClientId() != null) {
            body.put("newOrderClientId", orderTradeRequest.getNewOrderClientId());

        }
        HttpEntity<Object> httpEntity = new HttpEntity<Object>(body, getHttpHeaders());
        BaseResponse submitOrderResponse = new BaseResponse();
        try {
            ResponseEntity<Map> result = restTemplate.exchange(getSubmitOrderPathUrl(), HttpMethod.POST, httpEntity, Map.class);
            Map<String, Object> resultBody = result.getBody();
            if (resultBody == null) {
                throw new Exception("Body is null");
            }
            if (result.getStatusCode() == HttpStatus.OK) {
                submitOrderResponse.setSuccess(Boolean.TRUE);
            }
            submitOrderResponse.setMessage(resultBody.getOrDefault("message", "").toString());
            submitOrderResponse.setCode(resultBody.getOrDefault("code", "").toString());
        } catch (Exception ex) {
            submitOrderResponse.setMessage(ex.getMessage());
            submitOrderResponse.setCode("500");
        }
        return submitOrderResponse;
    }


    public BaseResponse cancelOrder(String orderId) {
        UriComponentsBuilder uriComponentsBuilder = UriComponentsBuilder.fromHttpUrl(getCancelOrderPathUrl())
                .queryParam("id", orderId);
        HttpEntity<Object> httpEntity = new HttpEntity<Object>(getHttpHeaders());
        BaseResponse cancelResponse = new BaseResponse();
        try {
            ResponseEntity<Map> result = restTemplate.exchange(uriComponentsBuilder.toUriString(), HttpMethod.DELETE, httpEntity, Map.class);
            Map resultBody = result.getBody();
            if (resultBody == null) {
                throw new Exception("Body is null");
            }
            if (result.getStatusCode() == HttpStatus.OK) {
                cancelResponse.setSuccess(Boolean.TRUE);
            }
            cancelResponse.setMessage(resultBody.getOrDefault("message", "").toString());
            cancelResponse.setCode(resultBody.getOrDefault("code", "").toString());
        } catch (Exception ex) {
            cancelResponse.setMessage(ex.getMessage());
            cancelResponse.setCode("500");
        }
        return cancelResponse;
    }


    private String getBalanceUrl() {
        return new StringBuilder(API_URL).append(BALANCE_PATH).toString();
    }

    private String getUserTransactionsUrl() {
        return new StringBuilder(API_URL).append(USER_TRANSACTIONS_PATH).toString();
    }

    private String getOpenOrdersUrl() {
        return new StringBuilder(API_URL).append(OPEN_ORDERS_PATH).toString();
    }

    private String getAllOrdersUrl() {
        return new StringBuilder(API_URL).append(ALL_ORDERS_PATH).toString();
    }

    private String getSubmitOrderPathUrl() {
        return new StringBuilder(API_URL).append(SUBMIT_ORDER_PATH).toString();
    }

    private String getCancelOrderPathUrl() {
        return new StringBuilder(API_URL).append(CANCEL_ORDER_PATH).toString();
    }

    private String getTickerPathUrl() {
        return new StringBuilder(API_URL).append(TICKER_PATH).toString();
    }

    private MultiValueMap<String, String> getHttpHeaders() {
        MultiValueMap<String, String> httpHeaders = new LinkedMultiValueMap<String, String>();
        httpHeaders.put("X-PCK", Collections.singletonList(API_KEY));
        httpHeaders.put("X-Stamp", Collections.singletonList(nonce));
        httpHeaders.put("X-Signature", Collections.singletonList(xSignature));
        httpHeaders.put("Content-Type", Collections.singletonList(MediaType.APPLICATION_JSON.toString()));
        return httpHeaders;
    }

}




