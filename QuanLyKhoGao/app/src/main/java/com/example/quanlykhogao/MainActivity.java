package com.example.quanlykhogao;

import androidx.appcompat.app.AppCompatActivity;
import androidx.room.Room;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;

import com.example.quanlykhogao.sqlite.AppDatabase;

public class MainActivity extends AppCompatActivity {
    Context  context;
    String strUserName,strPassWord;
    @SuppressLint("ResourceType")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setTitle("Quản lý kho gạo");
     //   AppDatabase db = Room.databaseBuilder(getApplicationContext(),
       //         AppDatabase.class, "NguoiDung.db, KhoGao.db, VatTu.db").allowMainThreadQueries().build();

        if (CheckLoginShap() < 0) {
            Intent i = new Intent(MainActivity.this, LogInActivity.class);
            startActivity(i);
        }
    }
    private int CheckLoginShap() {
        SharedPreferences preferences = getSharedPreferences("USER_FILE", MODE_PRIVATE);
        boolean check = preferences.getBoolean("REMEMBER", true);
        if (check) {
            strUserName = preferences.getString("USERNAME", "");
            strPassWord = preferences.getString("PASSWORD", "");
            return 1;
        }
        return -1;
    }

    public void viewNguoiDung(View view) {
        Intent intent = new Intent(MainActivity.this,ListNguoiDungActivity.class);
        startActivity(intent);
    }

    public void viewKhoGao(View view) {
        Intent intent1 = new Intent(this,ListKhoGaoActivity.class);
        startActivity(intent1);
    }

    public void viewVatTu(View view) {
        Intent intent2 = new Intent(this,ListVatTuActivity.class);
        startActivity(intent2);
    }

    public void viewThongKe(View view) {
        Intent intent3 = new Intent(this,ThongKeActivity.class);
        startActivity(intent3);
    }
}
