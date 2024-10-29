package com.example.android;

public class SinhVienHoiThao {
    private String maSv;
    private String hoTen;
    private String khoa;
    private String danhGia;

    public SinhVienHoiThao(String maSv, String hoTen, String khoa, String danhGia) {
        this.maSv = maSv;
        this.hoTen = hoTen;
        this.khoa = khoa;
        this.danhGia = danhGia;
    }

    public String getMaSv() {
        return maSv;
    }

    public void setMaSv(String maSv) {
        this.maSv = maSv;
    }

    public String getHoTen() {
        return hoTen;
    }

    public void setHoTen(String hoTen) {
        this.hoTen = hoTen;
    }

    public String getKhoa() {
        return khoa;
    }

    public void setKhoa(String khoa) {
        this.khoa = khoa;
    }

    public String getDanhGia() {
        return danhGia;
    }

    public void setDanhGia(String danhGia) {
        this.danhGia = danhGia;
    }
}
