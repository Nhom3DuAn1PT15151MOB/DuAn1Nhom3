package com.example.quanlykhogao;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.room.Room;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Toast;

import com.example.quanlykhogao.model.NguoiDung;
import com.example.quanlykhogao.sqlite.AppDatabase;

import java.util.Random;

public class NguoiDungActivity extends AppCompatActivity {
    EditText edNam, edphone, edpassWor, edRePassWord;
    AppDatabase db;
    CheckBox checkBox;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_nguoi_dung);
        db = Room.databaseBuilder(getApplicationContext(),
                AppDatabase.class, "NguoiDung.db").allowMainThreadQueries().build();
        edNam = findViewById(R.id.editHoTen);
        edphone = findViewById(R.id.editPhone);
        edpassWor = findViewById(R.id.editPassWord);
        edRePassWord = findViewById(R.id.editRePassWord);
        checkBox = findViewById(R.id.checkboxDK);
    }
public boolean checkBox(){
        if (checkBox.isChecked())
            return true;
        return false;
}
    public void dangKy(View view) {
        if (checkBox()) {
            NguoiDung nguoiDung = new NguoiDung();
            nguoiDung.id = new Random().nextInt();
            nguoiDung.TenNguoiDung = edNam.getText().toString();
            nguoiDung.phone = Integer.valueOf(edphone.getText().toString());
            nguoiDung.passWord = edpassWor.getText().toString();
            if (db.nguoiDungDAO().insertND(nguoiDung) > 0) {
                Toast.makeText(getApplicationContext(), "Insert thành công", Toast.LENGTH_SHORT).show();
            } else {
                Toast.makeText(getApplicationContext(), "Thất bại", Toast.LENGTH_SHORT).show();
            }
        }else {
            Toast.makeText(getApplicationContext(),"Bạn cần đòng ý với các điều khoản",Toast.LENGTH_LONG).show();
        }
    }

    public void huy(View view) {
        finish();
    }

    public void dieuKhoan(View view) {
        Intent intent = new Intent(this,DieuKhoanActivity.class);
        startActivity(intent);
    }
}
