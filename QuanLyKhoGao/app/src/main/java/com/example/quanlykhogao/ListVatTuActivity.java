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
import com.example.quanlykhogao.adapter.VatTuRecycleView;
import com.example.quanlykhogao.model.VatTu;
import com.example.quanlykhogao.sqlite.AppDatabase;
import java.util.List;

public class ListVatTuActivity extends AppCompatActivity {
RecyclerView recyclerView ;
List<VatTu> vatTus;
VatTuRecycleView vatTuRecycleView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_vat_tu);
        setTitle("Vật Tư");
        recyclerView = findViewById(R.id.recyclerviewVT);
        AppDatabase db = Room.databaseBuilder(getApplicationContext(),AppDatabase.class,"VatTu").allowMainThreadQueries().build();
        vatTus = db.vatTuDAO().getAll();
        vatTuRecycleView = new VatTuRecycleView(this,vatTus);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(linearLayoutManager);
        recyclerView.setAdapter(vatTuRecycleView);

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
