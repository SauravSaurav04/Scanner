package com.example.scanner.services;

import java.util.List;

public interface ForexService {

    String getExchangePrice(String symbol);

    String getEMAValue(String symbol, String timePeriod, String interval);

    List<String> getAllSymbols();

}
