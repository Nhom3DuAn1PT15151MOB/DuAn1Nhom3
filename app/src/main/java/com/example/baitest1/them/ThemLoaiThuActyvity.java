package com.example.baitest1.them;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.example.baitest1.R;
import com.example.baitest1.model.LoaiThu;
import com.example.baitest1.sqlite.LoaiThuDAO;

public class ThemLoaiThuActyvity extends AppCompatActivity {
    private EditText maLoaiThu;
    private EditText tenLoaiThu;
    private LoaiThuDAO loaiThuDAO;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.them_loai_thu);
        maLoaiThu = findViewById(R.id.id_Ma_loai_thu);
        tenLoaiThu = findViewById(R.id.id_Ten_loai_thu);
        loaiThuDAO = new LoaiThuDAO(this);
    }

    public void themloaithu(View view) {
        String adMLT = maLoaiThu.getText().toString();
        String adTLT = tenLoaiThu.getText().toString();

        LoaiThu loaiThu = new LoaiThu(adMLT, adTLT);
        boolean isSucess = loaiThuDAO.insertLoaiThu(loaiThu);
        if (isSucess) {
            Toast.makeText(this, "Thêm loại thu thành công", Toast.LENGTH_SHORT).show();
        } else {
            Toast.makeText(this, "Thêm loại thu thất bại", Toast.LENGTH_SHORT).show();
        }
    }
}
