package com.example.quanlykhogao.model;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "nguoidung")
public class NguoiDung {
    @PrimaryKey
    public int id;
    @ColumnInfo (name = "tenNguoiDung")
    public String TenNguoiDung;

    @ColumnInfo (name = "phone")
    public String phone;

    @ColumnInfo (name = "password")
    public String passWord;


}
