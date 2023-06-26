package com.sugiartha.juniorandroid;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class LingkaranActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lingkaran);

        Button hitung = (Button) findViewById(R.id.hitung);
        EditText jari2 = (EditText) findViewById(R.id.jari2);
        TextView luas = (TextView) findViewById(R.id.luas);
        TextView keliling = (TextView) findViewById(R.id.keliling);

        hitung.setOnClickListener(new Button.OnClickListener() {
            @Override public void onClick(View v) {
                double jari = Double.parseDouble(jari2.getText().toString());
                double phi = 3.14;
                double dblLuas = phi*jari*jari;
                double dblKeliling = 2*phi*jari;

                luas.setText(Double.toString(dblLuas));
                keliling.setText(Double.toString(dblKeliling));
            }});
    }
}
