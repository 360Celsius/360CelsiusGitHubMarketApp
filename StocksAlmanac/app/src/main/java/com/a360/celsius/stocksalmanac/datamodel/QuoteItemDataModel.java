package com.a360.celsius.stocksalmanac.datamodel;

/**
 * Created by dennisshar on 24/10/2017.
 */

public class QuoteItemDataModel {
    String symbol;
    String exchange;
    String name;
    double lastPrice;
    String tradeTimeStamp;
    double netChange;
    double percentChange;
    double open;
    double high;
    double low;
    double close;
    double volume;

    public QuoteItemDataModel(String symbol, String exchange, String name, double lastPrice, String tradeTimeStamp, double netChange, double percentChange, double open, double high, double low, double close, double volume) {
        this.symbol = symbol;
        this.exchange = exchange;
        this.name = name;
        this.lastPrice = lastPrice;
        this.tradeTimeStamp = tradeTimeStamp;
        this.netChange = netChange;
        this.percentChange = percentChange;
        this.open = open;
        this.high = high;
        this.low = low;
        this.close = close;
        this.volume = volume;
    }

    public String getSymbol() {
        return symbol;
    }

    public void setSymbol(String symbol) {
        this.symbol = symbol;
    }

    public String getExchange() {
        return exchange;
    }

    public void setExchange(String exchange) {
        this.exchange = exchange;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getLastPrice() {
        return lastPrice;
    }

    public void setLastPrice(double lastPrice) {
        this.lastPrice = lastPrice;
    }

    public String getTradeTimeStamp() {
        return tradeTimeStamp;
    }

    public void setTradeTimeStamp(String tradeTimeStamp) {
        this.tradeTimeStamp = tradeTimeStamp;
    }

    public double getNetChange() {
        return netChange;
    }

    public void setNetChange(double netChange) {
        this.netChange = netChange;
    }

    public double getPercentChange() {
        return percentChange;
    }

    public void setPercentChange(double percentChange) {
        this.percentChange = percentChange;
    }

    public double getOpen() {
        return open;
    }

    public void setOpen(double open) {
        this.open = open;
    }

    public double getHigh() {
        return high;
    }

    public void setHigh(double high) {
        this.high = high;
    }

    public double getLow() {
        return low;
    }

    public void setLow(double low) {
        this.low = low;
    }

    public double getClose() {
        return close;
    }

    public void setClose(double close) {
        this.close = close;
    }

    public double getVolume() {
        return volume;
    }

    public void setVolume(double volume) {
        this.volume = volume;
    }
}
