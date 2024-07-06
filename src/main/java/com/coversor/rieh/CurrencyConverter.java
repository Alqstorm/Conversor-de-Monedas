package com.coversor.rieh;
//revisar profundamente como funcionan estas partes ya que aun no las entiendo muy bien

public class CurrencyConverter {
    private final ExchangeRateService exchangeRateService;

    public CurrencyConverter() {
        this.exchangeRateService = new ExchangeRateService();
    }

    public double convert(String fromCurrency, String toCurrency, double amount) {
        double rate = exchangeRateService.getExchangeRate(fromCurrency, toCurrency);
        return amount * rate;
    }
}
