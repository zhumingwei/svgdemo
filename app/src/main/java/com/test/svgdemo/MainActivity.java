package com.test.svgdemo;

import android.animation.ValueAnimator;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import com.test.svgdemo.widget.TemperatureGaugeView;

public class MainActivity extends AppCompatActivity {
    TemperatureGaugeView view;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
         view = findViewById(R.id.temperatureView);

        view.setTemperature(0.5f);
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                ValueAnimator va = ValueAnimator.ofFloat(0.0f,1.0f).setDuration(20000);
                va.setInterpolator(null);
                va.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
                    @Override
                    public void onAnimationUpdate(ValueAnimator animation) {
                        Log.d("123",animation.getAnimatedValue().toString());
                        view.setTemperature((Float) animation.getAnimatedValue());
                    }
                });
                va.start();
            }
        },2000);

    }
}
