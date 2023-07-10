package com.sugiartha.juniorandroid;

import android.content.Context;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.Bundle;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.airbnb.lottie.LottieAnimationView;

public class SensorActivity extends AppCompatActivity {
    TextView ProximitySensor, data, jarak, txtinfo;
    SensorManager mySensorManager;
    Sensor myProximitySensor;
    ImageView Imgsensor;
    LottieAnimationView Imgsensor2, Imgsensor3, Imgsensor4;
    FrameLayout begron;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sensor);
        ProximitySensor = (TextView) findViewById(R.id.proximitySensor);
        data = (TextView) findViewById(R.id.data);
        txtinfo = findViewById(R.id.txtinfo);
        Imgsensor = findViewById(R.id.imgsensor);
        Imgsensor2 = findViewById(R.id.imgsensor2);
        Imgsensor3 = findViewById(R.id.imgsensor3);
        Imgsensor4 = findViewById(R.id.imgsensor4);
        begron = findViewById(R.id.begron);
        jarak = findViewById(R.id.jarak);
        mySensorManager = (SensorManager) getSystemService(
                Context.SENSOR_SERVICE);
        myProximitySensor = mySensorManager.getDefaultSensor(
                Sensor.TYPE_PROXIMITY);
        if (myProximitySensor == null) {
            ProximitySensor.setText("Sensor Proximity Tidak Terdeteksi!");
        } else {
            mySensorManager.registerListener(proximitySensorEventListener, myProximitySensor, SensorManager.SENSOR_DELAY_NORMAL);
        }
    }
    SensorEventListener proximitySensorEventListener
            = new SensorEventListener() {
        @Override
        public void onAccuracyChanged(Sensor sensor, int accuracy) {
            // TODO Auto-generated method stub
        }
        @Override
        public void onSensorChanged(SensorEvent event) {
            // TODO Auto-generated method stub
            if (event.sensor.getType() == Sensor.TYPE_PROXIMITY) {
                jarak.setText("VALUES: "+event.values[0]+"cm");
                if (event.values[0] == 0) {
                    Imgsensor3.setVisibility(View.VISIBLE);
                    Imgsensor2.setVisibility(View.VISIBLE);
                    Imgsensor.setVisibility(View.INVISIBLE);
                    begron.setBackgroundResource(R.drawable.bulat_gelap);
                    Imgsensor4.setVisibility(View.INVISIBLE);
                    txtinfo.setVisibility(View.INVISIBLE);
                    data.setText("DEKAT SENSOR");
                } else {
                    Imgsensor3.setVisibility(View.INVISIBLE);
                    Imgsensor2.setVisibility(View.INVISIBLE);
                    Imgsensor.setVisibility(View.VISIBLE);
                    begron.setBackgroundResource(R.drawable.bulat_terang);
                    Imgsensor4.setVisibility(View.VISIBLE);
                    txtinfo.setVisibility(View.VISIBLE);
                    data.setText("JAUH DARI SENSOR");
                }
            }
        }
    };
}