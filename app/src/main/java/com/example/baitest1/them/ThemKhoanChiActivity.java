package com.example.baitest1.them;

import androidx.appcompat.app.AppCompatActivity;

import android.database.sqlite.SQLiteOpenHelper;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import com.example.baitest1.R;
import com.example.baitest1.model.LoaiChi;
import com.example.baitest1.sqlite.KhoanChiDAO;
import com.example.baitest1.model.KhoanChi;
import com.example.baitest1.sqlite.LoaiChiDAO;

import java.util.List;

public class ThemKhoanChiActivity extends AppCompatActivity {
    private EditText mkc, tkc, sotien, date;
    private Spinner mLC;

    private KhoanChiDAO khoanChiDAO;
    private LoaiChiDAO loaiChiDAO;
    ArrayAdapter<LoaiChi> arrayAdapter;
    List<KhoanChi> khoanChiList;
    List<LoaiChi> loaiChiList;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_them_khoan_chi);
        loaiChiDAO = new LoaiChiDAO(this);
        mkc = findViewById(R.id.id_makhoanchi);
        mLC =(Spinner) findViewById(R.id.id_maloaichi);
        tkc = findViewById(R.id.id_tenkhoanchi);
        sotien = findViewById(R.id.id_soTien);
        date = findViewById(R.id.id_ngayChi);

        loaiChiDAO = new LoaiChiDAO(this);
        khoanChiDAO = new KhoanChiDAO(this);
        loaiChiList=loaiChiDAO.showListLC();
        khoanChiList = khoanChiDAO.showListKC();

        arrayAdapter = new ArrayAdapter<LoaiChi>(this,android.R.layout.simple_spinner_item,loaiChiList);
        arrayAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        mLC.setAdapter(arrayAdapter);
    }

    public void them(View view) {
        LoaiChi objLoaiChi=new LoaiChi();
        String maKC = mkc.getText().toString();
        String mlc = objLoaiChi.getmaLoaiChi();
        String tenKC = tkc.getText().toString();
        String sT = sotien.getText().toString();
        String ngay = date.getText().toString();
        KhoanChi khoanChi = new KhoanChi(maKC, mlc, tenKC, sT, ngay);
        boolean isSuccess = khoanChiDAO.insertKhoanChi(khoanChi);
        if (isSuccess == true) {
            Toast.makeText(this, "Them thanh cong", Toast.LENGTH_LONG).show();
        } else {
            Toast.makeText(this, "Them That bai", Toast.LENGTH_LONG).show();
        }
    }
}
