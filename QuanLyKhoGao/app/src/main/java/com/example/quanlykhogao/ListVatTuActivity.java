package com.example.quanlykhogao;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.room.Room;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.example.quanlykhogao.adapter.VatTuAdapter;
import com.example.quanlykhogao.model.VatTu;
import com.example.quanlykhogao.sqlite.AppDatabase;

import java.util.List;

public class ListVatTuActivity extends AppCompatActivity {
ListView listView ;
VatTuAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_vat_tu);
        setTitle("Vật Tư");
        listView = findViewById(R.id.lvVatTu);
        AppDatabase db = Room.databaseBuilder(getApplicationContext(),AppDatabase.class,"VatTu").allowMainThreadQueries().build();
        List<VatTu> vatTuList = db.vatTuDAO().getAll();
        adapter = new VatTuAdapter(vatTuList,ListVatTuActivity.this);
        listView.setAdapter(adapter);

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_vattu,menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()){
            case R.id.menuVatTu:
                Intent intent = new Intent(this,VatTuActivity.class);
                startActivity(intent);
            case R.id.menuHuyVT:
                finish();
        }
        return super.onOptionsItemSelected(item);
    }
}
