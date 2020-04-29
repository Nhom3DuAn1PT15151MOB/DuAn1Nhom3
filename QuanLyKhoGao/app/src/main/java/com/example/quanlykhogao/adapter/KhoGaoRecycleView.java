package com.example.quanlykhogao.adapter;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import androidx.room.Room;

import com.example.quanlykhogao.R;
import com.example.quanlykhogao.dao.NguoiDungDAO;
import com.example.quanlykhogao.model.KhoGao;
import com.example.quanlykhogao.sqlite.AppDatabase;

import java.util.List;

public class KhoGaoRecycleView extends RecyclerView.Adapter<ViewHolder> {
    private Context context;
    private List<KhoGao> khoGaos;

    public KhoGaoRecycleView(Context context, List<KhoGao> khoGaos) {
        this.context = context;
        this.khoGaos = khoGaos;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.item_kho_gao, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull final ViewHolder holder, int position) {
        final KhoGao khoGao = khoGaos.get(position);
        holder.tenLua.setText(khoGao.TenGao);
        holder.NCC.setText(khoGao.NhaCungCap);
        Log.e("Infor KHOGAO",""+ holder.tenLua+" ,"+ holder.NCC);
        holder.imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AppDatabase db = Room.databaseBuilder(context, AppDatabase.class, "KhoGao.db").allowMainThreadQueries().build();
                db.khoGaoDAO().delete(khoGao);
                Toast.makeText(context,"Đã xóa",Toast.LENGTH_SHORT).show();
            }
        });
    }

    @Override
    public int getItemCount() {
        return khoGaos.size();
    }
}

class ViewHolder extends RecyclerView.ViewHolder {
    TextView tenLua, NCC;
    ImageView imageView;

    public ViewHolder(@NonNull View itemView) {
        super(itemView);
        tenLua = itemView.findViewById(R.id.tvTenLua);
        NCC = itemView.findViewById(R.id.tvNCC);
        imageView = itemView.findViewById(R.id.deleteLua);
    }
}
