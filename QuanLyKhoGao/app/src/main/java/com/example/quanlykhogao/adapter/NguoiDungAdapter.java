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
import com.example.quanlykhogao.model.NguoiDung;
import com.example.quanlykhogao.sqlite.AppDatabase;

import java.util.List;

public class NguoiDungAdapter extends BaseAdapter {
    AppDatabase db;
    List<NguoiDung> arrNguoiDung ;
    public Activity context;
    public LayoutInflater inflater;
    public NguoiDungAdapter(List<NguoiDung> arrNguoiDung, Activity context) {
        this.arrNguoiDung = arrNguoiDung;
        this.context = context;
        this.inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);

        }
    @Override
    public int getCount() {
        return arrNguoiDung.size();
    }

    @Override
    public Object getItem(int position) {
        return arrNguoiDung.get(position);
    }

    @Override
    public long getItemId(int position) {
        return arrNguoiDung.size();
    }

    public static class ViewHolder {
        ImageView img;
        TextView txtName;
        TextView txtPhone;
        ImageView imgDelete;
    }

    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {
        db = Room.databaseBuilder(context, AppDatabase.class, "NguoiDung.db").allowMainThreadQueries().build();
        ViewHolder holder = null;
        final NguoiDung nguoiDung = (NguoiDung) arrNguoiDung.get(position);
        if(convertView == null) {
            holder = new ViewHolder();
            convertView = inflater.inflate(R.layout.item_nguoi_dung, null);
            holder.img = convertView.findViewById(R.id.ivIcon);
            holder.txtName = convertView.findViewById(R.id.tvTenNguoiDung);
            holder.txtPhone = convertView.findViewById(R.id.tvPhone);
            holder.imgDelete = convertView.findViewById(R.id.icIconDelete);
            holder.imgDelete.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                 db.nguoiDungDAO().delete(nguoiDung);
                 arrNguoiDung.remove(nguoiDung);
                 notifyDataSetChanged();
                }
            });
            holder.img.setImageResource(R.drawable.emone);
            convertView.setTag(holder);
        }else {
            holder.txtName.setText(nguoiDung.TenNguoiDung);
            holder.txtPhone.setText(nguoiDung.phone);
            holder.imgDelete.setImageResource(R.drawable.icon_delete);
        }
        return convertView;
    }
    @Override
    public void notifyDataSetChanged() {
        super.notifyDataSetChanged();
    }
}
