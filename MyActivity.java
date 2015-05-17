package com.example.Bar1;

import android.app.Activity;
import android.os.Bundle;
import android.widget.TextView;

import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;

public class MyActivity extends Activity {
    /**
     * Called when the activity is first created.
     */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);

        Financial f = new Financial();
        TextView tv = (TextView)findViewById(R.id.xrate);
        tv.setText(f.get_price_string(1.4));
    }
}
