package com.example.quanlykhogao;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.room.Room;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import com.example.quanlykhogao.adapter.KhoGaoRecycleView;
import com.example.quanlykhogao.model.KhoGao;
import com.example.quanlykhogao.sqlite.AppDatabase;
import java.util.List;

public class ListKhoGaoActivity extends AppCompatActivity {

RecyclerView  recyclerView;
List<KhoGao> khoGaos;
KhoGaoRecycleView khoGaoRecycleView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setTitle("Kho Gạo");
        setContentView(R.layout.activity_list_kho_gao);
        recyclerView = findViewById(R.id.recycleview);
        AppDatabase db = Room.databaseBuilder(getApplicationContext(),AppDatabase.class,"KhoGao.db").allowMainThreadQueries().build();
        khoGaos = db.khoGaoDAO().getAll();
        khoGaoRecycleView = new KhoGaoRecycleView(this,khoGaos);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(linearLayoutManager);
        recyclerView.setAdapter(khoGaoRecycleView);


    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_gao,menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()){
            case R.id.menuThemGao:
                Intent intent = new Intent(this,KhoGaoActivity.class);
                startActivity(intent);
            case R.id.menuHuyGao:
                finish();
        }
        return super.onOptionsItemSelected(item);
    }
}
