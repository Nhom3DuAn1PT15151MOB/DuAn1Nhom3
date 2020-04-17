package com.example.quanlykhogao;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.room.Room;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.example.quanlykhogao.model.NguoiDung;
import com.example.quanlykhogao.sqlite.AppDatabase;

import java.util.List;

public class ListNguoiDungActivity extends AppCompatActivity {
    ListView listView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_nguoi_dung);
        listView = findViewById(R.id.lvNguoiDung);
        AppDatabase db = Room.databaseBuilder(getApplicationContext(), AppDatabase.class,"NguoiDung.db").allowMainThreadQueries().build();
        List<NguoiDung> nguoiDungList = db.nguoiDungDAO().getAll();
        ArrayAdapter adapter = new ArrayAdapter(this,android.R.layout.simple_list_item_1,nguoiDungList);
        listView.setAdapter(adapter);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
       getMenuInflater().inflate(R.menu.menu_nguoidung,menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()){
            case R.id.menuThemNguoiDung:
                Intent intent = new Intent(this,NguoiDungActivity.class);
                startActivity(intent);
            case R.id.menuHuy:
                finish();
        }
        return super.onOptionsItemSelected(item);
    }

    public void imgSua(View view) {
    }

    public void imgXoa(View view) {
    }
}
