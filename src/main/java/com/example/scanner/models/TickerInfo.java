package com.example.scanner.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.util.Map;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class TickerInfo {

    private double close;

    @JsonProperty("contract_type")
    private String contractType;
    private String description;

    @JsonProperty("funding_rate")
    private String fundingRate;
    private double high;
    private double low;

    @JsonProperty("mark_price")
    private double markPrice;
    private double open;

    @JsonProperty("spot_price")
    private double spotPrice;
    private String symbol;
    private double volume;

    @JsonProperty("mark_change_24h")
    private String markChange24h;

    @JsonProperty("quotes")
    private Map<String, Object> quotes;

    @JsonProperty("oi_value_usd")
    private String oiValueUsd;

    @JsonProperty("turnover_usd")
    private double turnoverUsd;

}
