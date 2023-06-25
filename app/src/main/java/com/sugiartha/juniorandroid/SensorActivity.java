package com.sugiartha.juniorandroid;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

public class SensorActivity extends AppCompatActivity {
    TextView ProximitySensor, data, jarak;
    SensorManager mySensorManager;
    Sensor myProximitySensor;
    ImageView Imgsensor;
    LinearLayout begron;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sensor);
        ProximitySensor = (TextView) findViewById(R.id.proximitySensor);
        data = (TextView) findViewById(R.id.data);
        Imgsensor = findViewById(R.id.imgsensor);
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
                    Imgsensor.setBackgroundResource(R.drawable.sensor);
                    begron.setBackgroundColor(R.drawable.birumuda);
                    data.setText("DEKAT SENSOR");
                } else {
                    Imgsensor.setBackgroundResource(R.drawable.sensor1);
                    begron.setBackgroundColor(R.drawable.birumuda);
                    data.setText("JAUH DARI SENSOR");
                }
            }
        }
    };
}