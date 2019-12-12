package com.example.baitest1.model;

public class KhoanThu {
    private String maKhoanThu;
    private String maLoaiThu;
    private String tenKhoanthu;
    private String soTienThu;
    private String ngayThu;

    public KhoanThu(String maKhoanThu, String maLoaiThu, String tenKhoanthu, String soTienThu, String ngayThu) {
        this.maKhoanThu = maKhoanThu;
        this.maLoaiThu = maLoaiThu;
        this.tenKhoanthu = tenKhoanthu;
        this.soTienThu = soTienThu;
        this.ngayThu = ngayThu;
    }

    public String getMaKhoanThu() {
        return maKhoanThu;
    }

    public void setMaKhoanThu(String maKhoanThu) {
        this.maKhoanThu = maKhoanThu;
    }

    public String getMaLoaiThu() {
        return maLoaiThu;
    }

    public void setMaLoaiThu(String maLoaiThu) {
        this.maLoaiThu = maLoaiThu;
    }

    public String getTenKhoanthu() {
        return tenKhoanthu;
    }

    public void setTenKhoanthu(String tenKhoanthu) {
        this.tenKhoanthu = tenKhoanthu;
    }

    public String getSoTienThu() {
        return soTienThu;
    }

    public void setSoTienThu(String soTienThu) {
        this.soTienThu = soTienThu;
    }

    public String getNgayThu() {
        return ngayThu;
    }

    public void setNgayThu(String ngayThu) {
        this.ngayThu = ngayThu;
    }

    @Override
    public String toString() {
        return "tenKhoanthu='" + tenKhoanthu + '\'' +
                ", soTienThu='" + soTienThu + '\'' +
                '}';
    }
}
