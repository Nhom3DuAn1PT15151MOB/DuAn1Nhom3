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
import com.example.quanlykhogao.sqlite.AppDatabase;
import java.util.List;

public class KhoGaoAdapter extends BaseAdapter {
    AppDatabase db;
    List<KhoGao> arrGao ;
    public Activity context;
    public LayoutInflater inflater;

    public KhoGaoAdapter(List<KhoGao> arrGao, Activity context) {
        this.arrGao = arrGao;
        this.context = context;
        this.inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);

    }

    @Override
    public int getCount() {
        return arrGao.size();
    }

    @Override
    public Object getItem(int position) {
        return arrGao.get(position);
    }

    @Override
    public long getItemId(int position) {
        return arrGao.size();
    }
    public static class ViewHolder {
        ImageView img;
        TextView txtTenGao;
        TextView txtNCC;
        ImageView imgDelete;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        db = Room.databaseBuilder(context, AppDatabase.class, "KhoGao.db").allowMainThreadQueries().build();
        KhoGaoAdapter.ViewHolder holder = null;
        final KhoGao khoGao = (KhoGao) arrGao.get(position);
        if(convertView == null) {
            holder = new KhoGaoAdapter.ViewHolder();
            convertView = inflater.inflate(R.layout.item_kho_gao, null);
            holder.img = convertView.findViewById(R.id.ivIcon);
            holder.txtTenGao = convertView.findViewById(R.id.tvTenLua);
            holder.txtNCC = convertView.findViewById(R.id.tvNCC);
            holder.imgDelete = convertView.findViewById(R.id.deleteLua);
            holder.imgDelete.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    db.khoGaoDAO().delete(khoGao);
                    arrGao.remove(khoGao);
                    notifyDataSetChanged();
                }
            });
            holder.img.setImageResource(R.drawable.emone);
            convertView.setTag(holder);
        }else {
            holder.txtTenGao.setText(khoGao.TenGao);
            holder.txtNCC.setText(khoGao.NhaCungCap);
            holder.imgDelete.setImageResource(R.drawable.icon_delete);
        }
        return convertView;

    }
}
