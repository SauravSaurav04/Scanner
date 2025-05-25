package com.example.scanner.services;

import com.example.scanner.models.TickerResponse;

public interface CryptoService {

    TickerResponse getCryptoTickerData();

    Double getCryptoPrice(String symbol);

}
