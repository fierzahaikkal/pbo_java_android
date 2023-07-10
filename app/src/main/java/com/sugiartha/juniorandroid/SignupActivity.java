package com.sugiartha.juniorandroid;

import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.textfield.TextInputEditText;
import com.google.android.material.textfield.TextInputLayout;
import com.sugiartha.juniorandroid.helper.UserHelper;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class SignupActivity extends AppCompatActivity {

    TextInputEditText nama, email, username, password;
    TextInputLayout tilemail, tilusername, tilpassword;
    RadioGroup gender;
    RadioButton radioButton;
    Button btnsignup;
    TextView pindahlogin;
    //array of strings used to populate the spinner

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);

        UserHelper userHelper = new UserHelper(this);

        nama = findViewById(R.id.nama);
        email = findViewById(R.id.email);
        username = findViewById(R.id.username);
        password = findViewById(R.id.password);
        tilemail = findViewById(R.id.tilemail);
        tilusername = findViewById(R.id.tilusername);
        tilpassword = findViewById(R.id.tilpassword);
        gender = findViewById(R.id.radio);
        btnsignup = findViewById(R.id.btnsignup);
        pindahlogin = findViewById(R.id.pindahlogin);
        //fetching view's id
        // Register a callback to be invoked when an item in this AdapterView has been selected

        email.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                String inputemail = charSequence.toString();
                Pattern pattern = Pattern.compile("^[\\w.+\\-]+@gmail\\.com$");
                Matcher matcher = pattern.matcher(inputemail);
                boolean emailreal = matcher.find();
                if(emailreal){
                    tilemail.setHelperText("Email benar");
                    tilemail.setError("");
                }
                else{
                    tilemail.setError("Masukkan email yang benar");
                }
            }

            @Override
            public void afterTextChanged(Editable editable) {

            }
        });

        username.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                String inputusername = charSequence.toString();
                if(inputusername.length() <= 20){
                    if (inputusername.length() >= 8){
                        Pattern pattern = Pattern.compile("^[a-zA-Z0-9_]+$");
                        Matcher matcher = pattern.matcher(inputusername);
                        boolean usernamereal = matcher.find();
                        if (usernamereal){
                            tilusername.setHelperText("Username valid");
                            tilusername.setError("");
                        }
                        else{
                            tilusername.setError("Username invalid hanya boleh mengandung huruf kapital, angka, dan _");
                        }
                    }
                    else{
                        tilusername.setError("Panjang username harus minimal 8 karakter");
                    }
                }
                else{
                    tilusername.setError("Panjang username maksimal 20 karakter");
                }
            }

            @Override
            public void afterTextChanged(Editable editable) {

            }
        });

        password.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                String inputpassword = charSequence.toString();
                if(inputpassword.length() <=16){
                    if (inputpassword.length() >= 8){
                        Pattern pattern = Pattern.compile("[^a-zA-Z0-9]");
                        Matcher matcher = pattern.matcher(inputpassword);
                        boolean passwordreal = matcher.find();
                        if (passwordreal){
                            tilpassword.setHelperText("Password kuat");
                            tilpassword.setError("");
                        }
                        else{
                            tilpassword.setError("Password harus mengandung huruf kapital, angka, dan simbol");
                        }
                    }
                    else{
                        tilpassword.setError("Panjang password harus minimal 8 karakter");
                    }
                }
                else{
                    tilpassword.setError("Panjang password maksimal 16 karakter");
                }


            }

            @Override
            public void afterTextChanged(Editable editable) {

            }
        });


        gender.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                radioButton = findViewById(gender.getCheckedRadioButtonId());
            }
        });


        btnsignup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                radioButton = findViewById(gender.getCheckedRadioButtonId());

                if(!userHelper.checkUsername(username.getText().toString()) && !userHelper.checkEmail(email.getText().toString())){
                    if (tilpassword.getHelperText()=="Password kuat" && tilemail.getHelperText()=="Email benar"
                            && tilusername.getHelperText()=="Username valid" && gender.getCheckedRadioButtonId() != -1) {

                        userHelper.insert(nama.getText().toString().trim(), username.getText().toString().trim(),
                                password.getText().toString().trim(), email.getText().toString().trim(), radioButton.getText().toString().trim());

                        Toast.makeText(SignupActivity.this, "Berhasil signup", Toast.LENGTH_SHORT).show();
                        startActivity(new Intent(SignupActivity.this,LoginActivity.class));
                        finish();
                    }
                }if(userHelper.checkUsername(username.getText().toString()) || userHelper.checkEmail(email.getText().toString())){
                    Toast.makeText(SignupActivity.this, "username/email sudah ada", Toast.LENGTH_SHORT).show();
                }
                else{
                    if(TextUtils.isEmpty(nama.getText().toString()) || TextUtils.isEmpty(email.getText().toString()) ||
                            TextUtils.isEmpty(username.getText().toString()) || TextUtils.isEmpty(password.getText().toString()) || TextUtils.isEmpty(radioButton.getText().toString())){
                        Toast.makeText(SignupActivity.this, "Gagal signup, harap isi semua data anda dengan benar", Toast.LENGTH_SHORT).show();
                    }
                }
            }
        });

        pindahlogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent pindahactivity = new Intent (SignupActivity.this, LoginActivity.class);
                startActivity(pindahactivity);
                finish();
            }
        });
    }

//    public void userSignup (SignupRequest signupRequest){
//
//        Call <SignupResponse> signupResponseCall = ApiClient.getService().userSignup(signupRequest);
//        signupResponseCall.enqueue(new Callback<SignupResponse>() {
//            @Override
//            public void onResponse(Call<SignupResponse> call, Response<SignupResponse> response) {
//                if(response.isSuccessful()){
//                    Toast.makeText(SignupActivity.this, "Berhasil membuat akun", Toast.LENGTH_LONG).show();
//
//                    startActivity(new Intent(SignupActivity.this, LoginActivity.class));
//                    finish();
//                }else{
//                    Toast.makeText(SignupActivity.this, "Terjadi kesalahan harap coba kembali", Toast.LENGTH_LONG).show();
//                }
//            }
//
//            @Override
//            public void onFailure(Call<SignupResponse> call, Throwable t) {
//
//                Toast.makeText(SignupActivity.this, t.getLocalizedMessage(),Toast.LENGTH_LONG).show();
//            }
//        });
//    }

}
