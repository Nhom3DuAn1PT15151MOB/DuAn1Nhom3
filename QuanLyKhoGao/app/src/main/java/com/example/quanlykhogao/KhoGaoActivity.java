package com.example.quanlykhogao;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class KhoGaoActivity extends AppCompatActivity {
    EditText edMaLoaiGao, edTenGao, edNCC, edGia, edSoLuong;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_kho_gao);
        edMaLoaiGao = findViewById(R.id.editMaLoaiGao);
        edTenGao = findViewById(R.id.editTenGao);
        edNCC = findViewById(R.id.editNCC);
        edGia = findViewById(R.id.editGia);
        edSoLuong = findViewById(R.id.editSoLuong);

    }

    public void btnThemGao(View view) {

    }
}
