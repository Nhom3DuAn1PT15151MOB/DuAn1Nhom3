package com.example.quanlykhogao;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.room.Room;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ListView;
import com.example.quanlykhogao.adapter.KhoGaoAdapter;
import com.example.quanlykhogao.model.KhoGao;
import com.example.quanlykhogao.sqlite.AppDatabase;
import java.util.List;

public class ListKhoGaoActivity extends AppCompatActivity {
ListView listView ;
KhoGaoAdapter adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setTitle("Kho Gạo");
        setContentView(R.layout.activity_list_kho_gao);
        listView = findViewById(R.id.lvKhoGao);
        AppDatabase db = Room.databaseBuilder(getApplicationContext(),AppDatabase.class,"KhoGao.db").allowMainThreadQueries().build();
        List<KhoGao> khoGaos = db.khoGaoDAO().getAll();
        adapter = new KhoGaoAdapter(khoGaos,ListKhoGaoActivity.this);
        listView.setAdapter(adapter);

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
