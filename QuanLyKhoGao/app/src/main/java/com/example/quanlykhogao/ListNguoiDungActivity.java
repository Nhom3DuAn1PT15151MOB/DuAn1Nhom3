package com.example.quanlykhogao;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.room.Room;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;
import com.example.quanlykhogao.adapter.NguoiDungRecycleView;
import com.example.quanlykhogao.model.NguoiDung;
import com.example.quanlykhogao.sqlite.AppDatabase;
import java.util.List;

public class ListNguoiDungActivity extends AppCompatActivity {
    RecyclerView recyclerView;
    NguoiDungRecycleView adapter;
    List<NguoiDung> nguoiDungList ;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_nguoi_dung);
        setTitle("Người Dùng");
        recyclerView = findViewById(R.id.recycleview);
        AppDatabase db = Room.databaseBuilder(getApplicationContext(), AppDatabase.class, "NguoiDung.db").allowMainThreadQueries().build();
        nguoiDungList = db.nguoiDungDAO().getAll();
       try {
           adapter = new NguoiDungRecycleView(this, nguoiDungList);
           LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
           recyclerView.setLayoutManager(linearLayoutManager);
           recyclerView.setAdapter(adapter);
       }catch (Exception e){
           Log.e("ERR",""+e);
       }
       int size = nguoiDungList.size();
        Toast.makeText(getApplicationContext(),""+size,Toast.LENGTH_SHORT).show();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_nguoidung, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()) {
            case R.id.menuThemNguoiDung:
                Intent intent = new Intent(this, NguoiDungActivity.class);
                startActivity(intent);
            case R.id.menuHuy:
                finish();
        }
        return super.onOptionsItemSelected(item);
    }

}
