package com.example.scanner.controllers;

import com.example.scanner.models.TickerResponse;
import com.example.scanner.services.CryptoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ForexController {

    @Autowired
    private CryptoService cryptoService;

    @GetMapping("/crypto")
    public TickerResponse getCryptoPrice() {
        return cryptoService.getCryptoTickerData();
    }

    @GetMapping("/crypto/symbol")
    public Double getCryptoPriceByName(@RequestParam String symbol) {
        return cryptoService.getCryptoPrice(symbol);
    }
}
