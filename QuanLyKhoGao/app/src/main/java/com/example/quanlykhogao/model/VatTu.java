package com.example.quanlykhogao.model;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "VatTu")
public class VatTu {
    @PrimaryKey
    public int id;
    @ColumnInfo (name = "MaVatTu")
    public String MaVatTu;
    @ColumnInfo (name = "TenVatTu")
    public String TenVatTu;
    @ColumnInfo(name = "ChiPhi")
    public Double ChiPhi;
}
