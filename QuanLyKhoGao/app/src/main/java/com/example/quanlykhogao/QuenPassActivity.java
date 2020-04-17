package com.example.quanlykhogao;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class QuenPassActivity extends AppCompatActivity {
    EditText phoneNumber;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quen_pass);
        setTitle("Quên Pass");
        phoneNumber = findViewById(R.id.chec_ked_PhoneNumber);
    }

    @SuppressLint("ResourceAsColor")
    public void nhanMa(View view) {
        int soCheck = 0;
        String checkPhone = phoneNumber.getText().toString();
        for (int i = 0; i < checkPhone.length(); i++) {
            if (Character.isLetter(checkPhone.charAt(i)) || checkPhone.length() > 10) {
               soCheck= soCheck+1;
            }
        }
        if (soCheck > 0){
            phoneNumber.setBackgroundColor(R.color.red);
            phoneNumber.setTextColor(R.color.red);
            Toast.makeText(getApplicationContext(), "Số điện thoại không hợp lệ", Toast.LENGTH_SHORT).show();
        }
        else if (checkPhone.length() == 0|| checkPhone.isEmpty()||checkPhone.equals("")) {
            Toast.makeText(getApplicationContext(), "Không được để trống", Toast.LENGTH_SHORT).show();
        }
        else {
            Intent intent = new Intent(this, NewPassActivity.class);
            startActivity(intent);
        }
    }
}
