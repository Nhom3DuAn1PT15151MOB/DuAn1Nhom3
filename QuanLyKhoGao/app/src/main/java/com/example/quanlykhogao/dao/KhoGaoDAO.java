package com.example.quanlykhogao.dao;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;


import com.example.quanlykhogao.model.KhoGao;

import java.util.List;

@Dao
public interface KhoGaoDAO {
    @Query("SELECT * FROM khogao")
    List<KhoGao> getAll();
    //them gao:
    @Insert
    public long[] insertGao(KhoGao... khoGao);
    //Xoa
    @Delete
    void delete (KhoGao khoGao);

}
