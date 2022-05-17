package com.model;

import java.io.IOException;
import java.util.Formatter;

import org.jsoup.Connection;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

import static org.jsoup.Jsoup.connect;


public class MoneyInfo {
    private String[] result;

    public void setValue(int i) throws IOException {
        Connection connect = connect("https://www.nbp.pl/kursy/kursyc.html");
        Document document = connect.get();
        Formatter forms = new Formatter();
        String s = String.valueOf(i);
        forms.format("#contentholder > table > tbody > tr:nth-child(%s)", s);
        Elements allTr = document.select(forms.toString());
        result = allTr.text().split(" ");

    }

    public String[] getCurrency() {
        return result;
    }
}

