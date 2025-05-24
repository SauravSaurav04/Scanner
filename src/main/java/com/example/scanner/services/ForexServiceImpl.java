package com.example.scanner.services;

import com.example.scanner.clients.TwelveDataClient;
import com.fasterxml.jackson.databind.JsonNode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

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

    @Override
    public List<String> getAllSymbols() {
        List<String> symbols = List.of("XAU/USD", "BTC/USD", "USD/CAD", "USD/JPY", "USD/CHF", "EUR/USD", "AUD/USD", "GBP/USD");
        List<String> result = new ArrayList<>();

        for (String symbol : symbols) {
            String currentPrice = getExchangePrice(symbol);
            String ema5min = getEMAValue(symbol, "200", "5min");
            String ema15min = getEMAValue(symbol, "200", "15min");

            if (currentPrice != null && ema5min != null && ema15min != null) {
                try {
                    double price = Double.parseDouble(currentPrice);
                    double ema5 = Double.parseDouble(ema5min);
                    double ema15 = Double.parseDouble(ema15min);

                    if (price > ema5 && price > ema15) {
                        result.add(symbol);
                    }
                } catch (NumberFormatException e) {
                    System.err.println("Error parsing price or EMA for symbol: " + symbol);
                }
            }
        }
        return result;
    }
}
