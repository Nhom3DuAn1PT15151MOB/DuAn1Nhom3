package com.example.quanlykhogao.sqlite;

import androidx.room.Database;
import androidx.room.RoomDatabase;

import com.example.quanlykhogao.dao.KhoGaoDAO;
import com.example.quanlykhogao.dao.NguoiDungDAO;
import com.example.quanlykhogao.dao.VatTuDAO;
import com.example.quanlykhogao.model.KhoGao;
import com.example.quanlykhogao.model.NguoiDung;
import com.example.quanlykhogao.model.VatTu;

@Database(entities = {KhoGao.class, NguoiDung.class, VatTu.class}, version = 6)
public abstract class AppDatabase extends RoomDatabase {
    public abstract NguoiDungDAO nguoiDungDAO();
    public abstract KhoGaoDAO khoGaoDAO();
    public abstract VatTuDAO vatTuDAO();
}
