package com.example.quanlykhogao.sqlite;

import androidx.room.Database;
import androidx.room.RoomDatabase;

import com.example.quanlykhogao.dao.NguoiDungDAO;
import com.example.quanlykhogao.model.NguoiDung;

@Database(entities = {NguoiDung.class},version = 1)
public abstract class AppDatabase extends RoomDatabase {
    public abstract NguoiDungDAO nguoiDungDAO();
}
