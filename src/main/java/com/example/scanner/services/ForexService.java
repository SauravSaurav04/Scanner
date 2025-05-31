package com.example.scanner.services;

import java.util.List;
import java.util.Map;

public interface ForexService {

    String getExchangePrice(String symbol);

    String getEMAValue(String symbol, String timePeriod, String interval);

    List<String> getAllSymbols();

    public Map<String, Double> getPriceAndEMA(String symbol);
}
