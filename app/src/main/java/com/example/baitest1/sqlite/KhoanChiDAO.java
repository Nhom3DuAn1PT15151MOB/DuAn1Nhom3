package com.example.baitest1.sqlite;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.example.baitest1.model.KhoanChi;

import java.util.ArrayList;
import java.util.List;

public class KhoanChiDAO {
    private Context context;
    private SQLiteDatabase db;
    private DatabaseHelper helper;
    public KhoanChiDAO(Context context) {
        this.context = context;
        helper = new DatabaseHelper(context);
        db = helper.getWritableDatabase();
    }
    public  boolean insertKhoanChi(KhoanChi khoanchi) {
        try {
            ContentValues values = new ContentValues();
            values.put("Makhoanchi", khoanchi.getMaKC());
            values.put("Maloaichi",khoanchi.getmLC());
            values.put("Tenkhoanchi", khoanchi.getTenKC());
            values.put("sotien",khoanchi.getSotien());
            values.put("ngaychi",khoanchi.getNgayChi());
            long numInsert = db.insert("Khoanchi",null,values);
            if(numInsert<=0)
                return false;
        }catch (Exception ex){
            ex.printStackTrace();
            return false;
        }
        return true;
    }
    public  List<KhoanChi> showListKC(){
        List<KhoanChi> khoanChiList = new ArrayList<>();
        String select = "SELECT Makhoanchi, Tenkhoanchi,sotien FROM Khoanchi";
        Cursor cursor = db.rawQuery(select,null);
        cursor.moveToFirst();
        while (!cursor.isAfterLast()){
            String Makhoanchi = cursor.getString(0);
            String Tenkhoanchi = cursor.getString(1);
            String sotien = cursor.getString(2);

            KhoanChi khoanChi = new KhoanChi();
            khoanChi.setMaKC(Makhoanchi);
            khoanChi.setTenKC(Tenkhoanchi);
            khoanChi.setSotien(sotien);

            khoanChiList.add(khoanChi);
            cursor.moveToNext();
        }
        return khoanChiList;
    }
    public boolean suaKhoanChi( String dk1, KhoanChi khoanChi) {
        ContentValues values = new ContentValues();
        values.put("Tenkhoanchi", khoanChi.getTenKC());
        values.put("sotien", khoanChi.getSotien());
        values.put("ngaychi", khoanChi.getNgayChi());
        long suaKC= db.update("Khoanchi",values,"Makhoanchi=?", new String[]{dk1});
        if (suaKC<=0)
            return false;
        return true;
    }
    public boolean xoaKhoanChi(String dk){
        long xoaKC = db.delete("Khoanchi","Makhoanchi=?", new String[]{dk});
        if (xoaKC<=0)
            return false;
        return true;
    }
}
