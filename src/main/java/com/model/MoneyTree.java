package com.model;
import java.util.Map;
import java.util.TreeMap;

public class MoneyTree {
        static Map<String, String[]> money = new TreeMap<>();
        public static String[] keyset = new String[10];

        public void addtoMap(String[] tab) {
            int n;

            String name;

            if (tab[0].equals("euro")) {
                n = 2;
                name = tab[0];

            } else {
                n = 3;
                name = tab[0] + " " + tab[1];
            }

            String buyPriceTEXT = tab[n + 1].replace(",", ".");
            String sellPriceTEXT = tab[n + 2].replace(",", ".");
            String quantityTEXt = tab[n - 1];


            double buyPrice = Double.parseDouble(buyPriceTEXT);
            double sellPrice = Double.parseDouble(sellPriceTEXT);
            double quantity = Double.parseDouble(quantityTEXt);
            double price = (buyPrice + sellPrice) / (2 * quantity);
            String priceText = String.valueOf(price);
            String[] bufor = {name, priceText};
            money.put(tab[n], bufor);
            setKeyset();
        }





    public static String[] getSet(){return keyset;}

    public void setKeyset() {
        keyset = money.keySet().toArray(new String[0]);
    }

    public static String[] getValue(String name) {
        return money.get(name);
    }


}

