package com.sugiartha.juniorandroid;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class NamaActivity extends AppCompatActivity {

    Button btnOk;
    Button btnClear;
    EditText editNama;
    EditText editNPM;
    TextView txtHasil;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_nama);

        btnOk = findViewById(R.id.btnOk);
        btnClear = findViewById(R.id.btnClear);
        editNama = findViewById(R.id.editNama);
        editNPM = findViewById(R.id.editNPM);
        txtHasil = findViewById(R.id.txtHasil);

        btnOk.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String nama = editNama.getText().toString();
                String npm = editNPM.getText().toString();
                String hasil = "Nama anda \"" + nama + "\" dengan NPM " + npm;
                txtHasil.setText(hasil);
            }
        });

        btnClear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                editNama.getText().clear();
                editNPM.getText().clear();
                txtHasil.setText("");
            }
        });
    }
}
