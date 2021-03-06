package com.company.adapter;

public class CurrencyAdapter implements OtherCurrency{
    private EuropeanCurrency europeanCurrency;

    public CurrencyAdapter(String countryName){
        if(countryName.equalsIgnoreCase("United Kingdom")){
            europeanCurrency = new PoundCurrency();
        }else if (countryName.equalsIgnoreCase("Switzerland")){
            europeanCurrency = new FrancsCurrency();
        }
    }

    @Override
    public void convertToEuro(String countryName, double amount, double duty, double rate) {
        if (countryName.equalsIgnoreCase("United Kingdom")) {
            europeanCurrency.convertPoundsToEuro(amount, rate);
        } else if (countryName.equalsIgnoreCase("Switzerland")) {
            europeanCurrency.convertFrancsToEuro(amount, rate);
        }
    }
}