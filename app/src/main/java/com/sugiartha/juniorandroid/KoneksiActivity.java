package com.sugiartha.juniorandroid;

import android.app.AlertDialog;
import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;

import com.airbnb.lottie.LottieAnimationView;

public class KoneksiActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_koneksi);

        Button btnCheck = (Button) findViewById(R.id.btnCheck);
        TextView txtcheck = findViewById(R.id.txtcheck);

        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        View layoutView = getLayoutInflater().inflate(R.layout.koneksi_dialog, null);

        AppCompatButton btnretry = layoutView.findViewById(R.id.btnretry);
        ImageView imgclose = layoutView.findViewById(R.id.imgclose);
        builder.setView(layoutView);
        AlertDialog dialog = builder.create();
        dialog.setCancelable(false);



        btnCheck.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ConnectivityManager cm = (ConnectivityManager) getApplication().getSystemService(Context.CONNECTIVITY_SERVICE);
                NetworkInfo netInfo = cm.getActiveNetworkInfo();
                if (netInfo != null && netInfo.isConnected()) {
                    txtcheck.setText("You are connected to "+netInfo.getTypeName()+" "+netInfo.getSubtypeName());
                    txtcheck.setTextSize(20);
                    Toast.makeText(getApplication(), "You are connected to "+netInfo.getTypeName()+" "+netInfo.getSubtypeName(), Toast.LENGTH_SHORT).show();

                } else {
                    Toast.makeText(getApplication(), "You don't have connection.", Toast.LENGTH_SHORT).show();
                    dialog.show();
                    btnretry.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View view) {
                            ConnectivityManager cm = (ConnectivityManager) getApplication().getSystemService(Context.CONNECTIVITY_SERVICE);
                            NetworkInfo netInfo = cm.getActiveNetworkInfo();
                            if (netInfo != null && netInfo.isConnected()) {
                                dialog.dismiss();
                                txtcheck.setText("You are connected to "+netInfo.getTypeName()+" "+netInfo.getSubtypeName());
                                txtcheck.setTextSize(20);
                                Toast.makeText(getApplication(), "You are connected to "+netInfo.getTypeName()+" "+netInfo.getSubtypeName(), Toast.LENGTH_SHORT).show();
                            }else{
                                dialog.dismiss();
                                dialog.show();
                            }
                        }
                    });
                    imgclose.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View view) {
                            finish();
                        }
                    });
                }
            }
        });
    }
}