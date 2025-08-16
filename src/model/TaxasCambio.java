package model;

import java.util.Map;


public record TaxasCambio(
        String result,
        Map<String, Double> conversion_rates
) {}