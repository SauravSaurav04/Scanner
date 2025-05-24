package com.example.scanner.services;

public interface ForexService {

    String getExchangePrice(String symbol);

    String getEMAValue(String symbol, String timePeriod, String interval);

}
