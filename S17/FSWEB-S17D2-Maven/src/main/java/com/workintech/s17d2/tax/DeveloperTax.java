package com.workintech.s17d2.tax;

import org.springframework.stereotype.Component;

@Component
public class DeveloperTax implements Taxable{
    @Override
    public Double getUpperTaxRate() {
        return 15d;
    }

    @Override
    public Double getSimpleTaxRate() {
        return 25d;
    }

    @Override
    public Double getMiddleTaxRate() {
        return 35d;
    }
}
