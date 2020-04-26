package com.example.quanlykhogao;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.room.Room;

import android.annotation.SuppressLint;
import android.app.AlertDialog;
import android.app.Person;
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
import com.example.quanlykhogao.thread.NguoiDungQueryTask;

import java.util.Random;

public class NguoiDungActivity extends AppCompatActivity {
    EditText edNam, edphone, edpassWor, edRePassWord;
    AppDatabase db;
    CheckBox checkBox;
    NguoiDungQueryTask nguoiDungQueryTask;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_nguoi_dung);
        setTitle("Đăng Ký");
        db = Room.databaseBuilder(getApplicationContext(),
                AppDatabase.class, "NguoiDung.db").allowMainThreadQueries().build();
        edNam = findViewById(R.id.editHoTen);
        edphone = findViewById(R.id.editPhone);
        edpassWor = findViewById(R.id.editPassWord);
        edRePassWord = findViewById(R.id.editRePassWord);
        checkBox = findViewById(R.id.checkboxDK);
nguoiDungQueryTask = new NguoiDungQueryTask(this);

    }
public boolean checkBox(){
        if (checkBox.isChecked())
            return true;
        return false;
}

    @SuppressLint("ResourceAsColor")
    public boolean valiDateForm(){
        String pass = edpassWor.getText().toString();
        String rePass = edRePassWord.getText().toString();
        if (edphone.getText().toString().length() > 10 || edphone.getText().toString().length() < 8) {
            Toast.makeText(this, " Số điện thoại không hợp lệ", Toast.LENGTH_SHORT).show();
            edphone.setBackgroundColor(R.color.red);
            return false;
        }

        else if (edNam.getText().toString().isEmpty()) {
            Toast.makeText(this, "Trường tên không được để trống", Toast.LENGTH_SHORT).show();
            edNam.setBackgroundColor(R.color.red);
            return false;
        }

        else if (edpassWor.getText().toString().length() < 8) {
            Toast.makeText(this, "Mật khẩu phải trên 8 ký tự", Toast.LENGTH_SHORT).show();
            edpassWor.setBackgroundColor(R.color.red);
            return false;
        }
        else if (checkBox()==false) {
            Toast.makeText(getApplicationContext(),"Bạn cần đòng ý với các điều khoản",Toast.LENGTH_LONG).show();
        }
        else{
            return true;
        }
        return valiDateForm();
    }
    public void dangKy(View view) {
        if (valiDateForm()==false){

        }
            else {
                NguoiDung nguoiDung = new NguoiDung();
                nguoiDung.id = new Random().nextInt();
                nguoiDung.TenNguoiDung = edNam.getText().toString();
                nguoiDung.phone = edphone.getText().toString();
                nguoiDung.passWord = edpassWor.getText().toString();
                nguoiDungQueryTask.insertNguoiDung(new NguoiDungQueryTask.OnQuery<long[]>() {
                    @Override
                    public void onResult(long[] longs) {
                    }
                }, nguoiDung);
                long[] result = db.nguoiDungDAO().insertND(nguoiDung);
                if (result[0] > 0) {
                    Toast.makeText(getApplicationContext(), "Đăng ký thành công", Toast.LENGTH_SHORT).show();

                } else {
                    Toast.makeText(getApplicationContext(), "Thất bại", Toast.LENGTH_SHORT).show();
                }
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
