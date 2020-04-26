package com.example.quanlykhogao.adapter;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.room.Room;

import com.example.quanlykhogao.R;
import com.example.quanlykhogao.model.KhoGao;
import com.example.quanlykhogao.model.VatTu;
import com.example.quanlykhogao.sqlite.AppDatabase;

import java.util.List;

public class VatTuAdapter extends BaseAdapter {
    AppDatabase db;
    List<VatTu> arrVatTu;
    public Activity context;
    public LayoutInflater inflater;

    public VatTuAdapter(List<VatTu> arrVatTu, Activity context) {
        this.arrVatTu = arrVatTu;
        this.context = context;
        this.inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    @Override
    public int getCount() {
        return arrVatTu.size();
    }

    @Override
    public Object getItem(int position) {
        return arrVatTu.get(position);
    }

    @Override
    public long getItemId(int position) {
        return arrVatTu.size();
    }

    public static class ViewHolder {
        ImageView img;
        TextView txtTen;
        TextView txtGia;
        ImageView imgDelete;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        db = Room.databaseBuilder(context, AppDatabase.class, "VatTu.db").allowMainThreadQueries().build();
        VatTuAdapter.ViewHolder holder = null;
        final VatTu vatTu = arrVatTu.get(position);
        if (convertView == null) {
            holder = new VatTuAdapter.ViewHolder();
            convertView = inflater.inflate(R.layout.item_vat_tu, null);
            holder.img = convertView.findViewById(R.id.ivIconVT);
            holder.txtTen = convertView.findViewById(R.id.tvTenVatTu);
            holder.txtGia = convertView.findViewById(R.id.tvGia);
            holder.imgDelete = convertView.findViewById(R.id.deleteVatTu);
            holder.imgDelete.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    db.vatTuDAO().delete(vatTu);
                    arrVatTu.remove(vatTu);
                    notifyDataSetChanged();
                }
            });
            holder.img.setImageResource(R.drawable.emone);
            convertView.setTag(holder);
        } else {
            holder.txtTen.setText(vatTu.TenVatTu);
            holder.txtGia.setText(String.valueOf(vatTu.ChiPhi));
            holder.imgDelete.setImageResource(R.drawable.icon_delete);
        }
        return convertView;
    }
}
