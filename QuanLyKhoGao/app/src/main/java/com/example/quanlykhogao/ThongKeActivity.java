package com.example.quanlykhogao;

import androidx.appcompat.app.AppCompatActivity;
import androidx.room.Room;

import android.os.Bundle;
import android.view.View;
import android.widget.Spinner;
import android.widget.TextView;

import com.example.quanlykhogao.sqlite.AppDatabase;

public class ThongKeActivity extends AppCompatActivity {
TextView tvTongGao,tvTongChiPhi;
    AppDatabase db;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_thong_ke);
        setTitle("Thống kê");
        tvTongChiPhi = findViewById(R.id.tvTongVatTu);
        tvTongGao = findViewById(R.id.tvTongGao);
         db = Room.databaseBuilder(getApplicationContext(),AppDatabase.class,"KhoGao.db").allowMainThreadQueries().build();
    }

    public void update(View view) {
        AppDatabase db2 = Room.databaseBuilder(getApplicationContext(),AppDatabase.class,"VatTu.db").allowMainThreadQueries().build();
        tvTongGao.setText(""+db.khoGaoDAO().getAll());
        tvTongChiPhi.setText(""+db2.vatTuDAO().getAll());
    }
}
