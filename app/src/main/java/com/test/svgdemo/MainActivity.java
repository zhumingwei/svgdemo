package com.test.svgdemo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.test.svgdemo.widget.TemperatureGaugeView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        TemperatureGaugeView view = findViewById(R.id.temperatureView);
        view.setTemperature(0.52f);
    }
}
