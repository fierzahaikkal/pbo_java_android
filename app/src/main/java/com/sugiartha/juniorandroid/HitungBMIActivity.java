package com.sugiartha.juniorandroid;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;
import androidx.core.content.ContextCompat;

import android.app.AlertDialog;
import android.content.Intent;
import android.media.Image;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import java.math.BigDecimal;

public class HitungBMIActivity extends AppCompatActivity {

    HitungBMI hitungBMI = new HitungBMI(); //Membuat object dari class HitungBMI (konsep OOP biasa)
    TextView txtBMIGender, txtStatusBadan, txtStatus, txtBMI, txtstatustinggi, txtstatusberat; //Deklarasi object bernama txtStatusBadan yang merupakan TextView
    Button btnCekBMI; //Deklarasi object bernama btnCekBMI yang merupakan Button

    Button btnaddtinggi1, btnaddtinggikoma, btnminustinggi1, btnminustinggikoma, btnaddberat1, btnaddberatkoma, btnminusberat1, btnminusberatkoma;

    RelativeLayout laki, perempuan, rlhasil;

    String gender = "0";

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.bmimenu, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()){
            case R.id.keterangan:
                Intent intent = new Intent(HitungBMIActivity.this, BMIketerangan.class);
                startActivity(intent);
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hitung_bmi);

        txtstatustinggi = findViewById(R.id.txtstatustinggi);
        txtstatusberat = findViewById(R.id.txtstatusberat);
        btnaddtinggi1 = findViewById(R.id.btnaddtinggi1);
        btnaddtinggikoma = findViewById(R.id.btnaddtinggikoma);
        btnminustinggi1 = findViewById(R.id.btnminustinggi1);
        btnminustinggikoma = findViewById(R.id.btnminustinggikoma);
        btnaddberat1 = findViewById(R.id.btnaddberat1);
        btnaddberatkoma = findViewById(R.id.btnaddberatkoma);
        btnminusberat1 = findViewById(R.id.btnminusberat1);
        btnminusberatkoma = findViewById(R.id.btnminusberatkoma);
        txtBMIGender = findViewById(R.id.txtBMIGender);
        txtStatusBadan = findViewById(R.id.txtStatusBadan); //Menyambungkan elemen dengan id txtStatusBadan yang ada di activity_main.xml kesini
        txtStatus = findViewById(R.id.txtStatus);
        txtBMI = findViewById(R.id.txtBMI);
        btnCekBMI = findViewById(R.id.btnCekBMI); //Menyambungkan elemen dengan id btnCekBMI yang ada di activity_main.xml kesini
        laki = findViewById(R.id.laki);
        perempuan = findViewById(R.id.perempuan);
        rlhasil = findViewById(R.id.rlhasil);

        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        View layoutView = getLayoutInflater().inflate(R.layout.bmi_dialog, null);

        AppCompatButton btnok = layoutView.findViewById(R.id.btnok);
        ImageView imgclose = layoutView.findViewById(R.id.imgclose);
        ImageView imgstatus = layoutView.findViewById(R.id.imgstatus);
        TextView txtBMIGenderd = layoutView.findViewById(R.id.txtBMIGenderd);
        TextView txtStatusBadand = layoutView.findViewById(R.id.txtStatusBadand);
        TextView txtStatusd = layoutView.findViewById(R.id.txtStatusd);
        TextView txtBMId = layoutView.findViewById(R.id.txtBMId);
        builder.setView(layoutView);
        AlertDialog dialog = builder.create();
        dialog.setCancelable(false);


        laki.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                laki.setBackground(ContextCompat.getDrawable(getApplicationContext(), R.drawable.bmi_background));
                perempuan.setBackground(ContextCompat.getDrawable(getApplicationContext(), R.drawable.edit_text_background));
                gender = "laki-laki";
            }
        });

        perempuan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                laki.setBackground(ContextCompat.getDrawable(getApplicationContext(), R.drawable.edit_text_background));
                perempuan.setBackground(ContextCompat.getDrawable(getApplicationContext(), R.drawable.bmi_background));
                gender = "perempuan";
            }
        });

        btnaddtinggi1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                double tinggi = Double.parseDouble(txtstatustinggi.getText().toString());
                tinggi++;
                txtstatustinggi.setText(Double.toString(tinggi));
            }
        });

        btnaddtinggikoma.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                double tinggi = Double.parseDouble(txtstatustinggi.getText().toString());
                BigDecimal tinggibd = BigDecimal.valueOf(tinggi);
                BigDecimal koma = BigDecimal.valueOf(0.1);
                txtstatustinggi.setText(tinggibd.add(koma).toString());
            }
        });

        btnminustinggi1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                double tinggi = Double.parseDouble(txtstatustinggi.getText().toString());
                tinggi--;
                txtstatustinggi.setText(Double.toString(tinggi));
            }
        });

        btnminustinggikoma.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                double tinggi = Double.parseDouble(txtstatustinggi.getText().toString());
                BigDecimal tinggibd = BigDecimal.valueOf(tinggi);
                BigDecimal koma = BigDecimal.valueOf(0.1);
                txtstatustinggi.setText(tinggibd.subtract(koma).toString());
            }
        });

        btnaddberat1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                double berat = Double.parseDouble(txtstatusberat.getText().toString());
                berat++;
                txtstatusberat.setText(Double.toString(berat));
            }
        });

        btnaddberatkoma.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                double berat = Double.parseDouble(txtstatusberat.getText().toString());
                BigDecimal beratbd = BigDecimal.valueOf(berat);
                BigDecimal koma = BigDecimal.valueOf(0.1);
                txtstatusberat.setText(beratbd.add(koma).toString());
            }
        });

        btnminusberat1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                double berat = Double.parseDouble(txtstatusberat.getText().toString());
                berat--;
                txtstatusberat.setText(Double.toString(berat));
            }
        });

        btnminusberatkoma.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                double berat = Double.parseDouble(txtstatusberat.getText().toString());
                BigDecimal beratbd = BigDecimal.valueOf(berat);
                BigDecimal koma = BigDecimal.valueOf(0.1);
                txtstatusberat.setText(beratbd.subtract(koma).toString());
            }
        });

        //btnCekBMI.setOnClickListener dibawah ini maksudnya adalah untuk me-listen (mengamati) btnCekBMI apakah ada click, apabila ada click, maka code didalamnya akan dieksekusi
        btnCekBMI.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                //Pada 2 baris code di atas, hasil yang didapatkan dari EditText adalah berbentuk STRING (defaultnya memang string)
                //Sedangkan yang kita butuhkan adalah berbentuk double, maka kita convert dulu 2 string tersebut ke tipe data double
                String stringTinggiBadan = txtstatustinggi.getText().toString();
                String stringBeratBadan = txtstatusberat.getText().toString();
                if (stringBeratBadan !="0" && stringTinggiBadan !="0" && gender !="0"){
                    double beratBadan = Double.parseDouble(stringBeratBadan);
                    double tinggiBadan = Double.parseDouble(stringTinggiBadan);
                    String statusBadan = hitungBMI.statusBMI(beratBadan, tinggiBadan);

                    txtBMIGender.setText("BMI untuk "+gender);
                    txtStatusBadan.setText(statusBadan);

                    laki.setBackground(ContextCompat.getDrawable(getApplicationContext(), R.drawable.edit_text_background));
                    perempuan.setBackground(ContextCompat.getDrawable(getApplicationContext(), R.drawable.edit_text_background));

                    gender = "0";

                    double BMI = hitungBMI.hitungBMI(beratBadan, tinggiBadan);
                    BMI = Math.round(BMI*10);
                    BMI = BMI/10;
                    txtBMI.setText(Double.toString(BMI));

                    txtStatus.setText("Tinggi "+tinggiBadan+" cm                    Berat "+beratBadan+" kg");

                    if(statusBadan == "Anda kekurangan berat badan"){
                        imgstatus.setBackgroundResource(R.drawable.bmiunderweight);
                    } else if(statusBadan == "Berat badan anda normal (ideal)"){
                        imgstatus.setBackgroundResource(R.drawable.bminormal);
                    } else if(statusBadan == "Anda beresiko kelebihan berat badan"){
                        imgstatus.setBackgroundResource(R.drawable.bmiresikokelebihanbb);
                    } else if(statusBadan == "Anda kelebihan berat badan"){
                        imgstatus.setBackgroundResource(R.drawable.bmikelebihanbb);
                    }else {
                        imgstatus.setBackgroundResource(R.drawable.bmiobesitas);
                    }
                }
                else{
                    Toast.makeText(HitungBMIActivity.this,"Jenis kelamin, Tinggi, dan berat harap diisi", Toast.LENGTH_SHORT).show();
                }
            }});

        rlhasil.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                dialog.show();
                txtBMIGenderd.setText(txtBMIGender.getText());
                txtStatusd.setText(txtStatus.getText());
                txtStatusBadand.setText(txtStatusBadan.getText());
                txtBMId.setText(txtBMI.getText());
                txtStatusd.setText(txtStatus.getText());

                btnok.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        dialog.dismiss();
                    }
                });
            }
        });



    }

}
