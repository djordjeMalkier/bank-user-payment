package com.example.userPayment.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@NoArgsConstructor
@Getter
@Setter
@AllArgsConstructor
public class ExchangeRates {
    private Integer idExchangeRates;
    private String name;
    private List<Conversion> conversions;

    @Override
    public String toString() {
        return "ExchangeRatesDTO{" +
                "idExchangeRates=" + idExchangeRates +
                ", name='" + name + '\'' +
                ", conversions=" + conversions +
                '}';
    }
}
