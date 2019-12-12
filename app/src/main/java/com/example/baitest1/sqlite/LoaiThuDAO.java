package com.example.baitest1.sqlite;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.example.baitest1.model.LoaiThu;

import java.util.ArrayList;
import java.util.List;

public class LoaiThuDAO {
    private DatabaseHelper helper;
    private SQLiteDatabase db;

    public LoaiThuDAO(Context context) {
        helper = new DatabaseHelper(context);
        db = helper.getWritableDatabase();
    }

    public boolean insertLoaiThu(LoaiThu loaiThu) {
        ContentValues values = new ContentValues();
        values.put("Maloaithu", loaiThu.getMaLoaiThu());
        values.put("Tenloaithu", loaiThu.getTenLoaiThu());
        long numInsert = db.insert("Loaithu", null, values);
        if (numInsert <= 0)
            return false;
        return true;
    }

    public List<LoaiThu> showLoaiThu() {
        List<LoaiThu> loaiThus = new ArrayList<>();
        String sql = "SELECT Maloaithu,Tenloaithu FROM Loaithu";
        Cursor cursor = db.rawQuery(sql, null);
        cursor.moveToFirst();
        while (!cursor.isAfterLast()) {
            String mlt = cursor.getString(0);
            String tlt = cursor.getString(1);
            LoaiThu loaiThu = new LoaiThu(mlt, tlt);
            loaiThus.add(loaiThu);
            cursor.moveToNext();
        }
        return loaiThus;
    }
}
