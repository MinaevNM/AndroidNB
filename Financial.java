package com.example.Bar1;

import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;

/**
 * Created by Nikita on 18.05.2015.
 */
public class Financial
{
    private int rubl_per_$;

    public Financial()
    {
        StringBuilder html_res = new StringBuilder();
        String htmls = new String();

        try
        {
            URL u = new URL("http://www.cbr.ru/");
            URLConnection uc = u.openConnection();
            InputStreamReader isr = new InputStreamReader(uc.getInputStream());
            char [] buffer = new char [40000];
            int n;

            while ((n = isr.read(buffer, 0, buffer.length)) > 0)
                html_res.append(buffer, 0, n);
            htmls = html_res.toString();
        }
        catch (java.io.IOException e){}

        int xstart = htmls.indexOf("<ins class=\"rubl\"");
        String rate = htmls.substring(xstart + 34, xstart + 41);
        rubl_per_$ = (rate.charAt(0) - '0') * 10 + rate.charAt(1) - '0';
        rubl_per_$ = 10 * (rubl_per_$ / 10 + 1);
    }

    public int get_rubl_per_$()
    {
        return rubl_per_$;
    }

    public double get_price( double bucks )
    {
        return bucks * rubl_per_$;
    }

    public String get_price_string( double bucks )
    {
        String price = new String("$");
        price = price.concat(String.valueOf(bucks));
        price = price.concat("/");
        price = price.concat(String.valueOf(get_price(bucks)));
        price = price.concat(" руб.");
        return price;
    }
}
