package com.infiniteloop.booknetwork.models;

/**
 * Created by Bogdan on 3/15/2015.
 */
public class RetailPrice {
    Number amount;
    String currencyCode;

    public Number getAmount() {
        return amount;
    }

    public void setAmount(Number amount) {
        this.amount = amount;
    }

    public String getCurrencyCode() {
        return currencyCode;
    }

    public void setCurrencyCode(String currencyCode) {
        this.currencyCode = currencyCode;
    }
}
