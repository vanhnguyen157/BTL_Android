package com.example.android;

public class ThamQuan {
    private String maTq;
    private String diaChi;
    private String thoiGian;
    private String ngayThang;
    private String phuongTien;
    private String nguoiHoTro;

    public ThamQuan(String maTq, String diaChi, String thoiGian, String ngayThang, String phuongTien, String nguoiHoTro) {
        this.maTq = maTq;
        this.diaChi = diaChi;
        this.thoiGian = thoiGian;
        this.ngayThang = ngayThang;
        this.phuongTien = phuongTien;
        this.nguoiHoTro = nguoiHoTro;
    }

    public String getMaTq() {
        return maTq;
    }

    public void setMaTq(String maTq) {
        this.maTq = maTq;
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

    public String getPhuongTien() {
        return phuongTien;
    }

    public void setPhuongTien(String phuongTien) {
        this.phuongTien = phuongTien;
    }

    public String getNguoiHoTro() {
        return nguoiHoTro;
    }

    public void setNguoiHoTro(String nguoiHoTro) {
        this.nguoiHoTro = nguoiHoTro;
    }
}
