package com.example.quanlykhogao.model;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "KhoGao")
public class KhoGao {
    @PrimaryKey
    public int id;
    @ColumnInfo (name = "MaLoaiGao")
    public String MaLoaiGao;
    @ColumnInfo (name = "TenGao")
    public String TenGao;
    @ColumnInfo (name = "NhaCungCap")
    public String NhaCungCap;
    @ColumnInfo (name = "Gia")
    public Double Gia;
    @ColumnInfo (name = "SoLuong")
    public int SoLuong;
    @ColumnInfo (name = "DonVi")
    public String DonVi;

}
