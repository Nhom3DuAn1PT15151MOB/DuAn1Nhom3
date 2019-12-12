package com.example.baitest1.them;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.example.baitest1.R;
import com.example.baitest1.sqlite.LoaiChiDAO;
import com.example.baitest1.model.LoaiChi;

public class ThemLoaiChiActivity extends AppCompatActivity {
    private EditText maloaichi, tenloaichi;
    private LoaiChiDAO loaiChiDAO;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_them_loai_chi);

        loaiChiDAO = new LoaiChiDAO(this);

        maloaichi = findViewById(R.id.Ma_loai_chi);
        tenloaichi = findViewById(R.id.Ten_loai_chi);
    }
    public void themloaichi(View view) {
        try {
            String maLC = maloaichi.getText().toString();
            String tenLC = tenloaichi.getText().toString();

            LoaiChi loaiChi = new LoaiChi(maLC, tenLC);

            boolean isSuccess = loaiChiDAO.insertLoaiChi(loaiChi);

            if (isSuccess) {
                Toast.makeText(this, "Them thanh cong", Toast.LENGTH_SHORT).show();
            } else {
                Toast.makeText(this, "Them That bai", Toast.LENGTH_SHORT).show();
            }
        }catch (Exception e) {
            e.printStackTrace();
        }
    }
}
