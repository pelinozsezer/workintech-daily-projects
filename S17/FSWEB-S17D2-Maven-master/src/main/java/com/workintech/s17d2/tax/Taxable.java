package com.workintech.s17d2.tax;

public interface Taxable {
    Double getSimpleTaxRate(); // abstract method - automatically public abstract
    Double getMiddleTaxRate();
    Double getUpperTaxRate();
}
