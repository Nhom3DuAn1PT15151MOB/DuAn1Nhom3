package com.example.baitest1.model;

public class KhoanChi {
    private String maKC;
    private String mLC;
    private String tenKC;
    private String sotien;
    private String ngayChi;

    public KhoanChi(String maKC, String mLC, String tenKC, String sotien, String ngayChi) {
        this.maKC = maKC;
        this.mLC = mLC;
        this.tenKC = tenKC;
        this.sotien = sotien;
        this.ngayChi = ngayChi;
    }

    public KhoanChi(String tenKC, String sotien, String ngayChi) {
        this.tenKC = tenKC;
        this.sotien = sotien;
        this.ngayChi = ngayChi;
    }

    public KhoanChi() {

    }

    public String getMaKC() {
        return maKC;
    }

    public void setMaKC(String maKC) {
        this.maKC = maKC;
    }

    public String getmLC() {
        return mLC;
    }

    public void setmLC(String mLC) {
        this.mLC = mLC;
    }

    public String getTenKC() {
        return tenKC;
    }

    public void setTenKC(String tenKC) {
        this.tenKC = tenKC;
    }

    public String getSotien() {
        return sotien;
    }

    public void setSotien(String sotien) {
        this.sotien = sotien;
    }

    public String getNgayChi() {
        return ngayChi;
    }

    public void setNgayChi(String ngayChi) {
        this.ngayChi = ngayChi;
    }

    @Override
    public String toString() {
        return "mã: "+ maKC+"     tên:"+ tenKC + "  Số tiền:" + sotien;
    }
}
