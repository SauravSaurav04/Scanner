package com.example.scanner.services;

import com.example.scanner.clients.DeltaExchangeClient;
import com.example.scanner.models.TickerInfo;
import com.example.scanner.models.TickerResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CryptoServiceImpl implements CryptoService {

    @Autowired
    DeltaExchangeClient deltaExchangeClient;

    @Override
    public TickerResponse getCryptoTickerData() {
        return deltaExchangeClient.getCryptoTickerData();
    }

    @Override
    public Double getCryptoPrice(String symbol) {
        TickerResponse tickerResponse = deltaExchangeClient.getCryptoTickerData();
        return tickerResponse.getResult().stream()
                .filter(info -> info.getSymbol().equalsIgnoreCase(symbol))
                .findFirst()
                .map(TickerInfo::getSpotPrice).orElse(null);
    }
}
