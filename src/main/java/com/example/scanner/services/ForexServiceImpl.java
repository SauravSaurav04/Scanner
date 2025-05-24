package com.example.scanner.services;

import com.example.scanner.clients.TwelveDataClient;
import com.fasterxml.jackson.databind.JsonNode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ForexServiceImpl implements ForexService {

    @Autowired
    TwelveDataClient twelveDataClient;

    @Override
    public String getExchangePrice(String symbol) {
        String from = symbol.split("/")[0];
        String to = symbol.split("/")[1];
        JsonNode exchangePrice = twelveDataClient.getExchangePrice(from, to);
        if (exchangePrice != null && exchangePrice.has("price")) {
            return exchangePrice.get("price").asText();
        }
        return null;
    }

    @Override
    public String getEMAValue(String symbol, String timePeriod, String interval) {
        JsonNode emaValue = twelveDataClient.getEMAValue(symbol, Integer.parseInt(timePeriod), interval);
        if (emaValue.get("values").get(0).has("ema")) {
            return emaValue.get("values").get(0).get("ema").asText();
        }
        return null;
    }
}
