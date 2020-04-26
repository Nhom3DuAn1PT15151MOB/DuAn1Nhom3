package com.example.quanlykhogao;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Spinner;
import android.widget.TextView;

public class ThongKeActivity extends AppCompatActivity {
TextView tvTongGao,tvTongChiPhi;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_thong_ke);
        setTitle("Thống kê");
        tvTongChiPhi = findViewById(R.id.tvTongVatTu);
        tvTongGao = findViewById(R.id.tvTongGao);
    }
}
