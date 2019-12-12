package com.example.baitest1.sqlite;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.example.baitest1.model.LoaiChi;


import java.util.ArrayList;
import java.util.List;

public class LoaiChiDAO {
    private SQLiteDatabase db;

    private DatabaseHelper helper;

    public LoaiChiDAO(Context context) {
        helper = new DatabaseHelper(context);
        db = helper.getWritableDatabase();
    }

    public boolean insertLoaiChi(LoaiChi loaiChi) {
        try {
            ContentValues values = new ContentValues();
            values.put("Maloaichi", loaiChi.getmaLoaiChi());
            values.put("Tenloaichi", loaiChi.getTenloaichi());
            long numInsert = db.insert("Loaichi", null, values);
            if (numInsert <= 0)
                return false;
        } catch (Exception ex) {
            ex.printStackTrace();
            return false;
        }
        return true;
    }

    public List<LoaiChi> showListLC() {
        List<LoaiChi> loaiChis = new ArrayList<>();
        String sql = "SELECT * FROM Loaichi";
        try {
            Cursor cursor = db.rawQuery(sql, null);
            cursor.moveToFirst();
            while (!cursor.isAfterLast()) {
                String mlc = cursor.getString(0);
                String tlc = cursor.getString(1);
                LoaiChi loaiChi = new LoaiChi(mlc, tlc);
                loaiChis.add(loaiChi);
                cursor.moveToNext();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return loaiChis;
    }

    public boolean deleteLoaichi(String dk) {
            long xoa = db.delete("Loaichi","Maloaichi=?", new String[]{dk});
            if (xoa<=0)
                return false;
            return true;
    }

    public boolean suaLoaiChi(String dk, LoaiChi loaiChi) {
        ContentValues values = new ContentValues();
        values.put("Tenloaichi", loaiChi.getTenloaichi());
        long suaLC = db.update("Loaichi", values, "Maloaichi=?", new String[]{dk});
        if (suaLC <= 0)
            return false;
        return true;

    }
}
