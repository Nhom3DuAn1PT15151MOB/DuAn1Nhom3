package com.example.quanlykhogao.adapter;

import android.content.Context;
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
import com.example.quanlykhogao.model.VatTu;
import com.example.quanlykhogao.sqlite.AppDatabase;

import java.util.List;

public class VatTuRecycleView extends RecyclerView.Adapter<VatTuViewHolder> {

    Context context;
    List<VatTu> vatTus;
    public VatTuRecycleView(Context context, List<VatTu> vatTus) {
        this.context = context;
        this.vatTus = vatTus;
    }
    @NonNull
    @Override
    public VatTuViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.item_vat_tu,parent,false);

        return new VatTuViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull VatTuViewHolder holder, int position) {
            final VatTu vatTu = vatTus.get(position);
            holder.tenVT.setText(vatTu.TenVatTu);
            holder.chiPhi.setText(String.valueOf(vatTu.ChiPhi));
            holder.deleteVT.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                   AppDatabase db = Room.databaseBuilder(context, AppDatabase.class,"VatTu.db").allowMainThreadQueries().build();
                    db.vatTuDAO().delete(vatTu);
                    Toast.makeText(context,"Đã Xóa ",Toast.LENGTH_SHORT).show();
                }
            });
    }

    @Override
    public int getItemCount() {
        return vatTus.size();
    }
}
class VatTuViewHolder extends RecyclerView.ViewHolder{
        TextView tenVT, chiPhi;
    ImageView deleteVT;
    public VatTuViewHolder(@NonNull View itemView) {
        super(itemView);
        tenVT = itemView.findViewById(R.id.tvTenVatTu);
        chiPhi = itemView.findViewById(R.id.tvGia);
        deleteVT = itemView.findViewById(R.id.deleteVatTu);
    }
}