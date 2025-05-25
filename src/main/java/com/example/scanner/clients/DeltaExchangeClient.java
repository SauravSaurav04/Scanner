package com.example.scanner.clients;

import com.example.scanner.models.TickerResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.client.WebClient;

@Slf4j
@Component
public class DeltaExchangeClient {

    @Autowired
    @Qualifier("deltaExchangeWebClient")
    private WebClient deltaExchangeWebClient;

    public TickerResponse getCryptoTickerData() {
        return deltaExchangeWebClient.get()
                .uri(uriBuilder -> uriBuilder
                        .path("/tickers")
                        .build())
                .retrieve()
                .bodyToMono(TickerResponse.class)
                .doOnSuccess(response -> log.info("Successfully retrieved exchange price: {}", response))
                .doOnError(error -> log.error("Failed to retrieve exchange price. Error: {}", error.getMessage()))
                .block();
    }
}
