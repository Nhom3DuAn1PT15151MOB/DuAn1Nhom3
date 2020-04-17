package com.example.quanlykhogao;

import androidx.appcompat.app.AppCompatActivity;
import androidx.room.Room;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.example.quanlykhogao.model.VatTu;
import com.example.quanlykhogao.sqlite.AppDatabase;

import java.util.Random;

public class VatTuActivity extends AppCompatActivity {
EditText edMaVatTu, edTenVatTu, edChiPhi;
AppDatabase db;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_vat_tu);
        edChiPhi = findViewById(R.id.editChiPhi);
        edMaVatTu = findViewById(R.id.editMaVatTu);
        edTenVatTu = findViewById(R.id.editTenVatTu);
        db = Room.databaseBuilder(getApplicationContext(),AppDatabase.class,"VatTu.db").allowMainThreadQueries().build();
    }

    public void bntThemVatTu(View view) {
        VatTu vatTu = new VatTu();
        vatTu.id = new Random().nextInt();
        vatTu.MaVatTu = edMaVatTu.getText().toString();
        vatTu.TenVatTu = edTenVatTu.getText().toString();
        vatTu.ChiPhi = Double.valueOf(edChiPhi.getText().toString());

        if (db.vatTuDAO().insertND(vatTu)>0){
            Toast.makeText(getApplicationContext(),"Thêm thành công",Toast.LENGTH_SHORT).show();
        }
        Toast.makeText(getApplicationContext(),"Thêm thất bại",Toast.LENGTH_SHORT).show();
    }
}
