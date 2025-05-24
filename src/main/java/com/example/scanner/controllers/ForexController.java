package com.example.scanner.controllers;

import com.example.scanner.services.ForexService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ForexController {

    @Autowired
    private ForexService forexService;

    @GetMapping("/getPrice")
    public ResponseEntity<String> getExchangePrice(@RequestParam String symbol) {
        return forexService.getExchangePrice(symbol) != null
                ? ResponseEntity.ok(forexService.getExchangePrice(symbol))
                : ResponseEntity.status(HttpStatus.NOT_FOUND).body("Exchange price not found");
    }

    @GetMapping("/getEMAValue")
    public ResponseEntity<String> getEMAValue(@RequestParam String symbol, @RequestParam String timePeriod, @RequestParam String interval) {
        return forexService.getEMAValue(symbol, timePeriod, interval) != null
                ? ResponseEntity.ok(forexService.getEMAValue(symbol, timePeriod, interval))
                : ResponseEntity.status(HttpStatus.NOT_FOUND).body("EMA price not found");
    }

    @GetMapping("/getAllSymbols")
    public ResponseEntity<?> getAllSymbols() {
        return ResponseEntity.ok(forexService.getAllSymbols());
    }
}
