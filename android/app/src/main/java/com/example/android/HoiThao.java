package com.example.android;

public class HoiThao {
    private String maHt;
    private String diaChi;
    private String thoiGian;
    private String ngayThang;
    private String dienGia;
    private String tenDoanhNghiep;

    public HoiThao(String maHt, String diaChi, String thoiGian, String ngayThang, String dienGia, String tenDoanhNghiep) {
        this.maHt = maHt;
        this.diaChi = diaChi;
        this.thoiGian = thoiGian;
        this.ngayThang = ngayThang;
        this.dienGia = dienGia;
        this.tenDoanhNghiep = tenDoanhNghiep;
    }

    public String getMaHt() {
        return maHt;
    }

    public void setMaHt(String maHt) {
        this.maHt = maHt;
    }

    public String getDiaChi() {
        return diaChi;
    }

    public void setDiaChi(String diaChi) {
        this.diaChi = diaChi;
    }

    public String getThoiGian() {
        return thoiGian;
    }

    public void setThoiGian(String thoiGian) {
        this.thoiGian = thoiGian;
    }

    public String getNgayThang() {
        return ngayThang;
    }

    public void setNgayThang(String ngayThang) {
        this.ngayThang = ngayThang;
    }

    public String getDienGia() {
        return dienGia;
    }

    public void setDienGia(String dienGia) {
        this.dienGia = dienGia;
    }

    public String getTenDoanhNghiep() {
        return tenDoanhNghiep;
    }

    public void setTenDoanhNghiep(String tenDoanhNghiep) {
        this.tenDoanhNghiep = tenDoanhNghiep;
    }
}
