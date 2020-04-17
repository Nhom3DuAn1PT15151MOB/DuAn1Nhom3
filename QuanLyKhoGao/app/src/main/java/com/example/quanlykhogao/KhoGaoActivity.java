package com.example.quanlykhogao;

import androidx.appcompat.app.AppCompatActivity;
import androidx.room.Room;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.example.quanlykhogao.model.KhoGao;
import com.example.quanlykhogao.sqlite.AppDatabase;

import java.util.Random;

public class KhoGaoActivity extends AppCompatActivity {
    EditText edMaLoaiGao, edTenGao, edNCC, edGia, edSoLuong, edDonVi;
    AppDatabase db;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_kho_gao);
        edMaLoaiGao = findViewById(R.id.editMaLoaiGao);
        edTenGao = findViewById(R.id.editTenGao);
        edNCC = findViewById(R.id.editNCC);
        edGia = findViewById(R.id.editGia);
        edSoLuong = findViewById(R.id.editSoLuong);
        edDonVi = findViewById(R.id.editDonViTinh);
        db = Room.databaseBuilder(getApplicationContext(),AppDatabase.class,"khogao.db").allowMainThreadQueries().build();

    }

    public void btnThemGao(View view) {
        KhoGao khoGao = new KhoGao();
        khoGao.id = new Random().nextInt();
        khoGao.MaLoaiGao = edMaLoaiGao.getText().toString();
        khoGao.TenGao =  edTenGao.getText().toString();
        khoGao.NhaCungCap = edNCC.getText().toString();
        khoGao.Gia = Double.valueOf(edGia.getText().toString());
        khoGao.DonVi = edDonVi.getText().toString();
        khoGao.SoLuong = Integer.valueOf(edSoLuong.getText().toString());

        if (db.khoGaoDAO().insertGao(khoGao)>0){
            Toast.makeText(getApplicationContext(),"Thêm gạo thành công",Toast.LENGTH_SHORT).show();
        }else {
            Toast.makeText(getApplicationContext(),"Thêm thất bại",Toast.LENGTH_SHORT).show();
        }


    }
}
