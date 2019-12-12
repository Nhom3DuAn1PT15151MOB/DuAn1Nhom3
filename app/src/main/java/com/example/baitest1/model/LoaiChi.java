package com.example.baitest1.model;

import com.example.baitest1.fragment.fragmen_chi.FragmentDSLoaiChi;

public class LoaiChi {
    private String maLoaiChi;
    private String tenLoaiChi;

    public LoaiChi(String maLoaiChi, String tenLoaiChi) {
        this.maLoaiChi = maLoaiChi;
        this.tenLoaiChi = tenLoaiChi;
    }
    public LoaiChi(){

    }
    public LoaiChi(String tenLoaiChi) {
        this.tenLoaiChi = tenLoaiChi;
    }

    public String getmaLoaiChi() {
        return maLoaiChi;
    }

    public void setMaloaichi(String maloaichi) {
        maLoaiChi = maloaichi;
    }
    public String getTenloaichi() {
        return tenLoaiChi;
    }

    public void setTenloaichi(String tenloaichi) {
        tenLoaiChi = tenloaichi;
    }

    @Override
    public String toString() {
        return "Mã: "+ maLoaiChi + "        tên:" + tenLoaiChi;
    }
}
