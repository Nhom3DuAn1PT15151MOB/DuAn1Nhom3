package com.example.quanlykhogao;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.room.Room;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ListView;
import com.example.quanlykhogao.adapter.NguoiDungAdapter;
import com.example.quanlykhogao.model.NguoiDung;
import com.example.quanlykhogao.sqlite.AppDatabase;
import com.example.quanlykhogao.thread.NguoiDungQueryTask;
import java.util.List;

public class ListNguoiDungActivity extends AppCompatActivity {
    ListView listView;
    NguoiDungAdapter adapter;
    List<NguoiDung> nguoiDungList ;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_nguoi_dung);
        setTitle("Người Dùng");
        listView = findViewById(R.id.lvKhoGao);
        AppDatabase db = Room.databaseBuilder(getApplicationContext(), AppDatabase.class, "NguoiDung.db").allowMainThreadQueries().build();
        NguoiDungQueryTask nguoiDungQueryTask = new NguoiDungQueryTask(this);
        try {
           nguoiDungList = db.nguoiDungDAO().getAll();
           adapter = new NguoiDungAdapter(nguoiDungList, this);
           listView.setAdapter(adapter);
       }catch (Exception e){
            Log.e("ERR: ",""+e);
        }
        nguoiDungQueryTask.getAllNguoiDung(new NguoiDungQueryTask.OnQuery<List<NguoiDung>>() {
            @Override
            public void onResult(List<NguoiDung> nguoiDungs) {
                ListNguoiDungActivity.this.nguoiDungList.addAll(nguoiDungs);
                adapter.notifyDataSetChanged();
            }
        });
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
