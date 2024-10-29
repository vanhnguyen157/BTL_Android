package com.example.android;

public class ThienNguyen {
    private String maTn;
    private String tenTn;
    private String ngayThang;
    private String thoiGian;
    private String diaChi;

    public ThienNguyen(String maTn, String tenTn, String ngayThang, String thoiGian, String diaChi) {
        this.maTn = maTn;
        this.tenTn = tenTn;
        this.ngayThang = ngayThang;
        this.thoiGian = thoiGian;
        this.diaChi = diaChi;
    }

    public String getMaTn() {
        return maTn;
    }

    public void setMaTn(String maTn) {
        this.maTn = maTn;
    }

    public String getTenTn() {
        return tenTn;
    }

    public void setTenTn(String tenTn) {
        this.tenTn = tenTn;
    }

    public String getNgayThang() {
        return ngayThang;
    }

    public void setNgayThang(String ngayThang) {
        this.ngayThang = ngayThang;
    }

    public String getThoiGian() {
        return thoiGian;
    }

    public void setThoiGian(String thoiGian) {
        this.thoiGian = thoiGian;
    }

    public String getDiaChi() {
        return diaChi;
    }

    public void setDiaChi(String diaChi) {
        this.diaChi = diaChi;
    }
}
