package com.example.userPayment.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Currency;

@NoArgsConstructor
@Getter
@Setter
@AllArgsConstructor
public class Conversion {
    private Integer idConversion;
    private Currency currencyFrom;
    private Currency currencyTo;
    private double value;
    private ExchangeRates exchangeRates;

    @Override
    public String toString() {
        return "ConversionDTO{" +
                "idConversion=" + idConversion +
                ", currencyFrom=" + currencyFrom +
                ", currencyTo=" + currencyTo +
                ", value=" + value +
                ", exchangeRates=" + exchangeRates +
                '}';
    }
}
