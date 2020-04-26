package com.example.quanlykhogao.dao;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;

import com.example.quanlykhogao.model.VatTu;

import java.util.List;

@Dao
public interface VatTuDAO {
    @Query("SELECT * FROM vattu")
    List <VatTu> getAll();
    //them Vật tu:
    @Insert
    public long[] insertVatTu (VatTu... vatTu);
    //Xoa
    @Delete
    void delete (VatTu vatTu);
}
