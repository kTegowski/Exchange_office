package com.model;

public class ChangeTo {
        private double PLN;

        public static double toPLN(double a, String[] tab) {
            String currencyTEXT = tab[1];
            Double currencyValue = Double.parseDouble(currencyTEXT);
            return a * currencyValue;
        }

        public static double fromPLN(double a, String[] tab) {
            String currencyTEXT = tab[1];
            Double currencyValue = Double.parseDouble(currencyTEXT);
            return a / currencyValue;
        }

}
