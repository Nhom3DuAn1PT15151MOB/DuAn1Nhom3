package com.example.quanlykhogao.dao;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;

import com.example.quanlykhogao.model.NguoiDung;

import java.util.List;
@Dao
public interface NguoiDungDAO {
    @Query("SELECT * FROM NguoiDung")
    List<NguoiDung> getAll();
    //them nguoi dung:
    @Insert
    public long[] insertND (NguoiDung... nguoiDung);
    //Xoa
    @Delete
    void delete (NguoiDung nguoiDung);
}
