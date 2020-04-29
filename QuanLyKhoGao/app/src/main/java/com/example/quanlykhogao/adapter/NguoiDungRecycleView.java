package com.example.quanlykhogao.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import androidx.room.Room;

import com.example.quanlykhogao.R;
import com.example.quanlykhogao.model.NguoiDung;
import com.example.quanlykhogao.sqlite.AppDatabase;

import java.util.List;

public class NguoiDungRecycleView extends RecyclerView.Adapter<NguoiDungViewHolder> {
    Context context;
    List<NguoiDung> nguoiDungs;

    public NguoiDungRecycleView(Context context, List<NguoiDung> nguoiDungs) {
        this.context = context;
        this.nguoiDungs = nguoiDungs;
    }

    @NonNull
    @Override
    public NguoiDungViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.item_nguoi_dung,parent,false);
        return new NguoiDungViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull NguoiDungViewHolder holder, int position) {
        final NguoiDung nguoiDung = nguoiDungs.get(position);
        holder.tenNguoiDung.setText(nguoiDung.TenNguoiDung);
        holder.phone.setText(nguoiDung.phone);
        holder.delete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AppDatabase db = Room.databaseBuilder(context,AppDatabase.class,"NguoiDung.db").allowMainThreadQueries().build();
                db.nguoiDungDAO().delete(nguoiDung);
            }
        });
    }

    @Override
    public int getItemCount() {
        return nguoiDungs.size();
    }
}
class NguoiDungViewHolder extends RecyclerView.ViewHolder{
    TextView tenNguoiDung, phone;
    ImageView delete;
    public NguoiDungViewHolder(@NonNull View itemView) {
        super(itemView);
        tenNguoiDung = itemView.findViewById(R.id.tvTenNguoiDung);
        phone = itemView.findViewById(R.id.tvPhone);
        delete = itemView.findViewById(R.id.icIconDelete);
    }
}