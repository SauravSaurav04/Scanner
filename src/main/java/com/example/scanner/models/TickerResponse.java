package com.example.scanner.models;

import lombok.Data;

import java.util.List;

@Data
public class TickerResponse {
    private List<TickerInfo> result;
}
