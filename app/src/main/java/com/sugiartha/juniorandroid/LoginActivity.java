package com.sugiartha.juniorandroid;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.textfield.TextInputEditText;
import com.sugiartha.juniorandroid.helper.UserHelper;

public class LoginActivity extends AppCompatActivity {

    TextInputEditText username, password;
    Button btn_login, btn_google, btn_facebook;
    UserHelper userHelper = new UserHelper(LoginActivity.this);
    TextView ke_signup;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        username = findViewById(R.id.username);
        password = findViewById(R.id.password);
        btn_login = findViewById(R.id.btn_login);
        btn_google = findViewById(R.id.btn_google);
        btn_facebook = findViewById(R.id.btn_facebook);
        ke_signup = findViewById(R.id.ke_signup);


        ke_signup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(LoginActivity.this, SignupActivity.class));
            }
        });

        btn_login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (TextUtils.isEmpty(username.getText().toString()) ||
                        TextUtils.isEmpty(password.getText().toString())) {
                    Toast.makeText(LoginActivity.this, "Masukkan username/password", Toast.LENGTH_LONG)
                            .show();
                }else{

                    if(userHelper.matchingUser(username.getText().toString().trim(),
                            password.getText().toString().trim())){
                        Toast.makeText(LoginActivity.this, "Berhasil Login", Toast.LENGTH_LONG).show();
                        startActivity(new Intent(LoginActivity.this, MainActivity.class));
                        finish();
                    }if(!userHelper.matchingUser(username.getText().toString().trim(),
                            password.getText().toString().trim())){
                        Toast.makeText(LoginActivity.this, "Harap cek username/password anda", Toast.LENGTH_LONG).show();
                    }




                }
            }
        });
    }
}
